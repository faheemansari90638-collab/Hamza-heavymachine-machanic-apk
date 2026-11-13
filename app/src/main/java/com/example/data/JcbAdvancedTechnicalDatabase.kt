package com.example.data

import com.example.model.*

object JcbAdvancedTechnicalDatabase {

    // 1. COMPLETE ENGINE OVERHAUL & REBUILD DATABASE
    val engineOverhauls: List<EngineOverhaulSpec> = listOf(
        EngineOverhaulSpec(
            engineModel = "JCB EcoMAX 4.4L 4-Cylinder (Tier 4 / CEV Stage IV)",
            cylinderBoreStroke = "Bore: 103.00 mm (4.055 in) | Stroke: 132.00 mm (5.197 in)",
            displacementCc = "4,399 cc (4.4 Litres)",
            cylinderHeadTorqueStages = listOf(
                Bilingual("Stage 1: Torque all cylinder head bolts in spiral sequence starting from center outwards to 60 Nm (44 lbf ft)", "चरण 1: हेड के सभी बोल्टों को केंद्र से बाहर की ओर घुमावदार क्रम में 60 Nm पर कसें"),
                Bilingual("Stage 2: Torque in identical sequence to 140 Nm (103 lbf ft)", "चरण 2: उसी क्रम में टॉर्क को 140 Nm पर बढ़ाएं"),
                Bilingual("Stage 3: Tighten each bolt an additional 90 degrees angle (+90°)", "चरण 3: प्रत्येक बोल्ट को 90 डिग्री अतिरिक्त घुमाएं (+90°)"),
                Bilingual("Stage 4: Tighten each bolt a final 90 degrees angle (+90°) for total 180° torque-to-yield", "चरण 4: अंतिम 90 डिग्री और घुमाएं (कुल 180 डिग्री स्ट्रेच टाइट)")
            ),
            mainBearingTorque = Bilingual(
                en = "Stage 1: 50 Nm | Stage 2: 115 Nm | Stage 3: +90° Angle tighten using angle gauge",
                hi = "चरण 1: 50 Nm | चरण 2: 115 Nm | चरण 3: 90 डिग्री कोण घुमाव (एंगल टाइटनिंग)"
            ),
            bigEndRodTorque = Bilingual(
                en = "Fracture-Split Connecting Rods: Stage 1: 35 Nm | Stage 2: 80 Nm | Stage 3: +90°",
                hi = "क्रैक्ड-कैप कनेक्टिंग रॉड: चरण 1: 35 Nm | चरण 2: 80 Nm | चरण 3: +90 डिग्री"
            ),
            valveClearanceCold = Bilingual(
                en = "Inlet Valves: 0.25 mm (0.010 in) | Exhaust Valves: 0.45 mm (0.018 in) - Set at Cold Engine",
                hi = "इनलेट वाल्व (ठंडे इंजन पर): 0.25 mm | एग्जॉस्ट वाल्व (ठंडे इंजन पर): 0.45 mm"
            ),
            pistonRingGapSpecs = Bilingual(
                en = "Top Compression Ring End Gap: 0.35 - 0.50 mm | 2nd Scraper Ring: 0.60 - 0.85 mm | Oil Control Ring: 0.25 - 0.55 mm",
                hi = "टॉप रिंग गैप: 0.35 - 0.50 mm | दूसरा स्क्रैपर रिंग: 0.60 - 0.85 mm | ऑयल रिंग: 0.25 - 0.55 mm"
            ),
            stepByStepRebuildProcedure = listOf(
                Bilingual("1. Measure cylinder liner cross-hatch hone angle (45°) and bore ovality with cylinder bore gauge (max 0.05 mm)", "1. सिलेंडर बोर गेज से बोर का अंडाकार घिसाव नापें (0.05 mm से कम होना चाहिए)"),
                Bilingual("2. Check crankshaft main journal oil clearance using Plastigauge (standard clearance: 0.040 - 0.085 mm)", "2. प्लास्टिगेज से मेन बेयरिंग का ऑयल क्लीयरेंस नापें (0.040 से 0.085 mm)"),
                Bilingual("3. Align piston ring gaps: Stagger end gaps at 120-degree intervals around piston circumference; never align over wrist pin", "3. पिस्टन रिंग के कट को 120-120 डिग्री के फासले पर रखें; कभी भी पिन की सीध में न रखें"),
                Bilingual("4. Time engine geartrain: Match timing gear punch marks: Idler gear '1' meshes with Crank gear '1', and '2' with Cam gear '2'", "4. टाइमिंग गियर के पंच मार्क मिलाएं: क्रैंक का '1' आइडलर के '1' से और कैम का '2' आइडलर के '2' से मिलाएं"),
                Bilingual("5. Pre-lubricate engine oil pump and pour 100ml oil into filter head before initial dry crank", "5. ऑयल पंप में नया तेल भरें ताकि पहली बार स्टार्ट करते समय सूखा न चले")
            ),
            criticalFailurePoints = listOf(
                Bilingual("Reusing cylinder head stretch bolts: Yield bolts stretch permanently and will snap inside block if reused", "हेड के टॉर्क-टू-यील्ड खिंचाव बोल्ट दोबारा कभी न लगाएं; हमेशा नए बोल्ट लगाएं"),
                Bilingual("Installing pistons backwards: Front arrow marking on piston crown MUST point toward engine front fan pulley", "पिस्टन उल्टा लगाना: पिस्टन के ऊपर का तीर का निशान हमेशा आगे पंखे की तरफ होना चाहिए")
            ),
            manualReference = "JCB EcoMAX 4.4L Workshop Overhaul Manual 9806/3000 Section B-1"
        ),
        EngineOverhaulSpec(
            engineModel = "Caterpillar 3054C / Perkins 1104C (Fitted in CAT 424 / 416 Backhoe Loaders)",
            cylinderBoreStroke = "Bore: 105.00 mm (4.13 in) | Stroke: 127.00 mm (5.00 in)",
            displacementCc = "4,400 cc (4.4 Litres)",
            cylinderHeadTorqueStages = listOf(
                Bilingual("Short Bolts: 110 Nm (81 lbf ft) | Medium Bolts: 110 Nm | Long Bolts: 110 Nm", "छोटे, मध्यम और लंबे सभी बोल्टों को पहले 110 Nm पर कसें"),
                Bilingual("Final tighten in sequence: Short bolts +150°, Medium bolts +180°, Long bolts +210°", "अंतिम खिंचाव: छोटे बोल्ट 150°, मध्यम बोल्ट 180°, लंबे बोल्ट 210° कोण घुमाएं")
            ),
            mainBearingTorque = Bilingual("Main Bearing Caps: 265 Nm (195 lbf ft)", "मेन बेयरिंग कैप्स: 265 Nm"),
            bigEndRodTorque = Bilingual("Connecting Rod Bolts: 40 Nm + 120° Angle", "कनेक्टिंग रॉड बोल्ट: 40 Nm + 120 डिग्री"),
            valveClearanceCold = Bilingual("Inlet: 0.20 mm (0.008 in) | Exhaust: 0.45 mm (0.018 in)", "इनलेट: 0.20 mm | एग्जॉस्ट: 0.45 mm"),
            pistonRingGapSpecs = Bilingual("Top Ring: 0.30 - 0.45 mm | Second Ring: 0.70 - 0.95 mm", "पहला रिंग: 0.30 - 0.45 mm | दूसरा रिंग: 0.70 - 0.95 mm"),
            stepByStepRebuildProcedure = listOf(
                Bilingual("Check piston height protrusion above block deck (spec: 0.21 - 0.35 mm to select correct head gasket notch thickness)", "पिस्टन की ब्लॉक से बाहर निकलने की ऊंचाई नापें ताकि सही नोच वाला हेड गैस्केट चुना जा सके"),
                Bilingual("Torque flywheel bolts in star sequence to 105 Nm + 90°", "फ्लाईव्हील बोल्ट को 105 Nm + 90 डिग्री पर कसें")
            ),
            criticalFailurePoints = listOf(
                Bilingual("Wrong head gasket thickness notch leads to piston kissing cylinder head valves", "गलत नोच का गैस्केट लगाने से पिस्टन वाल्व से टकरा जाता है")
            ),
            manualReference = "CAT Backhoe Loader 424B Engine Disassembly & Assembly Manual (RENR6400)"
        )
    )

