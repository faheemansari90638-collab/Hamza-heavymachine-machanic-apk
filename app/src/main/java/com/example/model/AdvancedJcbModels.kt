package com.example.model

/**
 * Advanced Heavy Machine System Module Categories
 */
enum class MachineModuleType(
    val id: String,
    val titleEn: String,
    val titleHi: String,
    val titleAr: String,
    val iconName: String
) {
    ENGINE_OVERHAUL("engine_overhaul", "Engine Overhaul & Rebuild", "इंजन ओवरहाल और रीबिल्ड", "عمرة وإصلاح المحرك", "engineering"),
    HYDRAULIC_TESTING("hydraulic_testing", "Hydraulic Pressure Testing", "हाइड्रोलिक प्रेशर व रिलीफ वॉल्व टेस्टिंग", "فحص الضغط الهيدروليكي", "water_drop"),
    TRANSMISSION_DRIVETRAIN("transmission_drive", "Transmission & Differential", "गियरबॉक्स, कनवर्टर व डिफरेंशियल", "ناقل الحركة والدفرنس", "settings"),
    DASHBOARD_SYMBOLS("dashboard_symbols", "Warning Lights & Cluster", "डैशबोर्ड सिंबल और वॉर्निंग लाइट्स", "رموز التحذير ولوحة القيادة", "warning"),
    ATTACHMENTS_JOYSTICK("attachments_joystick", "Buckets, Breakers & Joysticks", "अटैचमेंट्स, ब्रेकर और जॉयस्टिक", "المرفقات والجاك همر وعصا التحكم", "construction"),
    BRAKE_AXLE_STEERING("brake_axle_steer", "Brakes, Axles & Steering", "ब्रेक, एक्सल और स्टीयरिंग", "الفرامل والمحاور والتوجيه", "tire_repair"),
    MAINTENANCE_SCHEDULES("maintenance_sched", "Model-Wise PM Schedules", "मॉडल अनुसार मेंटेनेंस शेड्यूल", "جداول الصيانة الدورية حسب الطراز", "calendar_month"),
    LUBRICANTS_FILTERS("lubricants_filters", "Oils, Coolants & Filters", "इंजन, हाइड्रोलिक ऑयल व फिल्टर गाइड", "دليل الزيوت وسوائل التبريد والفلاتر", "oil_barrel"),
    DIAGNOSTIC_CALIBRATION("diag_calibration", "ECU Scanner & Calibration", "ईसीयू स्कैनर और कैलिब्रेशन", "جهاز الفحص والمعايرة الإلكترونية", "terminal"),
    MECHANIC_SAFETY("mechanic_safety", "Operator & Mechanic Safety", "ऑपरेटर एवं मैकेनिक सुरक्षा नियम", "سلامة المشغل والميكانيكي", "health_and_safety"),
    EXPLODED_CATALOGUE("exploded_catalogue", "Exploded Parts Diagrams", "एक्सप्लोडेड पार्ट्स कैटलॉग (चित्र सहित)", "مخططات قطع الغيار المفصلة", "schema"),
    VIDEO_MASTERCLASS("video_tutorials", "Video Tutorials & Masterclass", "वीडियो ट्यूटोरियल्स और मास्टरक्लास", "دروس الفيديو والتدريب العملي", "play_circle");

    fun title(lang: AppLanguage): String = tr(lang, titleEn, titleHi, titleAr)
}

/**
 * Engine Overhaul Specification & Rebuild Steps
 */
data class EngineOverhaulSpec(
    val engineModel: String,
    val cylinderBoreStroke: String,
    val displacementCc: String,
    val cylinderHeadTorqueStages: List<Bilingual>,
    val mainBearingTorque: Bilingual,
    val bigEndRodTorque: Bilingual,
    val valveClearanceCold: Bilingual,
    val pistonRingGapSpecs: Bilingual,
    val stepByStepRebuildProcedure: List<Bilingual>,
    val criticalFailurePoints: List<Bilingual>,
    val manualReference: String
)

/**
 * Hydraulic System Circuit & Pressure Calibration Point
 */
data class HydraulicCalibrationPoint(
    val circuitName: Bilingual,
    val testPortLocation: Bilingual,
    val testGaugeRatingBar: String,
    val targetPressureBar: String,
    val adjustmentProcedure: List<Bilingual>,
    val symptomsIfHigh: Bilingual,
    val symptomsIfLow: Bilingual,
    val applicableMachines: List<String>
)

/**
 * Transmission, Converter, and Axle Differential System
 */
