package com.example.model

import androidx.annotation.DrawableRes

/**
 * Language selection state: Trilingual (English, Hindi, Arabic RTL)
 */
enum class AppLanguage(val label: String, val shortCode: String) {
    ENGLISH("English", "EN"),
    HINDI("हिंदी", "हिं"),
    ARABIC("العربية", "عر")
}

/**
 * Helper to select localized string directly across all 3 languages
 */
fun tr(lang: AppLanguage, en: String, hi: String, ar: String): String = when (lang) {
    AppLanguage.ENGLISH -> en
    AppLanguage.HINDI -> hi
    AppLanguage.ARABIC -> ar.ifBlank { en }
}

/**
 * Localized Trilingual string (kept named Bilingual for seamless backwards compatibility)
 */
data class Bilingual(
    val en: String,
    val hi: String,
    val ar: String = ""
) {
    fun get(lang: AppLanguage): String = when (lang) {
        AppLanguage.ENGLISH -> en
        AppLanguage.HINDI -> hi
        AppLanguage.ARABIC -> ar.ifBlank { en }
    }
}

typealias Trilingual = Bilingual

/**
 * JCB Machine Model category & spec details
 */
data class JcbMachineModel(
    val id: String,
    val name: String,
    val series: String,
    val category: String,
    val tagHindi: String,
    val tagArabic: String = "",
    val engineSpec: Bilingual,
    val powerHp: String,
    val operatingWeight: String,
    val hydraulicPressureBar: String,
    val transmissionType: Bilingual,
    val keyFeatures: List<Bilingual>,
    val commonApplications: Bilingual,
    val maintenanceIntervalHours: String,
    val manualReference: String
) {
    fun tag(lang: AppLanguage): String = when (lang) {
        AppLanguage.ENGLISH -> series
        AppLanguage.HINDI -> tagHindi
        AppLanguage.ARABIC -> tagArabic.ifBlank { series }
    }
}

/**
 * Complete 15-Category Machine Parts System
 */
enum class SystemCategory(
    val id: String,
    val titleEn: String,
    val titleHi: String,
    val titleAr: String,
    val iconName: String
) {
    ENGINE("engine", "Engine System", "इंजन सिस्टम", "نظام المحرك", "engine"),
    HYDRAULIC("hydraulic", "Hydraulic System", "हाइड्रोलिक सिस्टम", "النظام الهيدروليكي", "hydraulic"),
    ELECTRICAL("electrical", "Electrical System", "इलेक्ट्रिकल सिस्टम", "النظام الكهربائي", "electric"),
    TRANSMISSION("transmission", "Transmission & Gearbox", "ट्रांसमिशन और गियरबॉक्स", "ناقل الحركة وصندوق التروس", "gearbox"),
    BRAKE("brake", "Brake System", "ब्रेक सिस्टम", "نظام الفرامل", "brake"),
    STEERING("steering", "Steering System", "स्टीयरिंग सिस्टम", "نظام التوجيه", "steering"),
    COOLING("cooling", "Cooling System", "कूलिंग सिस्टम", "نظام التبريد", "cooling"),
    FUEL("fuel", "Fuel System", "ईंधन (फ्यूल) सिस्टम", "نظام الوقود", "fuel"),
    FRONT_LOADER("front_loader", "Front Loader", "फ्रंट लोडर असेंबली", "المحمل الأمامي", "loader"),
    BACKHOE_DIPPER("backhoe_dipper", "Backhoe Assembly", "बैकहो और डिपर असेंबली", "مجموعة الحفار الخلفي", "backhoe"),
    CABIN_DASHBOARD("cabin_dashboard", "Cabin & Dashboard", "कैबिन और डैशबोर्ड", "المقصورة ولوحة القيادة", "dashboard"),
    AXLES_WHEELS("axles_wheels", "Wheels & Axles", "पहिए और एक्सल", "العجلات والمحاور", "axle"),
    SENSORS_SWITCHES("sensors_switches", "Sensors & Switches", "सेंसर और स्विच", "الحساسات والمفاتيح", "sensor"),
    FUSE_RELAY_WIRING("fuse_relay_wiring", "Fuse, Relay & Wiring", "फ्यूज, रिले और वायरिंग", "المصهرات والمرحلات والأسلاك", "fuse"),
    FILTERS_HOSES_SEALS("filters_hoses_seals", "Filters, Hoses & Seals", "फिल्टर, होज, सील व कनेक्टर", "الفلاتر والخراطيم وموانع التسرب", "filter");

    fun title(lang: AppLanguage): String = when (lang) {
        AppLanguage.ENGLISH -> titleEn
        AppLanguage.HINDI -> titleHi
        AppLanguage.ARABIC -> titleAr
    }
}