    // 2. COMPLETE HYDRAULIC SYSTEM PRESSURE TESTING & CALIBRATION
    val hydraulicCalibrations: List<HydraulicCalibrationPoint> = listOf(
        HydraulicCalibrationPoint(
            circuitName = Bilingual("Main Relief Valve (MRV) System Pressure", "मेन रिलीफ वॉल्व (MRV) सिस्टम प्रेशर", "ضغط صمام التنفيس الرئيسي (MRV)"),
            testPortLocation = Bilingual("Quick-release test coupling located on main valve inlet manifold block under cabin", "कैबिन के नीचे मेन वॉल्व ब्लॉक के इनलेट मैनिफोल्ड पर लगा टेस्ट पोर्ट", "منفذ فحص سريع على مجمع مدخل الصمام الرئيسي أسفل المقصورة"),
            testGaugeRatingBar = "0 - 400 bar (0 - 6,000 psi) Glycerine-filled Gauge",
            targetPressureBar = "250 bar ± 5 bar (3,625 psi) at 1500 Engine RPM",
            adjustmentProcedure = listOf(
                Bilingual("1. Warm hydraulic oil to standard working temperature (50°C - 60°C)", "1. हाइड्रोलिक तेल को 50°C से 60°C तक सामान्य गर्म करें"),
                Bilingual("2. Connect 400-bar test gauge hose with clean quick-coupler to MRV test point", "2. MRV टेस्ट पोर्ट पर 400 बार का प्रेशर गेज पाइप लगाएं"),
                Bilingual("3. Bottom out (stall) the backhoe bucket crowd cylinder fully against its mechanical stops at 1500 RPM", "3. 1500 RPM पर बकेट को पूरा बंद करके रोकें"),
                Bilingual("4. Loosen MRV 19mm locknut; turn center hex screw clockwise to increase pressure or anti-clockwise to decrease (1 full turn ≈ 55 bar)", "4. 19mm लॉक नट ढीला करें; 6mm एलन की से क्लॉकवाइज घुमाने पर प्रेशर बढ़ता है (1 चक्कर ≈ 55 बार)"),
                Bilingual("5. Retighten locknut while holding center screw stationary with Allen key", "5. सेंटर पेंच को पकड़कर लॉक नट को अच्छी तरह कसें")
            ),
            symptomsIfHigh = Bilingual("Hydraulic hoses blow apart, cylinder head welds crack, pump shaft shears", "पाइप फटने लगते हैं, सिलेंडर के मुंह के वेल्डिंग टूटते हैं और पंप शाफ्ट कट जाती है"),
            symptomsIfLow = Bilingual("Severe loss of digging force; bucket cannot penetrate hard clay or rock", "मशीन की खुदाई की ताकत खत्म हो जाती है; सख्त मिट्टी में बकेट नहीं घुसती"),
            applicableMachines = listOf("JCB 3DX", "JCB 3CX Eco", "JCB 4CX", "JCB 5CX", "CAT 424B")
        ),
        HydraulicCalibrationPoint(
            circuitName = Bilingual("Unloader Valve (Pump Flow Cut-out Calibration)", "अनलोडर वॉल्व (पंप कट-आउट प्रेशर सेटिंग)", "صمام التفريغ (معايرة فصل تدفق المضخة)"),
            testPortLocation = Bilingual("Test port situated on dual-gear pump unloader manifold", "पंप के ऊपर लगे अनलोडर मैनिफोल्ड टेस्ट पोर्ट पर", "منفذ الفحص على مجمع تفريغ المضخة الترسية المزدوجة"),
            testGaugeRatingBar = "0 - 400 bar Gauge",
            targetPressureBar = "Cut-out at 205 bar (2,970 psi) | Resets at 180 bar",
            adjustmentProcedure = listOf(
                Bilingual("1. Install gauge on pump test port; accelerate to maximum engine rated speed (2200 RPM)", "1. टेस्ट पोर्ट पर गेज लगाएं और 2200 आरपीएम रेस दें"),
                Bilingual("2. Slowly operate boom raise lever; observe the instant pressure drops as second pump unloads", "2. बूम लीवर खींचें और देखें कि किस प्रेशर पर दूसरा पंप कटता है"),
                Bilingual("3. Adjust unloader cartridge screw so second pump unloads at exactly 205 bar to protect engine from stalling", "3. अनलोडर वाल्व को 205 बार पर सेट करें ताकि लोड पड़ने पर इंजन न दबे")
            ),
            symptomsIfHigh = Bilingual("Engine lugs down and stalls when lifting full loader bucket under speed", "लोडर उठाते समय इंजन पर भारी लोड पड़ता है और इंजन बंद हो जाता है"),
            symptomsIfLow = Bilingual("Slow boom lifting speeds despite healthy engine RPM", "आरपीएम सही होने पर भी बूम बहुत धीमी गति से ऊपर उठता है"),
            applicableMachines = listOf("JCB 3DX Super", "JCB 3CX", "JCB 2DX")
        ),
        HydraulicCalibrationPoint(
            circuitName = Bilingual("Auxiliary Circuit Relief Valve (Rock Breaker ARV)", "ऑक्जिलरी रॉक ब्रेकर रिलीफ वॉल्व (ARV)", "صمام تنفيس الدائرة المساعدة للجاك همر (ARV)"),
            testPortLocation = Bilingual("Auxiliary hammer pipe quick couplers on backhoe dipper end", "डिपर के छोर पर लगे ब्रेकर पाइप के टेस्ट कपलर पर", "قارنات أنابيب الهمر السريعة بنهاية ذراع الحفار"),
            testGaugeRatingBar = "0 - 250 bar Gauge",
            targetPressureBar = "165 bar ± 5 bar (2,390 psi) - Strictly as per hammer specification",
            adjustmentProcedure = listOf(
                Bilingual("1. Cap the return pipe; attach pressure gauge to feed line", "1. रिटर्न पाइप बंद करें और प्रेशर लाइन में गेज लगाएं"),
                Bilingual("2. Depress auxiliary foot pedal or joystick hammer trigger button", "2. ब्रेकर का फुट पेडल या जॉयस्टिक बटन दबाएं"),
                Bilingual("3. Adjust hammer auxiliary relief valve (ARV) cartridge to exactly 165 bar. Never set higher than hammer rating to avoid busting hammer seals", "3. ब्रेकर ARV को ठीक 165 बार पर सेट करें; ज्यादा रखने पर ब्रेकर की ऑयल सीलें फट जाती हैं")
            ),
            symptomsIfHigh = Bilingual("Breaker internal nitrogen diaphragm ruptures, tie rods break", "रॉक ब्रेकर का नाइट्रोजन डायफ्राम फट जाता है और टाइ-रॉड टूट जाते हैं"),
            symptomsIfLow = Bilingual("Breaker strikes weakly or fails to strike hard basalt rock", "ब्रेकर बहुत हल्के वार करता है और पत्थर नहीं तोड़ पाता"),
            applicableMachines = listOf("JCB 3DX", "JCB 3CX", "JCB 4CX", "JCB NXT 215", "CAT 424B")
        )
    )