data class DrivetrainSystemSpec(
    val systemName: Bilingual,
    val machineModels: List<String>,
    val operatingPrinciple: Bilingual,
    val oilCapacityAndGrade: Bilingual,
    val linePressuresBar: Bilingual,
    val rebuildAndInspectionSteps: List<Bilingual>,
    val differentialCrownPinionBacklash: Bilingual,
    val commonFailureModes: List<Bilingual>,
    val manualReference: String
)

/**
 * Dashboard Warning Symbol
 */
data class DashboardSymbol(
    val symbolId: String,
    val nameEn: String,
    val nameHi: String,
    val colorTone: SymbolColor,
    val symbolGlyph: String,
    val triggerCondition: Bilingual,
    val operatorImmediateAction: Bilingual,
    val underlyingMechanicalCause: Bilingual,
    val isCriticalShutdown: Boolean,
    val nameAr: String = ""
) {
    fun name(lang: AppLanguage): String = tr(lang, nameEn, nameHi, nameAr)
}

enum class SymbolColor {
    RED_STOP,
    AMBER_CAUTION,
    BLUE_INFO,
    GREEN_ACTIVE
}

/**
 * Heavy Attachment / Breaker & Joystick Spec
 */
data class AttachmentSpec(
    val attachmentName: Bilingual,
    val compatibleMachines: List<String>,
    val hydraulicFlowReqLpm: String,
    val operatingPressureBar: String,
    val nitrogenGasChargeBar: String,
    val joystickControlMethod: Bilingual,
    val maintenanceInspection: List<Bilingual>,
    val safetyOperatingRules: List<Bilingual>
)

/**
 * Lubricants, Fluids and Filter Replacement Directory
 */
data class FluidAndFilterGuide(
    val compartment: Bilingual,
    val factoryCapacityLiters: String,
    val recommendedGradeEn: String,
    val recommendedGradeHi: String,
    val jcbSpecification: String,
    val changeIntervalHours: String,
    val filterPartNumber: String,
    val fillingProcedure: List<Bilingual>,
    val contaminationWarnings: Bilingual,
    val recommendedGradeAr: String = ""
) {
    fun recommendedGrade(lang: AppLanguage): String = tr(lang, recommendedGradeEn, recommendedGradeHi, recommendedGradeAr)
}

/**
 * Diagnostic Scanner & ECU Calibration Procedure
 */
data class EcuCalibrationGuide(
    val calibrationName: Bilingual,
    val supportedModels: List<String>,
    val prerequisites: List<Bilingual>,
    val stepByStepProcedure: List<Bilingual>,
    val successConfirmation: Bilingual,
    val troubleCodesResetSteps: List<Bilingual>,
    val manualReference: String
)

/**
 * Operator and Mechanic Safety Protocols
 */
data class SafetyProtocol(
    val topicEn: String,
    val topicHi: String,
    val hazardType: Bilingual,
    val mandatoryChecklist: List<Bilingual>,
    val prohibitedActions: List<Bilingual>,
    val emergencyProcedures: Bilingual,
    val topicAr: String = ""
) {
    fun topic(lang: AppLanguage): String = tr(lang, topicEn, topicHi, topicAr)
}

/**
 * Exploded View Spare Part Assembly
 */
data class ExplodedViewAssembly(
    val assemblyId: String,
    val titleEn: String,
    val titleHi: String,
    val machineCategory: String,
    val explodedDiagramNodes: List<ExplodedPartNode>,
    val serviceNotes: Bilingual,
    val titleAr: String = ""
) {
    fun title(lang: AppLanguage): String = tr(lang, titleEn, titleHi, titleAr)
}

data class ExplodedPartNode(
    val itemNumber: Int,
    val partNameEn: String,
    val partNameHi: String,
    val partNumber: String,
    val quantity: Int,
    val torqueOrFitmentSpec: String? = null,
    val partNameAr: String = ""
) {
    fun partName(lang: AppLanguage): String = tr(lang, partNameEn, partNameHi, partNameAr)
}

/**
 * Practical Video Tutorial / Masterclass Lesson
 */
data class VideoTutorialLesson(
    val videoId: String,
    val titleEn: String,
    val titleHi: String,
    val durationMin: Int,
    val presenterInstructor: Bilingual,
    val videoKeyPoints: List<Bilingual>,
    val downloadableOfflineSizeMb: String,
    val isCachedOffline: Boolean = true,
    val titleAr: String = ""
) {
    fun title(lang: AppLanguage): String = tr(lang, titleEn, titleHi, titleAr)
}
