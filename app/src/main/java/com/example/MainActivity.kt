package com.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.model.AppLanguage
import com.example.model.tr
import com.example.ui.components.JcbBottomNavigation
import com.example.ui.components.JcbTopBar
import com.example.ui.screens.*
import com.example.ui.theme.JcbTheme
import com.example.viewmodel.AppScreen
import com.example.viewmodel.JcbViewModel

class MainActivity : ComponentActivity() {

    private val viewModel: JcbViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val uiState by viewModel.uiState.collectAsStateWithLifecycle()

            // Predictive back / back button navigation handler
            BackHandler(enabled = uiState.currentScreen != AppScreen.HOME) {
                viewModel.navigateBack()
            }

            // Enforce true Right-to-Left (RTL) layout whenever Arabic is selected
            val layoutDirection = if (uiState.language == AppLanguage.ARABIC) {
                LayoutDirection.Rtl
            } else {
                LayoutDirection.Ltr
            }

            CompositionLocalProvider(LocalLayoutDirection provides layoutDirection) {
                JcbTheme(darkTheme = uiState.isDarkTheme) {
                    val currentScreen = uiState.currentScreen
                    val lang = uiState.language
                    val isSubScreen = currentScreen in listOf(
                        AppScreen.PART_DETAIL,
                        AppScreen.MACHINE_DETAIL,
                        AppScreen.ERROR_CODE_DETAIL,
                        AppScreen.DIAGNOSTIC_DETAIL,
                        AppScreen.TRAINING_LESSON_DETAIL,
                        AppScreen.BOOKMARKS
                    )

                    val screenTitle = when (currentScreen) {
                        AppScreen.HOME -> tr(lang, "JCB Master Mechanic", "जेसीबी मास्टर मैकेनिक", "خبير صيانة JCB الشامل")
                        AppScreen.PARTS_CATALOG -> tr(lang, "A to Z Parts Image Library", "A-Z पार्ट्स फोटो लाइब्रेरी", "مكتبة صور القطع (A-Z)")
                        AppScreen.PART_DETAIL -> uiState.selectedPart?.name(lang) ?: tr(lang, "Part Detail", "पार्ट विवरण", "تفاصيل القطعة")
                        AppScreen.MACHINES_CATALOG -> tr(lang, "JCB Models Lineup", "जेसीबी मॉडल सूची", "موديلات JCB و CAT")
                        AppScreen.MACHINE_DETAIL -> uiState.selectedMachine?.name ?: tr(lang, "Machine Specifications", "मशीन विवरण", "مواصفات الآلة")
                        AppScreen.FAULT_FINDING -> tr(lang, "Fault Codes & Diagnostics", "फॉल्ट कोड एवं समस्या निदान", "أكواد الأعطال والتشخيص")
                        AppScreen.ERROR_CODE_DETAIL -> uiState.selectedErrorCode?.code ?: tr(lang, "Error Code", "एरर कोड", "كود العطل")
                        AppScreen.DIAGNOSTIC_DETAIL -> tr(lang, "Diagnostic Guide", "समस्या निदान गाइड", "دليل التشخيص")
                        AppScreen.TRAINING_ACADEMY -> tr(lang, "Mechanic Academy", "मैकेनिक एकेडमी", "أكاديمية الميكانيكي")
                        AppScreen.TRAINING_LESSON_DETAIL -> tr(lang, "Training Lesson", "प्रैक्टिकल ट्रेनिंग", "درس تدريبي عملي")
                        AppScreen.ELECTRICAL_MASTER -> tr(lang, "Electrical & Wiring Master", "इलेक्ट्रिकल एवं वायरिंग सिस्टम", "النظام الكهربائي والضفائر")
                        AppScreen.ADVANCED_MODULES -> tr(lang, "Heavy Machinery Modules", "हैवी मशीनरी मॉड्यूल्स", "وحدات الصيانة المتقدمة")
                        AppScreen.BOOKMARKS -> tr(lang, "Bookmarked Parts", "सहेजे गए पुर्जे", "القطع المحفوظة")
                        else -> tr(lang, "JCB Master Mechanic", "जेसीबी मास्टर मैकेनिक", "خبير صيانة JCB الشامل")
                    }

                    val subtitle = when (currentScreen) {
                        AppScreen.HOME -> tr(lang, "100% Offline • EN / हिंदी / العربية", "100% ऑफ़लाइन • 3 भाषाएँ", "يعمل 100% بدون إنترنت • 3 لغات")
                        AppScreen.PARTS_CATALOG -> tr(lang, "15 Systems • HD Studio Photos & Specs", "15 सिस्टम • HD फोटो और रिपेयर", "15 قسماً • صور عالية الدقة وإصلاح")
                        AppScreen.ELECTRICAL_MASTER -> tr(lang, "Harnesses, Lights, Relays, Schematics", "हार्नेस, लाइट, रिले, फ्यूज, मल्टीमीटर", "الضفائر، الإضاءة، المرحلات، المخططات")
                        AppScreen.ADVANCED_MODULES -> tr(lang, "Engine, Hydraulics, Fluids, Safety", "इंजन ओवरहाल, हाइड्रोलिक प्रेशर, फ्लूइड, सुरक्षा", "المحرك، الهيدروليك، الزيوت، السلامة")
                        AppScreen.FAULT_FINDING -> tr(lang, "Codes & Step Troubleshooting", "त्रुटि कोड एवं निवारण", "الأكواد وخطوات تتبع الأعطال")
                        AppScreen.TRAINING_ACADEMY -> tr(lang, "Audio Voice Tutorials", "ऑडियो एवं चरणबद्ध गाइड", "دروس صوتية وشروحات عملية")
                        else -> null
                    }

                    val bottomNavIndex = when (currentScreen) {
                        AppScreen.HOME -> 0
                        AppScreen.PARTS_CATALOG, AppScreen.PART_DETAIL -> 1
                        AppScreen.ELECTRICAL_MASTER -> 2
                        AppScreen.FAULT_FINDING, AppScreen.ERROR_CODE_DETAIL, AppScreen.DIAGNOSTIC_DETAIL -> 3
                        AppScreen.TRAINING_ACADEMY, AppScreen.TRAINING_LESSON_DETAIL -> 4
                        else -> 0
                    }

                    Scaffold(
                        modifier = Modifier.fillMaxSize(),
                        topBar = {
                            JcbTopBar(
                                title = screenTitle,
                                subtitle = subtitle,
                                currentLanguage = uiState.language,
                                isDarkTheme = uiState.isDarkTheme,
                                showBackButton = isSubScreen,
                                onBackClick = { viewModel.navigateBack() },
                                onLanguageSelected = { viewModel.setLanguage(it) },
                                onThemeToggle = { viewModel.toggleTheme() },
                                onBookmarkListClick = { viewModel.navigateTo(AppScreen.BOOKMARKS) }
                            )
                        },
                        bottomBar = {
                            JcbBottomNavigation(
                                selectedRouteIndex = bottomNavIndex,
                                onTabSelected = { index ->
                                    val targetScreen = when (index) {
                                        0 -> AppScreen.HOME
                                        1 -> AppScreen.PARTS_CATALOG
                                        2 -> AppScreen.ELECTRICAL_MASTER
                                        3 -> AppScreen.FAULT_FINDING
                                        4 -> AppScreen.TRAINING_ACADEMY
                                        else -> AppScreen.HOME
                                    }
                                    viewModel.navigateTo(targetScreen)
                                },
                                language = uiState.language
                            )
                        }
                    ) { innerPadding ->
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(innerPadding)
                        ) {
                            Crossfade(targetState = currentScreen, label = "screen_crossfade") { screen ->
                                when (screen) {
                                    AppScreen.HOME -> {
                                        HomeScreen(
                                            language = uiState.language,
                                            onNavigateToParts = { viewModel.navigateTo(AppScreen.PARTS_CATALOG) },
                                            onNavigateToModels = { viewModel.navigateTo(AppScreen.MACHINES_CATALOG) },
                                            onNavigateToFaults = { viewModel.navigateTo(AppScreen.FAULT_FINDING) },
                                            onNavigateToTraining = { viewModel.navigateTo(AppScreen.TRAINING_ACADEMY) },
                                            onNavigateToElectrical = { viewModel.navigateTo(AppScreen.ELECTRICAL_MASTER) },
                                            onNavigateToAdvancedModules = { viewModel.navigateTo(AppScreen.ADVANCED_MODULES) },
                                            onSelectMachine = { viewModel.selectMachine(it) },
                                            onSelectSystem = {
                                                viewModel.selectSystem(it)
                                                viewModel.navigateTo(AppScreen.PARTS_CATALOG)
                                            }
                                        )
                                    }
                                    AppScreen.ADVANCED_MODULES -> {
                                        AdvancedModulesScreen(
                                            language = uiState.language,
                                            selectedModule = uiState.selectedMachineModule,
                                            onModuleSelected = { viewModel.selectMachineModule(it) },
                                            searchQuery = uiState.searchQuery,
                                            onSearchQueryChange = { viewModel.setSearchQuery(it) },
                                            isSpeaking = uiState.isSpeaking,
                                            onSpeakVoice = { viewModel.speakText(it) }
                                        )
                                    }
                                    AppScreen.ELECTRICAL_MASTER -> {
                                        ElectricalMasterScreen(
                                            language = uiState.language,
                                            selectedCategory = uiState.selectedElectricalCategory,
                                            onCategorySelected = { viewModel.selectElectricalCategory(it) },
                                            searchQuery = uiState.searchQuery,
                                            onSearchQueryChange = { viewModel.setSearchQuery(it) },
                                            isSpeaking = uiState.isSpeaking,
                                            onSpeakVoice = { viewModel.speakText(it) }
                                        )
                                    }
                                    AppScreen.PARTS_CATALOG -> {
                                        PartsCatalogScreen(
                                            language = uiState.language,
                                            searchQuery = uiState.searchQuery,
                                            onSearchQueryChange = { viewModel.setSearchQuery(it) },
                                            bookmarkedPartIds = uiState.bookmarkedPartIds,
                                            onToggleBookmark = { viewModel.toggleBookmark(it) },
                                            onSelectPart = { viewModel.selectPart(it) },
                                            initialSystemFilter = uiState.selectedSystem,
                                            selectedModelFilter = uiState.selectedModelFilter,
                                            onModelFilterChange = { viewModel.setModelFilter(it) }
                                        )
                                    }
                                    AppScreen.PART_DETAIL -> {
                                        uiState.selectedPart?.let { part ->
                                            PartDetailScreen(
                                                part = part,
                                                language = uiState.language,
                                                isBookmarked = uiState.bookmarkedPartIds.contains(part.id),
                                                onToggleBookmark = { viewModel.toggleBookmark(part.id) },
                                                isSpeaking = uiState.isSpeaking,
                                                onSpeakVoice = { viewModel.speakText(it) }
                                            )
                                        }
                                    }
                                    AppScreen.MACHINES_CATALOG -> {
                                        MachinesCatalogScreen(
                                            language = uiState.language,
                                            onSelectMachine = { viewModel.selectMachine(it) }
                                        )
                                    }
                                    AppScreen.MACHINE_DETAIL -> {
                                        uiState.selectedMachine?.let { machine ->
                                            MachineDetailScreen(
                                                machine = machine,
                                                language = uiState.language,
                                                isSpeaking = uiState.isSpeaking,
                                                onSpeakVoice = { viewModel.speakText(it) }
                                            )
                                        }
                                    }
                                    AppScreen.FAULT_FINDING -> {
                                        FaultFindingScreen(
                                            language = uiState.language,
                                            searchQuery = uiState.searchQuery,
                                            onSearchQueryChange = { viewModel.setSearchQuery(it) },
                                            activeTab = uiState.activeTabInFaults,
                                            onTabSelected = { viewModel.setFaultsTab(it) },
                                            onSelectErrorCode = { viewModel.selectErrorCode(it) },
                                            onSelectDiagnosticGuide = { viewModel.selectDiagnosticGuide(it) }
                                        )
                                    }
                                    AppScreen.ERROR_CODE_DETAIL -> {
                                        uiState.selectedErrorCode?.let { errorCode ->
                                            ErrorCodeDetailScreen(
                                                errorCode = errorCode,
                                                language = uiState.language,
                                                isSpeaking = uiState.isSpeaking,
                                                onSpeakVoice = { viewModel.speakText(it) }
                                            )
                                        }
                                    }
                                    AppScreen.DIAGNOSTIC_DETAIL -> {
                                        uiState.selectedDiagnosticGuide?.let { guide ->
                                            DiagnosticDetailScreen(
                                                guide = guide,
                                                language = uiState.language,
                                                isSpeaking = uiState.isSpeaking,
                                                onSpeakVoice = { viewModel.speakText(it) }
                                            )
                                        }
                                    }
                                    AppScreen.TRAINING_ACADEMY -> {
                                        TrainingAcademyScreen(
                                            language = uiState.language,
                                            onSelectLesson = { viewModel.selectTrainingLesson(it) }
                                        )
                                    }
                                    AppScreen.TRAINING_LESSON_DETAIL -> {
                                        uiState.selectedTrainingLesson?.let { lesson ->
                                            TrainingLessonDetailScreen(
                                                lesson = lesson,
                                                language = uiState.language,
                                                isSpeaking = uiState.isSpeaking,
                                                onSpeakVoice = { viewModel.speakText(it) }
                                            )
                                        }
                                    }
                                    AppScreen.BOOKMARKS -> {
                                        BookmarksScreen(
                                            language = uiState.language,
                                            bookmarkedPartIds = uiState.bookmarkedPartIds,
                                            onToggleBookmark = { viewModel.toggleBookmark(it) },
                                            onSelectPart = { viewModel.selectPart(it) }
                                        )
                                    }
                                    else -> {
                                        HomeScreen(
                                            language = uiState.language,
                                            onNavigateToParts = { viewModel.navigateTo(AppScreen.PARTS_CATALOG) },
                                            onNavigateToModels = { viewModel.navigateTo(AppScreen.MACHINES_CATALOG) },
                                            onNavigateToFaults = { viewModel.navigateTo(AppScreen.FAULT_FINDING) },
                                            onNavigateToTraining = { viewModel.navigateTo(AppScreen.TRAINING_ACADEMY) },
                                            onNavigateToElectrical = { viewModel.navigateTo(AppScreen.ELECTRICAL_MASTER) },
                                            onNavigateToAdvancedModules = { viewModel.navigateTo(AppScreen.ADVANCED_MODULES) },
                                            onSelectMachine = { viewModel.selectMachine(it) },
                                            onSelectSystem = {
                                                viewModel.selectSystem(it)
                                                viewModel.navigateTo(AppScreen.PARTS_CATALOG)
                                            }
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