    // 3. GEARBOX, TRANSMISSION, TORQUE CONVERTER & DIFFERENTIAL
    val drivetrainSpecs: List<DrivetrainSystemSpec> = listOf(
        DrivetrainSystemSpec(
            systemName = Bilingual("JCB Synchroshuttle SS700 4-Speed Reversing Transmission", "जेसीबी सिंक्रोशटल SS700 4-स्पीड गियरबॉक्स", "ناقل الحركة JCB Synchroshuttle SS700 رباعي السرعات"),
            machineModels = listOf("JCB 3DX", "JCB 3CX", "CAT 424B Shuttle"),
            operatingPrinciple = Bilingual(
                en = "Integrates a hydrodynamic 11.5-inch torque converter (2.52:1 stall ratio) with hydraulic forward/reverse multiplate clutch packs and 4-speed constant-mesh synchromesh mechanical gears.",
                hi = "11.5 इंच टॉर्क कनवर्टर (2.52:1 स्टॉल अनुपात), तेल में डूबी क्लच प्लेट्स और 4-स्पीड सिंक्रोमेश गियरबॉक्स का संयुक्त सिस्टम।",
                ar = "يدمج محول عزم هيدروديناميكي 11.5 بوصة مع مجموعات كلتش أمام/خلف هيدروليكية وعلبة تروس 4 سرعات متزامنة."
            ),
            oilCapacityAndGrade = Bilingual(
                en = "Capacity: 14.0 Litres | Grade: JCB Special Transmission Fluid (ISO VG 46 / ATF Type 33)",
                hi = "क्षमता: 14.0 लीटर | ऑयल ग्रेड: जेसीबी स्पेशल ट्रांसमिशन ऑयल (10W / ATF)"
            ),
            linePressuresBar = Bilingual(
                en = "Clutch Apply Operating Pressure: 11.5 - 13.5 bar at 1500 RPM | Torque Converter Relief: 4.5 bar",
                hi = "क्लच ऑपरेटिंग प्रेशर: 11.5 से 13.5 बार | टॉर्क कनवर्टर रिलीफ प्रेशर: 4.5 बार"
            ),
            rebuildAndInspectionSteps = listOf(
                Bilingual("1. Measure forward and reverse clutch pack thickness stack: replace friction discs if grooving depth is under 0.25 mm", "1. क्लच प्लेटों की मोटाई नापें: खांचे 0.25mm से कम घिसे होने पर नई प्लेटें लगाएं"),
                Bilingual("2. Check transmission oil pump radial clearance (pump internal wear destroys operating clutch clamp pressure)", "2. ट्रांसमिशन चार्जिंग पंप का गैप चेक करें; घिसा पंप क्लच प्रेशर गिरा देता है"),
                Bilingual("3. Replace torque converter hub neck PTFE sealing rings to prevent converter oil draining back into sump during shutdown", "3. टॉर्क कनवर्टर की सीलें बदलें ताकि मशीन बंद होने पर तेल वापस न गिरे")
            ),
            differentialCrownPinionBacklash = Bilingual(
                en = "Rear Drive Axle Crown Wheel to Drive Pinion Backlash: 0.20 mm to 0.28 mm (Adjusted via differential side carrier shims)",
                hi = "रियर एक्सल क्राउन व्हील और पिनियन गियर का बैकलाश: 0.20 mm से 0.28 mm (साइड सिम से सेट करें)"
            ),
            commonFailureModes = listOf(
                Bilingual("Operator shifting forward to reverse at full speed without using service brakes burns clutch pack discs into ash", "तेज स्पीड में बिना ब्रेक लगाए अचानक फॉरवर्ड-रिवर्स करने से क्लच प्लेट्स जलकर राख हो जाती हैं"),
                Bilingual("Filling ordinary 80W-90 gear oil into transmission destroys clutch friction material", "ट्रांसमिशन में गलती से गाढ़ा 80W-90 गियर ऑयल डालने से क्लच जाम होकर जल जाता है")
            ),
            manualReference = "JCB Drivetrain Workshop Manual 9803/8610 Section F"
        )
    )