/**
 * Diagram node or part label on machine system
 */
data class DiagramPoint(
    val number: Int,
    val labelEn: String,
    val labelHi: String,
    val descriptionEn: String,
    val descriptionHi: String,
    val labelAr: String = "",
    val descriptionAr: String = ""
) {
    fun label(lang: AppLanguage): String = tr(lang, labelEn, labelHi, labelAr)
    fun description(lang: AppLanguage): String = tr(lang, descriptionEn, descriptionHi, descriptionAr)
}

/**
 * Front / Side / Connector visual inspection orientation note for a part
 */
data class PartViewAngle(
    val angleTitle: Bilingual,
    val calloutDetail: Bilingual
)

/**
 * A to Z Machine Part specification with verified HD Photo & Trilingual labels
 */
data class JcbPart(
    val id: String,
    val partNumber: String,
    val system: SystemCategory,
    val nameEn: String,
    val nameHi: String,
    val nameAr: String,
    @DrawableRes val imageResId: Int,
    val supportedModels: List<String> = listOf("JCB 3CX", "JCB 4CX", "JCB 3DX", "JCB 5CX", "CAT Backhoe"),
    val modelDifferences: List<Bilingual> = emptyList(),
    val viewAngles: List<PartViewAngle> = emptyList(),
    val location: Bilingual,
    val workingPrinciple: Bilingual,
    val damageSymptoms: List<Bilingual>,
    val inspectionProcedure: List<Bilingual>,
    val repairInstructions: List<Bilingual>,
    val safetyWarning: Bilingual,
    val torqueSpec: String,
    val diagramPoints: List<DiagramPoint>,
    val manualReference: String,
    val isBookmarked: Boolean = false
) {
    fun name(lang: AppLanguage): String = when (lang) {
        AppLanguage.ENGLISH -> nameEn
        AppLanguage.HINDI -> nameHi
        AppLanguage.ARABIC -> nameAr
    }
}

/**
 * Error Code & Warning light data
 */
data class JcbErrorCode(
    val code: String,
    val system: SystemCategory,
    val title: Bilingual,
    val severity: ErrorSeverity,
    val symptoms: Bilingual,
    val probableCauses: List<Bilingual>,
    val stepByStepTroubleshooting: List<Bilingual>,
    val warningLampType: String,
    val canOperate: Boolean,
    val officialManualNote: String
)

enum class ErrorSeverity {
    CRITICAL_STOP,
    WARNING_CAUTION,
    MAINTENANCE_ADVISORY
}

/**
 * Diagnostic guide for symptoms
 */
data class DiagnosticGuide(
    val id: String,
    val category: String,
    val title: Bilingual,
    val overview: Bilingual,
    val symptomChecks: List<DiagnosticStep>,
    val commonMistakes: Bilingual,
    val manualRef: String
)

data class DiagnosticStep(
    val stepNumber: Int,
    val title: Bilingual,
    val procedure: Bilingual,
    val expectedOutcome: Bilingual,
    val remedyIfFailed: Bilingual
)

/**
 * Mechanic Training Guide / Lesson
 */
data class TrainingLesson(
    val id: String,
    val title: Bilingual,
    val category: Bilingual,
    val estimatedMinutes: Int,
    val level: TrainingLevel,
    val audioScript: Bilingual,
    val toolsRequired: List<Bilingual>,
    val steps: List<TrainingStep>,
    val safetyChecklist: List<Bilingual>,
    val fluidCapacitiesOrTorque: Bilingual? = null
)

enum class TrainingLevel {
    BEGINNER_OPERATOR,
    INTERMEDIATE_TECHNICIAN,
    EXPERT_OVERHAUL
}

data class TrainingStep(
    val stepIndex: Int,
    val title: Bilingual,
    val description: Bilingual,
    val keyCaution: Bilingual? = null
)
