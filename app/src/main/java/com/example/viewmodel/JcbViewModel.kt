package com.example.viewmodel

import android.app.Application
import android.speech.tts.TextToSpeech
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.model.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.util.Locale

/**
 * Main application navigation destination
 */
enum class AppScreen {
    HOME,
    MACHINES_CATALOG,
    MACHINE_DETAIL,
    PARTS_CATALOG,
    PART_DETAIL,
    SYSTEMS_EXPLORER,
    SYSTEM_DETAIL,
    FAULT_FINDING,
    ERROR_CODE_DETAIL,
    DIAGNOSTIC_DETAIL,
    TRAINING_ACADEMY,
    TRAINING_LESSON_DETAIL,
    ELECTRICAL_MASTER,
    ADVANCED_MODULES,
    BOOKMARKS,
    SETTINGS
}

data class AppUiState(
    val currentScreen: AppScreen = AppScreen.HOME,
    val selectedMachine: JcbMachineModel? = null,
    val selectedPart: JcbPart? = null,
    val selectedSystem: SystemCategory? = null,
    val selectedModelFilter: String? = null,
    val selectedErrorCode: JcbErrorCode? = null,
    val selectedDiagnosticGuide: DiagnosticGuide? = null,
    val selectedTrainingLesson: TrainingLesson? = null,
    val selectedElectricalCategory: ElectricalCategory = ElectricalCategory.HARNESSES,
    val selectedMachineModule: MachineModuleType = MachineModuleType.ENGINE_OVERHAUL,
    val language: AppLanguage = AppLanguage.ENGLISH,
    val isDarkTheme: Boolean = true,
    val searchQuery: String = "",
    val bookmarkedPartIds: Set<String> = setOf("part_main_hydraulic_pump", "part_turbocharger"),
    val isSpeaking: Boolean = false,
    val activeTabInFaults: Int = 0
)

class JcbViewModel(application: Application) : AndroidViewModel(application), TextToSpeech.OnInitListener {

    private val _uiState = MutableStateFlow(AppUiState())
    val uiState: StateFlow<AppUiState> = _uiState.asStateFlow()

    private var textToSpeech: TextToSpeech? = null
    private var isTtsReady = false

    private val backStack = mutableListOf<AppScreen>()

    init {
        try {
            textToSpeech = TextToSpeech(application.applicationContext, this)
        } catch (_: Exception) {
            // Graceful fallback if TTS engine unavailable
        }
    }

    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            isTtsReady = true
            setTtsLanguage(_uiState.value.language)
        }
    }

    private fun setTtsLanguage(lang: AppLanguage) {
        textToSpeech?.let { tts ->
            val locale = when (lang) {
                AppLanguage.ENGLISH -> Locale.US
                AppLanguage.HINDI -> Locale("hi", "IN")
                AppLanguage.ARABIC -> Locale("ar", "SA")
            }
            tts.language = locale
        }
    }

    fun setLanguage(lang: AppLanguage) {
        if (_uiState.value.language == lang) return
        _uiState.value = _uiState.value.copy(language = lang)
        setTtsLanguage(lang)
        if (_uiState.value.isSpeaking) {
            stopVoice()
        }
    }

    fun toggleLanguage() {
        val nextLang = when (_uiState.value.language) {
            AppLanguage.ENGLISH -> AppLanguage.HINDI
            AppLanguage.HINDI -> AppLanguage.ARABIC
            AppLanguage.ARABIC -> AppLanguage.ENGLISH
        }
        setLanguage(nextLang)
    }

    fun toggleTheme() {
        _uiState.value = _uiState.value.copy(isDarkTheme = !_uiState.value.isDarkTheme)
    }

    fun setSearchQuery(query: String) {
        _uiState.value = _uiState.value.copy(searchQuery = query)
    }

    fun setModelFilter(model: String?) {
        _uiState.value = _uiState.value.copy(selectedModelFilter = model)
    }

    fun setFaultsTab(tab: Int) {
        _uiState.value = _uiState.value.copy(activeTabInFaults = tab)
    }

    fun selectElectricalCategory(category: ElectricalCategory) {
        _uiState.value = _uiState.value.copy(selectedElectricalCategory = category)
    }

    fun selectMachineModule(module: MachineModuleType) {
        _uiState.value = _uiState.value.copy(selectedMachineModule = module)
    }

    fun toggleBookmark(partId: String) {
        val current = _uiState.value.bookmarkedPartIds
        val updated = if (current.contains(partId)) current - partId else current + partId
        _uiState.value = _uiState.value.copy(bookmarkedPartIds = updated)
    }

    fun navigateTo(screen: AppScreen) {
        if (_uiState.value.currentScreen != screen) {
            backStack.add(_uiState.value.currentScreen)
            _uiState.value = _uiState.value.copy(currentScreen = screen)
        }
    }

    fun navigateBack(): Boolean {
        if (_uiState.value.isSpeaking) {
            stopVoice()
        }
        if (backStack.isNotEmpty()) {
            val previous = backStack.removeAt(backStack.size - 1)
            _uiState.value = _uiState.value.copy(currentScreen = previous)
            return true
        }
        if (_uiState.value.currentScreen != AppScreen.HOME) {
            _uiState.value = _uiState.value.copy(currentScreen = AppScreen.HOME)
            return true
        }
        return false
    }

    fun selectMachine(machine: JcbMachineModel) {
        _uiState.value = _uiState.value.copy(selectedMachine = machine)
        navigateTo(AppScreen.MACHINE_DETAIL)
    }

    fun selectPart(part: JcbPart) {
        _uiState.value = _uiState.value.copy(selectedPart = part)
        navigateTo(AppScreen.PART_DETAIL)
    }

    fun selectSystem(system: SystemCategory?) {
        _uiState.value = _uiState.value.copy(selectedSystem = system)
    }

    fun selectErrorCode(code: JcbErrorCode) {
        _uiState.value = _uiState.value.copy(selectedErrorCode = code)
        navigateTo(AppScreen.ERROR_CODE_DETAIL)
    }

    fun selectDiagnosticGuide(guide: DiagnosticGuide) {
        _uiState.value = _uiState.value.copy(selectedDiagnosticGuide = guide)
        navigateTo(AppScreen.DIAGNOSTIC_DETAIL)
    }

    fun selectTrainingLesson(lesson: TrainingLesson) {
        _uiState.value = _uiState.value.copy(selectedTrainingLesson = lesson)
        navigateTo(AppScreen.TRAINING_LESSON_DETAIL)
    }

    fun speakText(text: String) {
        if (!isTtsReady || textToSpeech == null) return
        viewModelScope.launch {
            if (_uiState.value.isSpeaking) {
                stopVoice()
            } else {
                setTtsLanguage(_uiState.value.language)
                textToSpeech?.speak(text, TextToSpeech.QUEUE_FLUSH, null, "JCB_TTS")
                _uiState.value = _uiState.value.copy(isSpeaking = true)
            }
        }
    }

    fun stopVoice() {
        textToSpeech?.stop()
        _uiState.value = _uiState.value.copy(isSpeaking = false)
    }

    override fun onCleared() {
        super.onCleared()
        textToSpeech?.stop()
        textToSpeech?.shutdown()
    }
}