    // 4. DASHBOARD SYMBOLS & WARNING LIGHTS DIRECTORY
    val dashboardSymbols: List<DashboardSymbol> = listOf(
        DashboardSymbol(
            symbolId = "sym_engine_oil_pressure",
            nameEn = "Low Engine Oil Pressure Warning Lamp",
            nameHi = "कम इंजन ऑयल प्रेशर चेतावनी बत्ती (ऑयल केन सिंबल)",
            nameAr = "لمبة تحذير انخفاض ضغط زيت المحرك",
            colorTone = SymbolColor.RED_STOP,
            symbolGlyph = "🛢️ RED OIL CAN",
            triggerCondition = Bilingual("Engine oil gallery pressure drops below 0.8 bar (11.6 psi)", "इंजन में तेल का दबाव 0.8 बार से कम होने पर जलती है", "ينخفض ضغط زيت المحرك عن 0.8 بار"),
            operatorImmediateAction = Bilingual(
                en = "IMMEDIATE EMERGENCY STOP: Turn off ignition key immediately within 5 seconds. Do not restart until oil level is verified and cause is rectified.",
                hi = "तत्काल इंजन बंद करें: 5 सेकंड में चाबी बंद करें। तेल का लेवल और लीकेज जांचे बिना दोबारा स्टार्ट न करें।",
                ar = "إيقاف طوارئ فوري: أطفئ المحرك خلال 5 ثوانٍ ولا تعد التشغيل قبل فحص مستوى الزيت ومعالجة السبب."
            ),
            underlyingMechanicalCause = Bilingual(
                en = "Severely low engine oil level, broken oil pump drive gear, seized pressure relief valve, or wiped crankshaft bearings.",
                hi = "चैंबर में तेल खत्म होना, ऑयल पंप का टूटना, रिलीफ वाल्व खुला अटकना या क्रैंक बेयरिंग कट जाना।",
                ar = "نقص حاد في زيت المحرك أو كسر ترس مضخة الزيت أو التصاق صمام الضغط أو تلف سبائك المرفق."
            ),
            isCriticalShutdown = true
        ),
        DashboardSymbol(
            symbolId = "sym_coolant_temp",
            nameEn = "High Coolant Temperature Overheat Lamp",
            nameHi = "उच्च कूलेंट तापमान (इंजन ओवरहीट) बत्ती",
            nameAr = "لمبة تحذير ارتفاع حرارة سائل التبريد",
            colorTone = SymbolColor.RED_STOP,
            symbolGlyph = "🌡️ RED THERMOMETER",
            triggerCondition = Bilingual("Engine coolant temperature exceeds 104°C (219°F)", "कूलेंट का तापमान 104°C से अधिक गर्म होने पर", "تتجاوز حرارة سائل التبريد 104 درجة مئوية"),
            operatorImmediateAction = Bilingual(
                en = "Reduce engine load immediately to low idle (do NOT shut off suddenly). Allow fan to cool radiator for 3 minutes before stopping.",
                hi = "तुरंत लोड हटाएं और धीमी रेस (आइडल) पर 3 मिनट चलने दें ताकि पंखे से ठंडा हो सके, फिर बंद करें।",
                ar = "خفف الحمل فوراً واترك المحرك على السرعة الهادئة 3 دقائق للتبريد بالمروحة قبل الإطفاء."
            ),
            underlyingMechanicalCause = Bilingual(
                en = "Mud-choked radiator core fins, snapped alternator/fan belt, stuck thermostat, or failed water pump impeller.",
                hi = "रेडिएटर में मिट्टी जमना, फैन बेल्ट टूटना, थर्मोस्टेट जाम होना या वाटर पंप खराब होना।",
                ar = "انسداد زعانف الرادياتير بالطين، انقطاع سير المروحة، تعطل الثرموستات أو تلف مضخة المياه."
            ),
            isCriticalShutdown = true
        ),
        DashboardSymbol(
            symbolId = "sym_water_in_fuel",
            nameEn = "Water in Fuel (WIF) Warning Indicator",
            nameHi = "डीजल में पानी जमा होने का संकेत (फिल्टर सिंबल)",
            nameAr = "مؤشر تحذير وجود ماء في الوقود",
            colorTone = SymbolColor.AMBER_CAUTION,
            symbolGlyph = "⛽ AMBER FUEL FILTER DROPS",
            triggerCondition = Bilingual("Conductive water accumulation detected in fuel pre-filter bowl", "डीजल फिल्टर के कटोरे में पानी जमा होने पर", "تجمع مياه موصلة داخل وعاء فاصل الماء بفلتر الوقود"),
            operatorImmediateAction = Bilingual(
                en = "Park safely at end of shift or next break. Loosen bottom thumbscrew on water separator bowl and drain all water until pure diesel flows.",
                hi = "मशीन पार्क करें। फिल्टर के नीचे लगा पेंच खोलकर सारा पानी बाहर निकालें जब तक साफ डीजल न निकले।",
                ar = "أوقف المعدة بأمان وافتح مسمار التصريف أسفل الوعاء لتفريغ الماء حتى خروج ديزل صافٍ."
            ),
            underlyingMechanicalCause = Bilingual(
                en = "Condensation in fuel tank or contaminated diesel supplied from storage barrels.",
                hi = "डीजल टैंक में नमी या ड्रम से गंदा पानी मिला डीजल डालना।",
                ar = "تكثف رطوبة في خزان الوقود أو تعبئة ديزل ملوث بالماء."
            ),
            isCriticalShutdown = false
        ),
        DashboardSymbol(
            symbolId = "sym_air_filter_restriction",
            nameEn = "Air Cleaner Restriction Warning Lamp",
            nameHi = "एयर क्लीनर फिल्टर चोक चेतावनी बत्ती",
            nameAr = "لمبة تحذير انسداد فلتر الهواء",
            colorTone = SymbolColor.AMBER_CAUTION,
            symbolGlyph = "💨 AMBER AIR FILTER MATRIX",
            triggerCondition = Bilingual("Intake manifold vacuum depression exceeds 6.2 kPa (25 inches H2O)", "एयर फिल्टर जाम होने पर इनटेक का वैक्यूम बढ़ जाना", "تجاوز التخلخل في مجرى السحب 6.2 كيلو باسكال"),
            operatorImmediateAction = Bilingual(
                en = "Shut down engine. Remove primary outer paper element and tap gently or blow clean with compressed air from inside out (max 3 bar air).",
                hi = "इंजन बंद करें। बड़ा एयर फिल्टर निकालकर अंदर से बाहर की ओर हल्की हवा मारकर धूल साफ करें।",
                ar = "أوقف المحرك، أخرج العنصر الخارجي ونظفه برفق بهواء من الداخل للخارج بحد أقصى 3 بار."
            ),
            underlyingMechanicalCause = Bilingual(
                en = "Heavy dust ingestion during dry earthmoving or demolition operations without pre-cleaner servicing.",
                hi = "धूल भरे वातावरण में काम करते समय फिल्टर में भारी मिट्टी जमा होना।",
                ar = "تراكم غبار كثيف أثناء الحفر في أجواء متربة."
            ),
            isCriticalShutdown = false
        ),
        DashboardSymbol(
            symbolId = "sym_hydraulic_temp",
            nameEn = "Hydraulic Oil High Temperature Lamp",
            nameHi = "हाइड्रोलिक ऑयल अत्यधिक गर्म चेतावनी बत्ती",
            nameAr = "لمبة تحذير ارتفاع حرارة الزيت الهيدروليكي",
            colorTone = SymbolColor.RED_STOP,
            symbolGlyph = "⚙️ RED HYDRAULIC OIL GEAR",
            triggerCondition = Bilingual("Hydraulic reservoir temperature exceeds 93°C (200°F)", "हाइड्रोलिक तेल 93°C से ज्यादा गर्म होने पर", "تجاوز حرارة الخزان الهيدروليكي 93 درجة مئوية"),
            operatorImmediateAction = Bilingual(
                en = "Stop all digging and loader operations immediately. Check oil level and clear hydraulic cooler radiator matrix.",
                hi = "खुदाई तुरंत रोकें। हाइड्रोलिक ऑयल लेवल चेक करें और कूलर की जाली साफ करें।",
                ar = "أوقف أعمال الحفر والتحميل فوراً، افحص مستوى الزيت ونظف مبرد الزيت الهيدروليكي."
            ),
            underlyingMechanicalCause = Bilingual(
                en = "Continuous relief valve blowing (lever stuck), pump cavitation, or oil cooler matrix choked with mud.",
                hi = "कोई लीवर अटका रहना जिससे तेल लगातार रिलीफ से बहना, या ऑयल कूलर का चोक होना।",
                ar = "فتح مستمر لصمام التنفيس أو تجويف بالمضخة أو انسداد مبرد الزيت بالأتربة."
            ),
            isCriticalShutdown = true
        )
    )

    // 5. ATTACHMENTS, BUCKETS, ROCK BREAKERS & JOYSTICK CONTROLS
    val attachments: List<AttachmentSpec> = listOf(
        AttachmentSpec(
            attachmentName = Bilingual("Hydraulic Rock Breaker (JCB HM380 / HM260 Hammer)", "हाइड्रोलिक रॉक ब्रेकर (जेसीबी हैमर)", "مطرقة تكسير الصخور الهيدروليكية (جاك همر)"),
            compatibleMachines = listOf("JCB 3DX", "JCB 3CX", "JCB 4CX", "CAT 424B"),
            hydraulicFlowReqLpm = "60 - 90 Litres/min",
            operatingPressureBar = "120 - 150 bar (Working Pressure)",
            nitrogenGasChargeBar = "14.5 bar to 16.0 bar Nitrogen (N2) Gas Chamber Pressure",
            joystickControlMethod = Bilingual(
                en = "Foot-pedal auxiliary floor switch or right-hand proportional thumb roller on servo joystick",
                hi = "फर्श पर लगा फुट पेडल या सर्वो जॉयस्टिक के ऊपर लगा थंब रोलर बटन",
                ar = "دواسة أرضية مساعدة أو بكرة الإبهام التناسبية على عصا التحكم اليمنى"
            ),
            maintenanceInspection = listOf(
                Bilingual("Grease chisel tool shank with high-temperature molybdenum grease every 2 hours of active hammer operation", "हर 2 घंटे लगातार ब्रेकर चलाने पर छेनी (टूल) के बुश में हाई-टेम्परेचर ग्रीस मारें"),
                Bilingual("Never fire hammer continuously for more than 15 seconds on one hard spot; stop and reposition tool to avoid dry firing", "एक ही जगह पर 15 सेकंड से ज्यादा लगातार न चलाएं; थोड़ा हटाकर दोबारा मारें"),
                Bilingual("Check nitrogen back-head gas pressure every 250 operating hours with certified JCB charging kit", "हर 250 घंटे पर नाइट्रोजन गैस का प्रेशर चेक करें")
            ),
            safetyOperatingRules = listOf(
                Bilingual("Never use breaker chisel as a pry bar to lever boulders (bends chisel and cracks hammer casing)", "छेनी को फंसाकर पत्थर उखाड़ने का प्रयास कभी न करें, इससे छेनी और बॉडी टूट जाती है"),
                Bilingual("Never operate hammer submerged underwater without compressed air underwater sealing kit", "बिना एयर किट के पानी के अंदर ब्रेकर कभी न चलाएं")
            )
        ),
        AttachmentSpec(
            attachmentName = Bilingual("6-in-1 Multi-Purpose Front Shovel (Clamshell Bucket)", "6-इन-1 मल्टी-पर्पज फ्रंट लोडर बकेट", "جرافة أمامية متعددة الأغراض 6 في 1"),
            compatibleMachines = listOf("JCB 3CX Super", "JCB 4CX", "JCB 3DX Super"),
            hydraulicFlowReqLpm = "Full main pump delivery (130 L/min)",
            operatingPressureBar = "220 bar Clamping Force",
            nitrogenGasChargeBar = "N/A (Hydraulic Double-Acting Rams)",
            joystickControlMethod = Bilingual(
                en = "Electric solenoid button integrated directly into the front loader multi-axis joystick handle",
                hi = "फ्रंट लोडर जॉयस्टिक के हैंडल पर लगा इलेक्ट्रिक सोलेनोइड बटन"
            ),
            maintenanceInspection = listOf(
                Bilingual("Inspect clamshell bottom jaw hardened wear plates and serrated gripping teeth", "जबड़े की नीचे वाली वियर प्लेट और दांतों की धार चेक करें"),
                Bilingual("Grease twin clamshell hydraulic ram pivot pins daily (4 grease nipples)", "दोनों जबड़े खोलने वाले सिलेंडरों के पिनों में रोज ग्रीस भरें")
            ),
            safetyOperatingRules = listOf(
                Bilingual("Ensure clamping jaw is completely closed before driving machine on highway", "सड़क पर मशीन चलाते समय जबड़ा पूरी तरह बंद रखें")
            )
        )
    )

    // 6. LUBRICANTS, OILS, COOLANTS & FILTER DIRECTORY
    val fluidsAndFilters: List<FluidAndFilterGuide> = listOf(
        FluidAndFilterGuide(
            compartment = Bilingual("Engine Lubrication Sump", "इंजन चैंबर (क्रैंककेस)", "حوض زيت تزييت المحرك (الكارتير)"),
            factoryCapacityLiters = "14.5 Litres (with filter replacement)",
            recommendedGradeEn = "SAE 15W-40 API CI-4 / CJ-4 Heavy Diesel Engine Oil",
            recommendedGradeHi = "15W-40 API CI-4 हैवी ड्यूटी डीजल इंजन ऑयल",
            recommendedGradeAr = "زيت محركات ديزل ثقيل SAE 15W-40 API CI-4",
            jcbSpecification = "JCB Engine Oil Plus 15W-40 (JCB Standard 4001/1800)",
            changeIntervalHours = "Every 500 Operating Hours (or 1 Year)",
            filterPartNumber = "JCB Part 320/04133 (Spin-on Micron Filter)",
            fillingProcedure = listOf(
                Bilingual("Drain warm oil completely for 15 minutes", "15 मिनट तक गर्म तेल पूरा टपकने दें"),
                Bilingual("Pre-fill new filter 80% with fresh oil before fitting", "नया फिल्टर कसने से पहले 80% नया तेल भरें"),
                Bilingual("Torque drain plug with new copper washer to 60 Nm", "नया तांबे का वाशर लगाकर ड्रेन प्लग 60 Nm पर कसें")
            ),
            contaminationWarnings = Bilingual(
                en = "Never mix synthetic and mineral oils; inspect for diesel dilution (rising oil level smell) from faulty lift pump.",
                hi = "सिंथेटिक और मिनरल तेल न मिलाएं; यदि तेल का लेवल बढ़ रहा हो तो डीजल मिलने की जांच करें।",
                ar = "لا تخلط الزيت التخليقي بالمعدني، وافحص اختلاط الديزل بالزيت عند ارتفاع المنسوب."
            )
        ),
        FluidAndFilterGuide(
            compartment = Bilingual("Main Hydraulic Tank & System", "हाइड्रोलिक टैंक और संपूर्ण सिस्टम", "الخزان الهيدروليكي والنظام الرئيسي"),
            factoryCapacityLiters = "Tank Capacity: 85 Litres | Total System: 130 Litres",
            recommendedGradeEn = "ISO VG 46 (Temperate) or ISO VG 68 (Hot Tropical Summer) Anti-Wear Hydraulic Fluid",
            recommendedGradeHi = "ISO VG 46 या गर्मियों में ISO VG 68 एंटी-वियर हाइड्रोलिक ऑयल",
            recommendedGradeAr = "زيت هيدروليك مانع للتآكل ISO VG 46 أو VG 68 للأجواء الحارة",
            jcbSpecification = "JCB Hydraulic Fluid HP46 (JCB Standard 4002/0800)",
            changeIntervalHours = "Oil: Every 2,000 Hours | Return Filter: Every 500 Hours",
            filterPartNumber = "JCB Part 32/925346 (Tank Return Hydraulic Filter Element)",
            fillingProcedure = listOf(
                Bilingual("Retract all loader and backhoe cylinders to service park position", "सारे सिलेंडर अंदर करके पार्क करें"),
                Bilingual("Fill through filler strainer until sight gauge reads mid-green mark", "टैंक के कांच वाले गेज में हरे निशान तक भरें"),
                Bilingual("Clean stainless steel suction strainer inside reservoir with clean diesel", "टैंक के अंदर की सक्शन जाली को डीजल से धोएं")
            ),
            contaminationWarnings = Bilingual(
                en = "Water contamination turns oil milky white. Replace oil immediately; emulsified oil causes instant pump cavitation seizure.",
                hi = "पानी मिलने पर तेल दूधिया सफेद हो जाता है। ऐसा होने पर पूरा तेल बदलें नहीं तो पंप तुरंत सीज हो जाएगा।",
                ar = "الماء يحوّل الزيت للون حليبي أبيض؛ استبدله فوراً لتفادي تلف وتجويف المضخة."
            )
        ),
        FluidAndFilterGuide(
            compartment = Bilingual("Synchroshuttle Transmission & Gearbox", "ट्रांसमिशन और गियरबॉक्स", "ناقل الحركة وصندوق التروس"),
            factoryCapacityLiters = "14.0 Litres (Dry Rebuild: 16.5 Litres)",
            recommendedGradeEn = "JCB Special Transmission Fluid 10W (ATF Type 33 / Caterpillar TO-4 10W)",
            recommendedGradeHi = "जेसीबी स्पेशल ट्रांसमिशन फ्लूइड 10W (TO-4 मानक)",
            recommendedGradeAr = "سائل ناقل حركة خاص JCB 10W (معيار ATF / TO-4)",
            jcbSpecification = "JCB Standard 4000/2500 (Torque Converter Fluid)",
            changeIntervalHours = "Oil: Every 1,000 Hours | Filter: Every 500 Hours",
            filterPartNumber = "JCB Part 581/18076 (Transmission Spin-on Filter)",
            fillingProcedure = listOf(
                Bilingual("Check level with engine running at low idle in Neutral on flat ground", "समतल जमीन पर न्यूट्रल में इंजन चालू रखकर ही ट्रांसमिशन गेज चेक करें")
            ),
            contaminationWarnings = Bilingual(
                en = "DO NOT use standard EP90 gear oil. EP90 glazes wet clutch friction discs causing complete loss of drive.",
                hi = "गलती से भी EP90 गियर ऑयल न डालें, इससे क्लच प्लेट जलकर तुरंत खराब हो जाती हैं।",
                ar = "ممنوع استخدام زيت التروس العادي EP90؛ يتلف أقراص الكلتش المغمورة بالزيت فوراً."
            )
        ),
        FluidAndFilterGuide(
            compartment = Bilingual("Rear Drive Axle Differential & Planetary Wheel Hubs", "रियर एक्सल डिफरेंशियल और व्हील हब", "دفرنس المحور الخلفي وصرة العجلات"),
            factoryCapacityLiters = "Axle Center Differential: 14.5 Litres | Outer Hubs: 2x 1.5 Litres",
            recommendedGradeEn = "SAE 80W-90 API GL-4 with Friction Modifier for Oil-Immersed Wet Brakes",
            recommendedGradeHi = "80W-90 GL-4 स्पेशल वेट ब्रेक एडिटिव युक्त एक्सल ऑयल",
            recommendedGradeAr = "زيت تروس SAE 80W-90 API GL-4 مع محسن احتكاك للفرامل الزيتية",
            jcbSpecification = "JCB Gear Oil HP Plus (JCB Standard 4000/2200)",
            changeIntervalHours = "Every 1,000 Operating Hours",
            filterPartNumber = "N/A (Magnetic Drain Plug Inspection)",
            fillingProcedure = listOf(
                Bilingual("Fill axle center case until oil weeps out of level check hole", "एक्सल में तब तक तेल डालें जब तक साइड वाले सुराख से बहने न लगे"),
                Bilingual("Rotate wheel hub so 'OIL LEVEL' mark is horizontal before filling wheel hub planetary reduction gears", "हब पर लिखा 'OIL LEVEL' सीधा करके हब में तेल भरें")
            ),
            contaminationWarnings = Bilingual(
                en = "Standard automotive axle oil causes deafening brake chatter and squeal when stopping machine.",
                hi = "साधारण एक्सल ऑयल डालने से ब्रेक लगाते समय एक्सल से तेज गड़गड़ाहट और आवाज आने लगती है।",
                ar = "استخدام زيت محاور عادي يسبب اهتزازاً وضجيجاً عالياً بالفرامل عند التوقف."
            )
        ),
        FluidAndFilterGuide(
            compartment = Bilingual("Engine Closed Radiator Cooling System", "इंजन रेडिएटर कूलिंग सिस्टम", "نظام تبريد المحرك والرادياتير"),
            factoryCapacityLiters = "18.5 Litres (50% Premix Concentration)",
            recommendedGradeEn = "Ethylene Glycol Organic Acid Technology (OAT) Heavy-Duty Long-Life Coolant (50/50 with demineralized water)",
            recommendedGradeHi = "एथिलीन ग्लाइकोल OAT लॉन्ग-लाइफ कूलेंट (50% डिस्टिल्ड वाटर प्रीमिक्स)",
            recommendedGradeAr = "سائل تبريد طويل العمر OAT (خلط 50/50 مع ماء مقطر)",
            jcbSpecification = "JCB Antifreeze / Coolant HP (JCB Standard 4006/1100)",
            changeIntervalHours = "Every 2,000 Operating Hours (or 2 Years)",
            filterPartNumber = "N/A (Clean radiator pressure cap & overflow bottle)",
            fillingProcedure = listOf(
                Bilingual("Mix 50% pure antifreeze with 50% distilled water (never use hard borewell water)", "50% कूलेंट और 50% डिस्टिल्ड पानी मिलाएं (बोरवेल का खारा पानी कभी न डालें)"),
                Bilingual("Idle engine with heater valve open to purge air pockets from cylinder head", "कैबिन हीटर खोलकर इंजन चलाएं ताकि अंदर की सारी हवा निकल जाए")
            ),
            contaminationWarnings = Bilingual(
                en = "Hard tap water deposits mineral calcium scale on cylinder liners causing hot spots and head gasket failure.",
                hi = "नल का खारा पानी इंजन की दीवारों पर सफेद पपड़ी जमा देता है जिससे हेड गैस्केट जल जाता है।"
            )
        )
    )

    // 7. DIAGNOSTIC SCANNER & ECU CALIBRATION GUIDE
    val calibrations: List<EcuCalibrationGuide> = listOf(
        EcuCalibrationGuide(
            calibrationName = Bilingual("Common Rail Injector Code (IMA / QR Code) Programming", "कॉमन रेल इंजेक्टर कोडिंग (IMA/QR कोड प्रोग्रामिंग)", "برمجة أكواد حاقنات الديزل المشتركة (IMA/QR)"),
            supportedModels = listOf("JCB EcoMAX 4.4L Tier 4", "JCB 3DX Super CEV-IV", "JCB NXT 215"),
            prerequisites = listOf(
                Bilingual("Connect 9-Pin J1939 Deutsch diagnostic port under steering column to handheld scanner or JCB LiveLink ServiceMaster", "स्टीयरिंग के नीचे 9-पिन डायग्नोस्टिक पोर्ट में स्कैनर लगाएं"),
                Bilingual("Battery voltage must be above 12.4V; connect battery maintainer charger during flashing", "बैटरी वोल्टेज 12.4V से अधिक होना अनिवार्य है")
            ),
            stepByStepProcedure = listOf(
                Bilingual("1. Note down the 16-character alphanumeric QR calibration code engraved on each injector head body", "1. नए इंजेक्टर के सिर पर छपा 16 अंकों का अल्फ़ान्यूमेरिक कोड डायरी में लिखें"),
                Bilingual("2. In diagnostic software, select: Engine ECU ➜ Injector Calibration ➜ Cylinder 1 to 4", "2. स्कैनर में Engine ECU ➜ Injector Calibration चुनें"),
                Bilingual("3. Enter specific code for each cylinder; press 'WRITE CALIBRATION TO EEPROM'", "3. प्रत्येक सिलेंडर का कोड टाइप करें और 'WRITE' बटन दबाएं"),
                Bilingual("4. Cycle ignition key OFF for 30 seconds to allow ECU power-down latching, then restart engine", "4. चाबी 30 सेकंड बंद रखें ताकि ईसीयू में सेव हो जाए, फिर स्टार्ट करें")
            ),
            successConfirmation = Bilingual("Engine idle smoothes out immediately; injector pilot-rattle noise vanishes", "इंजन की आवाज शांत हो जाती है और खटखटाहट बंद हो जाती है", "ينتظم دوران المحرك فوراً ويختفي صوت طقطقة الحاقن."),
            troubleCodesResetSteps = listOf(
                Bilingual("Clear error code P0263 / P0266 (Cylinder Balance Contribution Fault) from ECU memory", "ईसीयू मेमोरी से P0263/P0266 कोड डिलीट करें")
            ),
            manualReference = "JCB ServiceMaster Diagnostic Manual Section B-8"
        ),
        EcuCalibrationGuide(
            calibrationName = Bilingual("Transmission Powershift Proportional Valve Calibration", "ट्रांसमिशन पावरशिफ्ट क्लच प्रोपोर्शनल वॉल्व कैलिब्रेशन", "معايرة الصمام التناسبي لناقل الحركة Powershift"),
            supportedModels = listOf("JCB 3CX Autoshift", "JCB 4CX", "JCB 5CX"),
            prerequisites = listOf(
                Bilingual("Transmission oil temperature MUST be between 65°C and 75°C", "ट्रांसमिशन तेल का तापमान 65°C से 75°C के बीच होना चाहिए"),
                Bilingual("Park machine on level concrete with parking brake applied and wheels chocked", "समतल जमीन पर हैंडब्रेक लगाकर पहियों पर गुटके लगाएं")
            ),
            stepByStepProcedure = listOf(
                Bilingual("1. Select 'Transmission Clutch Calibration' on diagnostic screen", "1. स्कैनर पर Transmission Clutch Calibration चुनें"),
                Bilingual("2. Hold engine at 1500 RPM; ECU will sequentially pulse each clutch pack to detect engagement bite points", "2. 1500 आरपीएम पर रेस रखें; ईसीयू हर गियर की क्लच प्लेट को बारी-बारी झटका देकर खुद सेट करेगा"),
                Bilingual("3. Do not touch pedals or levers while calibration runs for 3 minutes", "3. तीन मिनट तक कोई लीवर या पेडल न छुएं")
            ),
            successConfirmation = Bilingual("Display indicates 'CALIBRATION SUCCESSFUL'; gear shifts engage with zero jerk", "स्क्रीन पर 'SUCCESS' दिखेगा और गियर बिल्कुल मक्खन जैसे बिना झटके के लगेंगे"),
            troubleCodesResetSteps = listOf(
                Bilingual("Clears fault code T0211 (Clutch fill time adaptation limit reached)", "T0211 कोड मेमोरी से हट जाएगा")
            ),
            manualReference = "JCB Powershift Service Manual Section F-4"
        )
    )

    // 8. EXPLODED VIEW SPARE PARTS DIRECTORY
    val explodedAssemblies: List<ExplodedViewAssembly> = listOf(
        ExplodedViewAssembly(
            assemblyId = "exploded_backhoe_boom",
            titleEn = "Backhoe Boom & Kingpost Exploded Assembly",
            titleHi = "बैकहो बूम और किंगपोस्ट एक्सप्लोडेड पार्ट्स चित्र",
            titleAr = "المخطط التفصيلي لذراع الحفار الخلفي والبرج (Kingpost)",
            machineCategory = "JCB 3DX / 3CX Backhoe Assembly",
            explodedDiagramNodes = listOf(
                ExplodedPartNode(1, "Main Cast Steel Kingpost", "मेन कास्ट स्टील किंगपोस्ट", "128/10853", 1, "Pivot for left/right slew", "قاعدة البرج الفولاذية الرئيسية (Kingpost)"),
                ExplodedPartNode(2, "Upper Kingpost Pivot Pin", "ऊपरी किंगपोस्ट पिवट पिन", "811/90165", 1, "Torque clamp bolt: 120 Nm", "بنس الارتكاز العلوي للبرج"),
                ExplodedPartNode(3, "Bronze Flanged Bushing (Top)", "कांस्य फ्लैंज बुश (ऊपरी)", "809/00131", 2, "Grease daily", "جلبة برونزية علوية"),
                ExplodedPartNode(4, "Lower Kingpost Heavy Pin", "निचली किंगपोस्ट हैवी पिन", "811/90166", 1, "Hardened chrome steel", "بنس الارتكاز السفلي الثقيل"),
                ExplodedPartNode(5, "Boom Lift Cylinder Pivot Pin", "बूम लिफ्ट सिलेंडर पिन", "811/50369", 1, "M12 retainer bolt: 85 Nm", "بنس بستم رفع الذراع"),
                ExplodedPartNode(6, "Hydraulic Slew Actuator Ram", "हाइड्रोलिक स्लीव स्विंग रैम", "556/43500", 2, "Cushioned end-stroke", "بستم الدوران الهيدروليكي"),
                ExplodedPartNode(7, "Main Curved Boom Weldment", "मेन कर्व्ड बूम वेल्डमेंट", "128/13840", 1, "High-tensile D-box steel", "الذراع الرئيسي المنحني للحفار")
            ),
            serviceNotes = Bilingual(
                en = "Always check pin-to-bush radial play with dial indicator. Replace bushing when play exceeds 1.2 mm to prevent ovality wear on the expensive kingpost casting bores.",
                hi = "पिन और बुश का गैप चेक करें। 1.2 mm से ज्यादा प्ले होने पर नया बुश लगाएं ताकि मुख्य किंगपोस्ट का सुराख अंडाकार न कटे।",
                ar = "افحص الخلوص بين البنس والجلبة دائماً، واستبدل الجلبة عند تجاوز 1.2 مم لحماية تجويف البرج من التآكل البيضاوي."
            )
        ),
        ExplodedViewAssembly(
            assemblyId = "exploded_front_loader",
            titleEn = "Front Loader Linkage & Shovel Exploded Assembly",
            titleHi = "फ्रंट लोडर लिंकेज और बकेट एक्सप्लोडेड पार्ट्स चित्र",
            titleAr = "المخطط التفصيلي لأذرع المحمل الأمامي والجرافة",
            machineCategory = "JCB 3DX / 3CX Loader Linkage",
            explodedDiagramNodes = listOf(
                ExplodedPartNode(1, "Front Shovel Pivot Pin", "फ्रंट बकेट पिवट पिन", "811/10091", 2, "Grease 2x daily", "بنس ارتكاز الجرافة الأمامية"),
                ExplodedPartNode(2, "Leveling Link Dog-Bone", "लेवलिंग लिंक डॉग-बोन", "126/02253", 2, "Maintains bucket level", "وصلة موازنة مستوى الجرافة"),
                ExplodedPartNode(3, "Loader Lift Ram Lower Pin", "लोडर लिफ्ट रैम निचली पिन", "811/90150", 2, "Torque: 95 Nm", "البنس السفلي لبستم رفع المحمل"),
                ExplodedPartNode(4, "Hardened Steel Bush", "हार्ड स्टील बुश", "809/00125", 8, "Internal cross-grease grooves", "جلبة فولاذية مقساة"),
                ExplodedPartNode(5, "Safety Prop Strut", "सेफ्टी लॉक स्ट्रट (ब्रैकेट)", "123/04250", 1, "MANDATORY safety lock", "دعامة قفل الأمان للمحمل")
            ),
            serviceNotes = Bilingual(
                en = "MANDATORY SAFETY: Lock safety prop strut over left-hand loader lift ram rod before inspecting lower linkage pins.",
                hi = "अनिवार्य सुरक्षा: लोडर उठाकर काम करने से पहले बाएं सिलेंडर पर सेफ्टी लॉक ब्रैकेट जरूर लगाएं।",
                ar = "أمان إلزامي: ثبت دعامة الأمان فوق ذراع الرفع الأيسر قبل فحص بنوز المحمل السفلية."
            )
        )
    )

    // 9. PRACTICAL VIDEO MASTERCLASS / TUTORIALS
    val videoTutorials: List<VideoTutorialLesson> = listOf(
        VideoTutorialLesson(
            videoId = "vid_valve_tappet_setting",
            titleEn = "Engine Valve Tappet Clearance Setting (Cold Engine Method)",
            titleHi = "इंजन वाल्व टैपेट क्लीयरेंस सेटिंग (ठंडे इंजन पर सही विधि)",
            titleAr = "ضبط خلوص صمامات المحرك على البارد (Tappet Setting)",
            durationMin = 14,
            presenterInstructor = Bilingual("Chief Technical Instructor (JCB Heavy Diesel Academy)", "मुख्य तकनीकी प्रशिक्षक (जेसीबी हेवी डीजल एकेडमी)", "كبير المدربين الفنيين (أكاديمية الديزل الثقيل)"),
            videoKeyPoints = listOf(
                Bilingual("How to find Top Dead Center (TDC) Compression Stroke on Cylinder #1 using flywheel timing pin", "फ्लाईव्हील टाइमिंग पिन से सिलेंडर 1 का कम्प्रेशन टॉप (TDC) निकालना"),
                Bilingual("Rule of 9 for 4-cylinder engine valve adjustment sequence", "4-सिलेंडर इंजन के लिए वाल्व मिलाने का नियम"),
                Bilingual("Correct feeler gauge drag technique: 0.25mm inlet and 0.45mm exhaust", "फीलर गेज का सही खिंचाव: 0.25mm इनलेट और 0.45mm एग्जॉस्ट"),
                Bilingual("Torquing rocker arm adjusting screw locknut without moving the set screw", "स्क्रू हिले बिना 25 Nm पर लॉक नट टाइट करना")
            ),
            downloadableOfflineSizeMb = "42 MB (Bundled Offline HD Video Tutorial)",
            isCachedOffline = true
        ),
        VideoTutorialLesson(
            videoId = "vid_hydraulic_ram_resealing",
            titleEn = "Hydraulic Cylinder Strip Down & Complete Seal Kit Replacement",
            titleHi = "हाइड्रोलिक सिलेंडर खोलना और नई सील किट फिटिंग मास्टरक्लास",
            titleAr = "فك البستم الهيدروليكي وتغيير طقم الصوف الكامل",
            durationMin = 18,
            presenterInstructor = Bilingual("Senior Hydraulics Master Specialist", "सीनियर हाइड्रोलिक मास्टर विशेषज्ञ", "خبير الهيدروليك الرئيسي"),
            videoKeyPoints = listOf(
                Bilingual("Safe methods to unscrew stuck gland nuts using heavy-duty C-spanners without damaging tube", "सिलेंडर ट्यूब को नुकसान पहुंचाए बिना सी-स्पैनर से ग्लैंड नट खोलना"),
                Bilingual("Inspecting internal micro-honed barrel for scratches that destroy new rod seals", "सिलेंडर के अंदर खरोंच जांचना जो नई सील काट देती हैं"),
                Bilingual("Fitting bronze-filled PTFE wear rings and polyurethane rod seals with proper orientation", "पिस्टन पर वियर रिंग और रॉड सील का सही मुंह रखकर बैठाना"),
                Bilingual("Applying threadlocker on piston retaining nut and torquing to 450 Nm", "पिस्टन नट पर लॉक टाइट लगाकर 450 Nm पर सुरक्षित कसना")
            ),
            downloadableOfflineSizeMb = "55 MB (Bundled Offline HD Video Tutorial)",
            isCachedOffline = true
        ),
        VideoTutorialLesson(
            videoId = "vid_injector_leak_off_test",
            titleEn = "Common Rail Injector Back-Leakage Bottle Test",
            titleHi = "कॉमन रेल इंजेक्टर बैक-लीक बॉटल टेस्ट (खराब इंजेक्टर पकड़ना)",
            titleAr = "اختبار الراجع لحاقنات الوقود المشتركة بالقوارير",
            durationMin = 11,
            presenterInstructor = Bilingual("Fuel Injection Diagnostic Specialist", "डीजल इंजेक्शन डायग्नोस्टिक विशेषज्ञ", "أخصائي فحص أنظمة حقن الديزل"),
            videoKeyPoints = listOf(
                Bilingual("Connecting 4 graduated measuring cylinders to injector leak-off return ports", "चारों इंजेक्टरों के रिटर्न पर नापने वाली बोतलें लगाना"),
                Bilingual("Cranking engine for 60 seconds with fuel pump disconnected to measure starter bypass volume", "सेल्फ मारकर 60 सेकंड में प्रति इंजेक्टर रिटर्न डीजल की मात्रा नापना"),
                Bilingual("Identifying which specific cylinder injector is leaking high-pressure diesel back to tank", "पकड़ना कि कौन सा इंजेक्टर अंदर से लीक होकर रेल का प्रेशर गिरा रहा है")
            ),
            downloadableOfflineSizeMb = "38 MB (Bundled Offline HD Video Tutorial)",
            isCachedOffline = true
        )
    )

    // 10. OPERATOR & MECHANIC SAFETY TRAINING PROTOCOLS
    val safetyProtocols: List<SafetyProtocol> = listOf(
        SafetyProtocol(
            topicEn = "High-Pressure Hydraulic Injection Hazard",
            topicHi = "हाई प्रेशर हाइड्रोलिक फ्लूइड इंजेक्शन का जानलेवा खतरा",
            topicAr = "خطر حقن السائل الهيدروليكي عالي الضغط تحت الجلد",
            hazardType = Bilingual(
                en = "High-Pressure Fluid Jet Penetration (250 bar / 3,600 psi penetrates skin like a needle, causing severe gangrene and amputation within hours)",
                hi = "250 बार का तेल सुई की तरह चमड़ी और मांस के आर-पार घुस जाता है, जिससे तुरंत गैंग्रीन फैलकर अंग काटना पड़ता है",
                ar = "نفاذ السائل بضغط 250 بار يخترق الجلد كالإبرة ويسبب غرغرينا حادة وبتر خلال ساعات."
            ),
            mandatoryChecklist = listOf(
                Bilingual("ALWAYS release residual circuit pressure by turning engine OFF and cycling all levers 10 times in all directions before opening any hydraulic hose", "कोई भी पाइप खोलने से पहले इंजन बंद करें और सभी लीवरों को 10 बार आगे-पीछे हिलाकर अंदर का दबाव शून्य करें"),
                Bilingual("NEVER use bare hands or fingers to check for suspected pinhole hydraulic leaks. Always pass a piece of cardboard or wood across the hose", "लीकेज चेक करने के लिए हाथ कभी न लगाएं; हमेशा गत्ते या लकड़ी के टुकड़े का प्रयोग करें"),
                Bilingual("Wear heavy safety goggles and impact-resistant nitrile gloves when servicing pumps", "काम करते समय आंखों पर सुरक्षा चश्मा जरूर पहनें")
            ),
            prohibitedActions = listOf(
                Bilingual("Never disconnect a pressurized hydraulic line under working machine load", "मशीन पर लोड होने की स्थिति में कभी कोई पाइप न खोलें"),
                Bilingual("Never exceed factory main relief valve pressure settings beyond 255 bar", "मेन रिलीफ वॉल्व को 255 बार से ऊपर कभी न बढ़ाएं")
            ),
            emergencyProcedures = Bilingual(
                en = "IF INJECTED: Seek IMMEDIATE surgical trauma center care. Inform surgeon of high-pressure hydraulic mineral oil injection; requires immediate emergency fasciotomy decompression.",
                hi = "यदि तेल चमड़ी में घुस जाए: तुरंत अस्पताल के सर्जन के पास जाएं। उन्हें बताएं कि हाई-प्रेशर मिनरल ऑयल घुसा है ताकि तुरंत चीरा लगाकर तेल निकाला जा सके।",
                ar = "في حال الإصابة: توجه فوراً لمركز الطوارئ الجراحي وأبلغ الجراح بتعرضك لحقن زيت هيدروليكي عالي الضغط."
            )
        ),
        SafetyProtocol(
            topicEn = "Working Under Elevated Booms & Shovels",
            topicHi = "उठे हुए बूम और लोडर के नीचे काम करने की सुरक्षा",
            topicAr = "السلامة أثناء العمل تحت الأذرع والجرافات المرفوعة",
            hazardType = Bilingual(
                en = "Crushing Hazard (A falling loader or backhoe arm exerts over 5,000 kg crushing impact, resulting in instantaneous fatality)",
                hi = "दबने का भारी खतरा (5 टन का लोडर या बूम नीचे गिरने पर पलक झपकते ही जान जा सकती है)",
                ar = "خطر السحق: سقوط ذراع المحمل أو الحفار يولد صدمة تتجاوز 5,000 كجم قاتلة فوراً."
            ),
            mandatoryChecklist = listOf(
                Bilingual("Always install mechanical loader safety strut prop over lift cylinder rod before standing under front bucket", "लोडर के नीचे खड़े होने से पहले सिलेंडर रॉड पर पीला सेफ्टी लॉक ब्रैकेट जरूर फंसाएं"),
                Bilingual("Lock backhoe transport boom locking hook and slew carriage mechanical pin when servicing rear kingpost", "पीछे काम करते समय बूम का कुंडा (ट्रांसपोर्ट लॉक) और स्लीव लॉक पिन जरूर लगाएं")
            ),
            prohibitedActions = listOf(
                Bilingual("Never rely purely on hydraulic oil pressure or control levers to hold an arm in the air", "लोडर को हवा में रोकने के लिए कभी केवल हाइड्रोलिक लीवर के भरोसे न रहें"),
                Bilingual("Never crawl under a machine lifted solely by hydraulic stabilizer legs without heavy axle stands", "जैक और पैरों पर टिकी मशीन के नीचे बिना लोहे की 10-टन घोड़ी लगाए कभी नीचे न जाएं")
            ),
            emergencyProcedures = Bilingual(
                en = "Lower all working equipment flat to ground before leaving operator seat. Turn off key and lock cabin.",
                hi = "कैबिन से उतरने से पहले बकेट और लोडर दोनों को जमीन पर अच्छी तरह टिकाएं और चाबी निकालें।",
                ar = "أنزل جميع معدات العمل بالكامل على الأرض وأطفئ المفتاح وأقفل المقصورة قبل المغادرة."
            )
        )
    )
}
