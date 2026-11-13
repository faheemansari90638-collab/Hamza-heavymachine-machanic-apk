package com.example.data

import com.example.model.*

object JcbElectricalDatabase {

    // 1. STANDARD & JCB BRITISH STANDARD WIRING COLOUR CODE DIRECTORY
    val wireColourCodes: List<WireColourCode> = listOf(
        WireColourCode(
            code = "R",
            baseColourEn = "Red",
            baseColourHi = "लाल (Red)",
            hexColor = 0xFFD32F2F,
            typicalCircuitEn = "Permanent Unfused Battery Direct Supply (+12V Battery Constant, Terminal 30)",
            typicalCircuitHi = "सीधा 12 वोल्ट बैटरी सप्लाई (हमेशा चालू, टर्मिनल 30, बिना चाबी ऑन किए चालू)",
            jcbBritishStandardRuleEn = "BS-AU7 Standard: Main battery live line to ignition switch terminal 30, starter motor main feed, and hazard flasher module.",
            jcbBritishStandardRuleHi = "ब्रिटिश ऑटो मानक: बैटरी से इग्निशन चाबी के टर्मिनल 30, स्टार्टर मोटर और हैजार्ड लाइट को जाने वाला मुख्य 12V तार।",
            baseColourAr = "أحمر (Red)",
            typicalCircuitAr = "تغذية بطارية دائمة مباشرة بدون فيوز (+12 فولت، طرف 30)",
            jcbBritishStandardRuleAr = "المعيار البريطاني: الخط الحي الرئيسي من البطارية إلى مفتاح التشغيل طرف 30 ومحرك السلف وإشارة التحذير."
        ),
        WireColourCode(
            code = "B",
            baseColourEn = "Black",
            baseColourHi = "काला (Black)",
            hexColor = 0xFF141311,
            typicalCircuitEn = "Chassis Ground / Negative Earth (0V Ground)",
            typicalCircuitHi = "चेसिस ग्राउंड / अर्थिंग (0V नेगेटिव अर्थ, बॉडी ग्राउंड)",
            jcbBritishStandardRuleEn = "Earth return to frame/chassis ground stud. In JCB, all black wires return directly to ground lugs on the chassis members.",
            jcbBritishStandardRuleHi = "मशीन की बॉडी और चेसिस से अर्थिंग वापस ले जाने वाला तार। काले तार में कोई वोल्टेज नहीं होना चाहिए।",
            baseColourAr = "أسود (Black)",
            typicalCircuitAr = "تأريض الشاسيه / القطب السالب (0 فولت أرضي)",
            jcbBritishStandardRuleAr = "خط الرجوع الأرضي إلى جسم الشاسيه. جميع الأسلاك السوداء في JCB تتصل بنقاط التأريض بالهيكل."
        ),
        WireColourCode(
            code = "W",
            baseColourEn = "White",
            baseColourHi = "सफेद (White)",
            hexColor = 0xFFEEEEEE,
            typicalCircuitEn = "Ignition Switched Live (+12V Key ON, Terminal 15) without Fuse",
            typicalCircuitHi = "इग्निशन चाबी ऑन करने पर चालू 12 वोल्ट सप्लाई (टर्मिनल 15, अनफ्यूज्ड)",
            jcbBritishStandardRuleEn = "Feeds from ignition switch position 1 (Ignition ON) into the cabin fuse box rail to distribute to fused circuits.",
            jcbBritishStandardRuleHi = "चाबी ऑन होते ही स्विच से निकलकर मेन फ्यूज बॉक्स की रेल में जाने वाला मुख्य सप्लाई तार।",
            baseColourAr = "أبيض (White)",
            typicalCircuitAr = "تغذية حية عبر مفتاح التشغيل (+12 فولت عند فتح الكونتاكت، طرف 15)",
            jcbBritishStandardRuleAr = "يمتد من وضع تشغيل المفتاح (ON) إلى قضيب صندوق الفيوزات بالمقصورة لتوزيع الطاقة."
        ),
        WireColourCode(
            code = "G",
            baseColourEn = "Green",
            baseColourHi = "हरा (Green)",
            hexColor = 0xFF2E7D32,
            typicalCircuitEn = "Fused Ignition Auxiliary Circuits (Wipers, Indicators, Instrument Gauges)",
            typicalCircuitHi = "फ्यूज के बाद निकलने वाला इग्निशन सप्लाई (वाइपर, इंडिकेटर, मीटर पैनल)",
            jcbBritishStandardRuleEn = "Circuits active only when ignition key is turned ON and protected by internal blade fuses.",
            jcbBritishStandardRuleHi = "फ्यूज लगने के बाद मीटर डिस्प्ले, वाइपर मोटर और सेंसरों में जाने वाला सुरक्षित तार।",
            baseColourAr = "أخضر (Green)",
            typicalCircuitAr = "دوائر الإشعال المساعدة المحمية بفيوز (المساحات، الغمازات، العدادات)",
            jcbBritishStandardRuleAr = "دوائر تعمل فقط عند تشغيل المفتاح وتكون محمية بمصهرات داخلية."
        ),
        WireColourCode(
            code = "U",
            baseColourEn = "Blue (Light Blue / Dark Blue)",
            baseColourHi = "नीला (Blue)",
            hexColor = 0xFF1976D2,
            typicalCircuitEn = "Headlight Circuits (High Beam / Low Beam selector circuits)",
            typicalCircuitHi = "हेडलाइट सर्किट (हाई बीम और लो बीम लाइट तार)",
            jcbBritishStandardRuleEn = "Blue with Red stripe (U/R) = Low Beam (Dipper). Blue with White stripe (U/W) = High Beam (Main beam).",
            jcbBritishStandardRuleHi = "नीले पर लाल धारी = लो बीम (पास लाइट)। नीले पर सफेद धारी = हाई बीम (तेज मुख्य रोशनी)।",
            baseColourAr = "أزرق (Blue)",
            typicalCircuitAr = "دوائر المصابيح الأمامية (النور العالي والنور الواطي)",
            jcbBritishStandardRuleAr = "أزرق بخط أحمر (U/R) = النور الواطي. أزرق بخط أبيض (U/W) = النور العالي."
        ),
        WireColourCode(
            code = "N",
            baseColourEn = "Brown",
            baseColourHi = "भूरा (Brown)",
            hexColor = 0xFF6D4C41,
            typicalCircuitEn = "Alternator Charging Output (B+) & Main Power Distribution",
            typicalCircuitHi = "अल्टरनेटर चार्जिंग आउटपुट (B+) और मेन पावर डिस्ट्रीब्यूशन",
            jcbBritishStandardRuleEn = "Heavy gauge wire from alternator B+ terminal to starter solenoid battery stud and battery isolator switch.",
            jcbBritishStandardRuleHi = "अल्टरनेटर से बैटरी चार्ज करने वाला मोटा तार जो स्टार्टर के मेन खूंटे पर जुड़ता है।",
            baseColourAr = "بني (Brown)",
            typicalCircuitAr = "خرج شحن الدينامو (+B) وتوزيع القدرة الرئيسي",
            jcbBritishStandardRuleAr = "سلك سميك من طرف الدينامو (+B) إلى مسمار السلف الرئيسي وقاطع البطارية."
        ),
        WireColourCode(
            code = "Y",
            baseColourEn = "Yellow",
            baseColourHi = "पीला (Yellow)",
            hexColor = 0xFFFBC02D,
            typicalCircuitEn = "Overdrive, Transmission Solenoid & Glow Plug / Pre-heat circuit",
            typicalCircuitHi = "ट्रांसमिशन सोलेनोइड, फॉरवर्ड-रिवर्स शटल और इंजन हीटर प्लग सर्किट",
            jcbBritishStandardRuleEn = "Used extensively for electro-hydraulic transmission solenoids and intake manifold air heaters.",
            jcbBritishStandardRuleHi = "गियरबॉक्स सोलेनोइड और ठंड में स्टार्ट करने वाले हीटर प्लग का तार।",
            baseColourAr = "أصفر (Yellow)",
            typicalCircuitAr = "ملفات ناقل الحركة اللولبية ودائرة شمعات التسخين المسبق",
            jcbBritishStandardRuleAr = "يُستخدم بشكل أساسي لملفات ناقل الحركة الكهروهيدروليكية وسخان هواء السحب."
        ),
        WireColourCode(
            code = "W/R",
            baseColourEn = "White with Red Stripe",
            baseColourHi = "सफेद पर लाल धारी (White/Red)",
            hexColor = 0xFFEEEEEE,
            stripeHexColor = 0xFFD32F2F,
            typicalCircuitEn = "Starter Motor Crank Signal (Terminal 50)",
            typicalCircuitHi = "स्टार्टर मोटर क्रैंकिंग सिग्नल तार (टर्मिनल 50 - सेल्फ मारते समय 12V)",
            jcbBritishStandardRuleEn = "Energizes starter relay coil and starter solenoid pull-in coil ONLY when key is turned fully to START position.",
            jcbBritishStandardRuleHi = "केवल चाबी को पूरा 'START' स्थिति में घुमाने पर 12 वोल्ट देता है जिससे सेल्फ घूमता है।",
            baseColourAr = "أبيض بخط أحمر (W/R)",
            typicalCircuitAr = "إشارة تشغيل محرك السلف (طرف 50)",
            jcbBritishStandardRuleAr = "يغذي ملف مرحل السلف والملف اللولبي للسلف فقط عند تدوير المفتاح لوضع البدء START."
        )
    )

    // 2. COMPLETE WIRING HARNESSES (MAIN, ENGINE, CABIN, LOADER, BACKHOE, TRANSMISSION)
    val wiringHarnesses: List<WiringHarnessModel> = listOf(
        WiringHarnessModel(
            id = "harness_engine_main",
            harnessNameEn = "EcoMAX / Tier-4 Engine Wiring Loom Assembly",
            harnessNameHi = "इंजन मुख्य वायरिंग लूम असेंबली (जेसीबी 3DX / 3CX)",
            harnessNameAr = "ضفيرة الأسلاك الرئيسية للمحرك (EcoMAX / 3DX / 3CX)",
            machineModels = listOf("JCB 3DX Super", "JCB 3CX Eco", "JCB 4CX", "CAT 424 Backhoe"),
            locationDescription = Bilingual(
                en = "Routes along right-hand chassis frame rail, over bell housing into engine cylinder block and fuel injection pump.",
                hi = "दाहिने चेसिस फ्रेम के साथ-साथ फ्लाईव्हील बेल हाउसिंग के ऊपर से होते हुए इंजन ब्लॉक और डीजल पंप तक जाता है।",
                ar = "تمتد على طول عارضة الشاسيه اليمنى فوق جرس الحذافة إلى كتلة المحرك ومضخة حقن الوقود."
            ),
            mainConnectors = listOf("ECU 60-Pin Deutsch Header", "Alternator 2-Pin Plug", "Starter Solenoid 1-Pin Terminal 50", "Fuel Shut-off Solenoid Plug"),
            groundPoints = listOf(
                Bilingual("Chassis Ground Stud Behind Starter Motor (0V reference)", "स्टार्टर मोटर के पीछे चेसिस पर लगा मुख्य अर्थिंग स्टड"),
                Bilingual("Engine Block Earthing Strap connecting to Chassis", "इंजन ब्लॉक से चेसिस को जोड़ने वाली चौड़ी अर्थिंग जाली पट्टी")
            ),
            commonFaults = listOf(
                Bilingual("Harness rubs against sharp exhaust heat shield bracket causing fuse F2 to blow", "एग्जॉस्ट ब्रैकेट से रगड़कर तार छिल जाना जिससे बार-बार फ्यूज उड़ना"),
                Bilingual("Oil seepage into fuel shut-off solenoid connector causing intermittent machine stall", "डीजल सोलेनोइड के प्लग में इंजन ऑयल घुसने से मशीन का अचानक बंद पड़ना")
            ),
            wires = listOf(
                WireDetail(
                    wireId = "ENG-01",
                    gaugeMm2 = "35.0 mm² (Heavy Cable)",
                    colourCode = "Red (R)",
                    hexPrimary = 0xFFD32F2F,
                    circuitVoltage = "+12V Constant Battery",
                    startLocation = Bilingual("Battery Isolator Switch Output Stud", "बैटरी कट-ऑफ स्विच आउटपुट खूंटी"),
                    endLocation = Bilingual("Starter Motor Heavy B+ Stud (30)", "स्टार्टर मोटर मेन 12V टर्मिनल (30)"),
                    connectorPinStart = "M10 Brass Lug",
                    connectorPinEnd = "M10 Copper Stud",
                    purpose = Bilingual("Delivers up to 600 Amps cranking surge to starter motor", "स्टार्ट करते समय 600 एम्पीयर का भारी करंट स्टार्टर को पहुंचाना"),
                    testMethod = Bilingual("Connect DC voltmeter between battery (+) and starter stud; voltage drop during cranking must be < 0.5V", "क्रैंकिंग के समय वोल्टेज ड्रॉप चेक करें (0.5V से कम होना चाहिए)")
                ),
                WireDetail(
                    wireId = "ENG-02",
                    gaugeMm2 = "2.5 mm² (14 AWG)",
                    colourCode = "White/Red (W/R)",
                    hexPrimary = 0xFFEEEEEE,
                    hexStripe = 0xFFD32F2F,
                    circuitVoltage = "+12V Momentary Crank Only",
                    startLocation = Bilingual("Starter Relay Output Pin 87", "स्टार्टर रिले आउटपुट पिन 87"),
                    endLocation = Bilingual("Starter Solenoid Spade Terminal (50)", "स्टार्टर सोलेनोइड छोटा टर्मिनल (50)"),
                    connectorPinStart = "Relay Socket Pin 87",
                    connectorPinEnd = "Push-on 6.3mm Spade",
                    purpose = Bilingual("Triggers magnetic solenoid plunger to mesh starter pinion gear with flywheel", "सोलेनोइड को खींचकर स्टार्टर के दांते फ्लाईव्हील में फंसाना"),
                    testMethod = Bilingual("Probe spade wire with test light while cranking; test light must glow brightly", "सेल्फ मारते समय टेस्ट लैंप जलाकर 12 वोल्ट चेक करें")
                ),
                WireDetail(
                    wireId = "ENG-03",
                    gaugeMm2 = "1.5 mm² (16 AWG)",
                    colourCode = "Brown/Yellow (N/Y)",
                    hexPrimary = 0xFF6D4C41,
                    hexStripe = 0xFFFBC02D,
                    circuitVoltage = "+12V Switched Fuel Run",
                    startLocation = Bilingual("Engine Stop Relay / Key Switch Pin 15", "इंजन स्टॉप रिले / चाबी पिन 15"),
                    endLocation = Bilingual("Fuel Injection Pump Shut-Off Solenoid (FSO)", "डीजल पंप कट-ऑफ सोलेनोइड"),
                    connectorPinStart = "Fuse Box Terminal F4",
                    connectorPinEnd = "AMP Superseal 2-Pin (Pin 1)",
                    purpose = Bilingual("Holds diesel valve open to keep engine running; drops to 0V when key switched off", "डीजल लाइन खुली रखना; चाबी बंद करते ही 0V होकर इंजन बंद करना"),
                    testMethod = Bilingual("Unplug connector with key ON; must measure 12.0V - 12.6V against engine block", "चाबी ON पर प्लग में 12 वोल्ट की जांच करें")
                )
            ),
            manualReference = "JCB 3DX/3CX Service Manual Section C-1 (Engine Electrical Schematics)"
        ),
        WiringHarnessModel(
            id = "harness_cabin_dashboard",
            harnessNameEn = "Cabin Console & Instrument Panel Loom",
            harnessNameHi = "कैबिन कंसोल और इंस्ट्रूमेंट क्लस्टर लूम",
            harnessNameAr = "ضفيرة كونسول المقصورة ولوحة العدادات",
            machineModels = listOf("JCB 3DX", "JCB 3CX", "JCB 4CX", "JCB 5CX", "CAT 416/424"),
            locationDescription = Bilingual(
                en = "Integrated under front steering column housing and side right-hand armrest console.",
                hi = "स्टीयरिंग कॉलम के नीचे और साइड कंसोल में स्थित जहां सारे स्विच और मीटर लगे होते हैं।",
                ar = "مدمجة أسفل عمود التوجيه الأمامي وكونسول مسند الذراع الأيمن بالمقصورة."
            ),
            mainConnectors = listOf("Cluster 32-Pin Connector", "Steering Column Switch 14-Pin", "Side Fuse Console Multi-Plug"),
            groundPoints = listOf(
                Bilingual("Cabin A-Pillar Earth Stud behind fuse board", "फ्यूज बोर्ड के पीछे कैबिन के पिलर पर लगा अर्थिंग बोल्ट")
            ),
            commonFaults = listOf(
                Bilingual("Steering column tilt friction damages turn indicator harness wires over time", "स्टीयरिंग ऊपर-नीचे करने से तारों का अंदर से टूट जाना"),
                Bilingual("Spilled water/tea on console corrodes warning buzzer terminal", "कंसोल पर पानी या चाय गिरने से मीटर के पिनों पर जंग लगना")
            ),
            wires = listOf(
                WireDetail(
                    wireId = "CAB-01",
                    gaugeMm2 = "1.5 mm² (16 AWG)",
                    colourCode = "Green (G)",
                    hexPrimary = 0xFF2E7D32,
                    circuitVoltage = "+12V Fused Key ON",
                    startLocation = Bilingual("Fuse F8 (10A Gauge Fuse)", "फ्यूज F8 (10 एम्पीयर मीटर फ्यूज)"),
                    endLocation = Bilingual("Instrument Cluster Pin 4 (Power Input)", "क्लस्टर पिन 4 (पावर सप्लाई)"),
                    connectorPinStart = "Fuse Board Rail",
                    connectorPinEnd = "Cluster 32-Pin Header (Pin 4)",
                    purpose = Bilingual("Powers tachometer, fuel gauge, temperature gauge, and LCD hour meter", "आरपीएम मीटर, तापमान सुई, फ्यूज गेज और घंटा मीटर को चालू करना"),
                    testMethod = Bilingual("Verify +12V at Pin 4 when ignition key is in ON position", "चाबी ON पर पिन 4 पर 12 वोल्ट नापें")
                ),
                WireDetail(
                    wireId = "CAB-02",
                    gaugeMm2 = "1.0 mm² (18 AWG)",
                    colourCode = "Black (B)",
                    hexPrimary = 0xFF141311,
                    circuitVoltage = "0V Ground",
                    startLocation = Bilingual("Instrument Cluster Pin 1", "इंस्ट्रूमेंट क्लस्टर पिन 1"),
                    endLocation = Bilingual("Cabin Pillar Earth Stud", "कैबिन पिलर अर्थिंग बोल्ट"),
                    connectorPinStart = "Cluster Pin 1",
                    connectorPinEnd = "M6 Ground Eyelet",
                    purpose = Bilingual("Provides zero-volt reference for gauges, warning lamps, and CAN-bus", "मीटर और लाइटों को अर्थिंग (ग्राउंड) देना"),
                    testMethod = Bilingual("Continuity beep test between Pin 1 and bare metal chassis; resistance must be < 0.2 Ohms", "मल्टीमीटर बीप पर रखकर चेसिस से रेसिस्टेंस नापें (0.2 ओम से कम होना चाहिए)")
                )
            ),
            manualReference = "JCB Electrical Service Manual Section C-3 (Cabin Schematics)"
        ),
        WiringHarnessModel(
            id = "harness_transmission_hydraulics",
            harnessNameEn = "Transmission Synchroshuttle & Hydraulic Solenoid Loom",
            harnessNameHi = "ट्रांसमिशन शटल और हाइड्रोलिक सोलेनोइड लूम",
            harnessNameAr = "ضفيرة ناقل الحركة والملفات اللولبية الهيدروليكية",
            machineModels = listOf("JCB 3DX", "JCB 3CX Eco", "JCB 4CX", "CAT 424B"),
            locationDescription = Bilingual(
                en = "Runs under cabin floor plate down to transmission top valve block and auxiliary hydraulic loader dump valve.",
                hi = "कैबिन के फर्श के नीचे से होकर गियरबॉक्स के ऊपर लगे सोलेनोइड वॉल्व ब्लॉक तक जाता है।",
                ar = "تمتد أسفل أرضية المقصورة إلى مجموعة صمامات أعلى ناقل الحركة وصمام التفريغ الهيدروليكي."
            ),
            mainConnectors = listOf("Forward Solenoid 2-Pin Plug", "Reverse Solenoid 2-Pin Plug", "Dump Valve Button Plug"),
            groundPoints = listOf(
                Bilingual("Transmission Case Earth Lug", "ट्रांसमिशन हाउसिंग पर लगा अर्थिंग नट")
            ),
            commonFaults = listOf(
                Bilingual("Shuttle lever micro-switch contacts pitted; machine stays in neutral", "शटल लीवर के अंदर का माइक्रो-स्विच खराब होने से गियर न लगना"),
                Bilingual("Solenoid coil internal winding opens when hot (resistance jumps to infinity)", "गर्म होने पर सोलेनोइड कॉइल का तार अंदर से टूट जाना")
            ),
            wires = listOf(
                WireDetail(
                    wireId = "TRN-01",
                    gaugeMm2 = "1.5 mm² (16 AWG)",
                    colourCode = "Yellow/Red (Y/R)",
                    hexPrimary = 0xFFFBC02D,
                    hexStripe = 0xFFD32F2F,
                    circuitVoltage = "+12V Forward Selected",
                    startLocation = Bilingual("Column Shuttle Lever Pin F", "कॉलम शटल लीवर फॉरवर्ड पिन F"),
                    endLocation = Bilingual("Forward Solenoid Valve Coil (Pin 1)", "फॉरवर्ड सोलेनोइड वाल्व कॉइल (पिन 1)"),
                    connectorPinStart = "Column Switch Plug",
                    connectorPinEnd = "Deutsch DT 2-Pin",
                    purpose = Bilingual("Enables hydraulic pressure into forward clutch pack", "फॉरवर्ड क्लच प्लेट में तेल भेजकर मशीन को आगे बढ़ाना"),
                    testMethod = Bilingual("Shift to Forward with key ON; probe pin 1 for 12V. Measure solenoid coil resistance (10 - 12 Ohms)", "फॉरवर्ड लगाकर 12 वोल्ट और सोलेनोइड कॉइल का 10-12 ओम रेसिस्टेंस नापें")
                ),
                WireDetail(
                    wireId = "TRN-02",
                    gaugeMm2 = "1.5 mm² (16 AWG)",
                    colourCode = "Yellow/Green (Y/G)",
                    hexPrimary = 0xFFFBC02D,
                    hexStripe = 0xFF2E7D32,
                    circuitVoltage = "+12V Reverse Selected",
                    startLocation = Bilingual("Column Shuttle Lever Pin R", "कॉलम शटल लीवर रिवर्स पिन R"),
                    endLocation = Bilingual("Reverse Solenoid Valve & Back-up Beeper Relay", "रिवर्स सोलेनोइड वाल्व और बैक हॉर्न रिले"),
                    connectorPinStart = "Column Switch Plug",
                    connectorPinEnd = "Deutsch DT 2-Pin",
                    purpose = Bilingual("Clamps reverse directional clutches and sounds reversing safety alarm", "रिवर्स गियर लगाना और पीछे का चेतावनी हॉर्न बजाना"),
                    testMethod = Bilingual("Shift to Reverse; verify 12V at reverse solenoid and reversing beeper unit", "रिवर्स लगाकर 12V और बैक हॉर्न पर सप्लाई चेक करें")
                )
            ),
            manualReference = "JCB Powershift & Synchroshuttle Manual Section F-3"
        )
    )

    // 3. ALL LIGHTS AND LIGHT CABLES (15 DETAILED LIGHTING CIRCUITS)
    val machineLights: List<MachineLight> = listOf(
        MachineLight(
            id = "light_headlights_low_high",
            nameEn = "Main Headlights (High Beam & Low Beam)",
            nameHi = "मुख्य हेडलाइट्स (हाई बीम और लो बीम लाइट)",
            nameAr = "المصابيح الأمامية الرئيسية (العالي والواطي)",
            positionOnMachine = Bilingual(
                en = "Front nose cowl / radiator grille corners",
                hi = "मशीन के अगले बोनट / जाली के दोनों कोनों पर",
                ar = "زوايا غطاء المحرك الأمامي وشبكة الرادياتير"
            ),
            bulbTypeAndWattage = "H4 Halogen 12V 60W/55W (or Approved 48W LED Unit)",
            operatingVoltage = "12V - 13.8V DC",
            positiveWireColour = "Blue/Red (Low Beam) & Blue/White (High Beam)",
            positiveHex = 0xFF1976D2,
            negativeWireColour = "Black (B) Ground",
            negativeHex = 0xFF141311,
            switchControl = Bilingual("Steering column rotary light switch + dip stalk", "स्टीयरिंग कॉलम पर लगा रोटरी लाइट स्विच व डिपर लीवर"),
            fuseNumberAndRating = "Fuse F14 (Low Beam 15A) | Fuse F15 (High Beam 15A)",
            relayNumber = "Relay R4 (Headlight Main Power Relay)",
            connectorAndPins = "3-Pin H4 Ceramic Plug: Pin 1 (Left): Low Beam (U/R), Pin 2 (Top): High Beam (U/W), Pin 3 (Right): Ground (B)",
            testingProcedure = listOf(
                Bilingual("Step 1: Check voltage across Pin 3 (Ground) and battery negative; must read 0.0V (if higher, ground is loose)", "कदम 1: अर्थिंग पिन और बैटरी अर्थ में वोल्टेज नापें (0.0V होना चाहिए)"),
                Bilingual("Step 2: Turn on Low Beam; measure voltage between Pin 1 and Pin 3; should be 12.2V - 13.5V", "कदम 2: लो बीम ऑन करें और पिन 1 व 3 के बीच 12V सप्लाई नापें"),
                Bilingual("Step 3: Toggle stalk to High Beam; measure voltage between Pin 2 and Pin 3; High beam indicator on dash must glow", "कदम 3: डिपर लीवर खींचकर हाई बीम चेक करें और मीटर में नीली बत्ती देखें")
            ),
            repairSteps = listOf(
                Bilingual("Disconnect battery isolator before replacing ceramic bulb plugs", "प्लग बदलते समय बैटरी कट-ऑफ स्विच बंद रखें"),
                Bilingual("Never touch quartz glass bulb envelope with bare fingers; skin oils create hot-spots that shatter bulb", "बल्ब के कांच को नंगे हाथ से न छुएं, कपड़े से पकड़ें")
            ),
            manualReference = "JCB 3DX Operator Manual Chapter 4 (Lighting Systems)"
        ),
        MachineLight(
            id = "light_front_worklights",
            nameEn = "Front Cabin Roof Work Lights",
            nameHi = "फ्रंट कैबिन छत वर्क लाइट्स (रात में खुदाई हेतु)",
            nameAr = "كشافات العمل الأمامية بسقف المقصورة",
            positionOnMachine = Bilingual(
                en = "Front upper cabin roof visor corners (2x Flood Lamps)",
                hi = "कैबिन की छत के आगे दोनों कोनों पर लगे हैवी फ्लड लैंप्स",
                ar = "الزوايا العلوية الأمامية لسقف المقصورة (مصباحا كشف)"
            ),
            bulbTypeAndWattage = "H3 12V 55W Halogen or High-Lumen 16-LED Matrix 48W",
            operatingVoltage = "12V DC",
            positiveWireColour = "Blue/Black (U/B)",
            positiveHex = 0xFF1976D2,
            negativeWireColour = "Black (B) Ground",
            negativeHex = 0xFF141311,
            switchControl = Bilingual("Rocker Switch #1 on side dashboard with front lamp symbol", "साइड कंसोल पर लगा फ्रंट वर्क लाइट रॉकर स्विच"),
            fuseNumberAndRating = "Fuse F16 (15 Amp Work Light Fuse)",
            relayNumber = "Relay R6 (Front Work Light Relay)",
            connectorAndPins = "Deutsch DT06-2S Sealed 2-Pin Plug: Pin 1 (+12V Switched), Pin 2 (Earth)",
            testingProcedure = listOf(
                Bilingual("Press front work light switch; verify rocker LED illuminates", "स्विच दबाएं और देखें कि स्विच की छोटी बत्ती जल रही है या नहीं"),
                Bilingual("Listen for Relay R6 clicking in fuse console", "कंसोल में रिले R6 के 'कट' बोलने की आवाज सुनें"),
                Bilingual("Measure 12V at Deutsch 2-pin connector on roof visor", "छत पर लगे 2-पिन प्लग में 12V नापें")
            ),
            repairSteps = listOf(
                Bilingual("Inspect roof rubber grommet for rain water ingress that corrodes connector pins", "छत की रबड़ चेक करें ताकि बारिश का पानी प्लग में न जाए")
            ),
            manualReference = "JCB Electrical Service Publication Section C-5"
        ),
        MachineLight(
            id = "light_rear_worklights",
            nameEn = "Rear Backhoe Excavator Work Lights",
            nameHi = "रियर बैकहो वर्क लाइट्स (पीछे बकेट खुदाई लाइट)",
            nameAr = "كشافات العمل الخلفية للحفار",
            positionOnMachine = Bilingual(
                en = "Rear cabin roof frame corners pointing downward at backhoe dipper and trench",
                hi = "कैबिन की छत पर पीछे दोनों कोनों पर, जो नीचे बूम और गड्ढे में रोशनी देती हैं",
                ar = "الزوايا الخلفية لسقف المقصورة متجهة نحو ذراع الحفار الخلفي"
            ),
            bulbTypeAndWattage = "H3 12V 55W Halogen or Sealed 48W LED Spot/Flood",
            operatingVoltage = "12V DC",
            positiveWireColour = "Blue/Orange (U/O)",
            positiveHex = 0xFF1976D2,
            negativeWireColour = "Black (B) Ground",
            negativeHex = 0xFF141311,
            switchControl = Bilingual("Rocker Switch #2 on side dashboard with rear lamp symbol", "साइड कंसोल पर लगा रियर वर्क लाइट रॉकर स्विच"),
            fuseNumberAndRating = "Fuse F17 (15 Amp Rear Work Light Fuse)",
            relayNumber = "Relay R7 (Rear Work Light Relay)",
            connectorAndPins = "Deutsch DT06-2S 2-Pin: Pin 1 (+12V), Pin 2 (Ground)",
            testingProcedure = listOf(
                Bilingual("Verify rear work light fuse F17 is intact with multimeter buzzer test", "फ्यूज F17 को मल्टीमीटर से चेक करें कि उड़ा तो नहीं है"),
                Bilingual("Check ground continuity from roof frame to main chassis earth", "छत के फ्रेम से चेसिस की अर्थिंग चेक करें")
            ),
            repairSteps = listOf(
                Bilingual("Tighten M10 mounting swivel bracket bolts to 35 Nm to stop lights shaking during digging", "लाइट के ब्रैकेट बोल्ट 35 Nm पर कसें ताकि खुदाई के कंपन से न हिले")
            ),
            manualReference = "JCB Service Manual Section C-5"
        ),
        MachineLight(
            id = "light_brake_stop_lights",
            nameEn = "Rear Brake (Stop) Lights",
            nameHi = "रियर ब्रेक (स्टॉप) लाइट्स",
            nameAr = "أضواء الفرامل الخلفية (التوقف)",
            positionOnMachine = Bilingual(
                en = "Rear mudguard red tail lamp lens assemblies",
                hi = "पिछले दोनों मडगार्ड पर लगी लाल टेल लाइट असेंबली",
                ar = "مجموعة المصابيح الخلفية الحمراء على الرفارف الخلفية"
            ),
            bulbTypeAndWattage = "P21W 12V 21W Bayonet Single/Dual Filament Bulb",
            operatingVoltage = "12V DC",
            positiveWireColour = "Green/Purple (G/P)",
            positiveHex = 0xFF2E7D32,
            negativeWireColour = "Black (B) Ground",
            negativeHex = 0xFF141311,
            switchControl = Bilingual("Hydraulic Brake Pressure Switch fitted to master cylinder line", "ब्रेक मास्टर सिलेंडर की लाइन पर लगा हाइड्रोलिक प्रेशर स्विच"),
            fuseNumberAndRating = "Fuse F9 (10 Amp Brake Light Fuse)",
            relayNumber = "Directly Switched via Hydraulic Switch Contacts (No relay)",
            connectorAndPins = "Round 2-Pin Bayonet Tail Lamp Connector",
            testingProcedure = listOf(
                Bilingual("Depress brake pedals firmly; probe Green/Purple wire at tail lamp for 12V", "ब्रेक पेडल दबाएं और मडगार्ड पर हरे/बैंगनी तार में 12V नापें"),
                Bilingual("If no power, bridge the two spade terminals on the master cylinder hydraulic brake switch with a jumper wire; if lights glow, replace switch", "यदि करंट न आए तो ब्रेक स्विच के दोनों तारों को आपस में छूकर देखें; लाइट जलने पर ब्रेक स्विच बदलें")
            ),
            repairSteps = listOf(
                Bilingual("Clean bulb holder spring contacts with fine emery cloth to remove corrosion", "बल्ब होल्डर के अंदर की पत्ती को रेगमाल से साफ करें")
            ),
            manualReference = "JCB Service Manual Section C-4 (Braking Electrical)"
        ),
        MachineLight(
            id = "light_amber_beacon",
            nameEn = "Rotating / Strobe Amber Warning Beacon Light",
            nameHi = "छत पर घूमने वाली पीली चेतावनी लाइट (रोटेटिंग बीकन)",
            nameAr = "ضوء التحذير الكهرماني الدوار (السفتي)",
            positionOnMachine = Bilingual(
                en = "Removable magnetic or spigot mount on highest point of cabin roof",
                hi = "कैबिन की छत पर सबसे ऊपर लगा पाइप सॉकेट या चुंबक बेस",
                ar = "قاعدة قابلة للفك بأعلى نقطة في سقف المقصورة"
            ),
            bulbTypeAndWattage = "H1 12V 55W Halogen with gear rotator or High-Intensity LED Flasher",
            operatingVoltage = "12V DC",
            positiveWireColour = "Purple/Brown (P/N)",
            positiveHex = 0xFF7B1FA2,
            negativeWireColour = "Black (B) Ground",
            negativeHex = 0xFF141311,
            switchControl = Bilingual("Beacon rocker switch on cabin console", "कैबिन कंसोल पर लगा बीकन स्विच"),
            fuseNumberAndRating = "Fuse F18 (10 Amp Beacon Fuse)",
            relayNumber = "Switched direct or via Auxiliary Relay R8",
            connectorAndPins = "DIN 72591 Standard Amber Beacon Spigot Pin (Center +12V, Collar Ground)",
            testingProcedure = listOf(
                Bilingual("Measure voltage at center brass terminal of roof DIN socket; must read 12V when switch engaged", "छत के सॉकेट के बीच वाले पीतल के पिन पर 12V नापें"),
                Bilingual("Check beacon internal gear drive belt if halogen motor runs but beacon fails to rotate", "यदि मोटर की आवाज आए पर घूमे नहीं तो बीकन की छोटी रबर बेल्ट चेक करें")
            ),
            repairSteps = listOf(
                Bilingual("Ensure silicone sealing boot is pulled tightly over roof DIN socket to prevent rain water entering cabin headlining", "छत की रबड़ कैप को सही बैठाएं ताकि बारिश का पानी कैबिन में न टपके")
            ),
            manualReference = "JCB Safety & Regulatory Compliance Section A"
        )
    )

    // 4. COMPLETE FUSE BOX SYSTEM (CABIN & ENGINE BAY FUSES WITH PRECISE AMPERES)
    val fuses: List<FuseSpec> = listOf(
        FuseSpec(
            fuseId = "F1",
            boxLocation = FuseBoxLocation.MAIN_CABIN,
            ratingAmps = 10,
            colorStandard = "Red (10 Amp Standard ATO Blade)",
            protectedCircuitsEn = "Instrument Cluster Electronics, Warning Indicators, Engine Stop Solenoid Logic",
            protectedCircuitsHi = "मीटर डिस्प्ले, डैशबोर्ड चेतावनी बत्तियां, इंजन स्टॉप सोलेनोइड सर्किट",
            protectedCircuitsAr = "إلكترونيات لوحة العدادات ومؤشرات التحذير وملف إيقاف المحرك",
            wireFeedSource = "Key Switch Terminal 15 via White Wire",
            blownSymptoms = Bilingual(
                en = "Engine shuts down immediately; all instrument dials drop to zero; no warning lamps illuminate with key ON.",
                hi = "इंजन तुरंत बंद हो जाता है; सारे मीटर बंद हो जाते हैं; चाबी ऑन करने पर कोई बत्ती नहीं जलती।",
                ar = "يتوقف المحرك فوراً وتنطفئ جميع العدادات ولمبات التحذير عند فتح المفتاح."
            ),
            troubleshootingSteps = listOf(
                Bilingual("Disconnect fuel stop solenoid plug and replace fuse F1. If fuse holds with solenoid disconnected, solenoid coil is shorted to ground", "डीजल सोलेनोइड का प्लग निकालें और नया फ्यूज लगाएं। यदि फ्यूज नहीं उड़ता तो सोलेनोइड शॉर्ट है"),
                Bilingual("Inspect alternator D+ excitation wire for chafing against engine block bracket", "अल्टरनेटर का पतला तार इंजन ब्लॉक से घिस तो नहीं रहा यह चेक करें")
            ),
            warningNote = Bilingual(
                en = "CRITICAL: Never replace 10A fuse with 15A or 20A or bypass with copper wire. Doing so will melt the instrument cluster PCB traces.",
                hi = "चेतावनी: 10 एम्पीयर की जगह 15 या 20 एम्पीयर का फ्यूज न लगाएं और तांबे का तार न बांधें, इससे मीटर की प्लेट जल जाएगी।",
                ar = "تحذير حرج: لا تستبدل فيوز 10A بآخر 15A أو 20A أو بسلك نحاسي؛ يؤدي ذلك إلى احتراق لوحة العدادات."
            )
        ),
        FuseSpec(
            fuseId = "F2",
            boxLocation = FuseBoxLocation.MAIN_CABIN,
            ratingAmps = 15,
            colorStandard = "Blue (15 Amp Standard ATO Blade)",
            protectedCircuitsEn = "Transmission Forward / Reverse Shuttle Solenoids & Neutral Safety Interlock",
            protectedCircuitsHi = "ट्रांसमिशन फॉरवर्ड / रिवर्स सोलेनोइड्स और न्यूट्रल सेफ्टी स्विच",
            protectedCircuitsAr = "ملفات الأمام والخلف بناقل الحركة ومفتاح أمان الحياد",
            wireFeedSource = "Ignition Auxiliary Relay R1",
            blownSymptoms = Bilingual(
                en = "Machine will not engage forward or reverse drive; transmission remains locked in neutral even with gear lever selected.",
                hi = "मशीन आगे या पीछे नहीं चलती; गियर लगाने पर भी ट्रांसमिशन न्यूट्रल में फंसा रहता है।",
                ar = "لا تعشق المعدة الحركة للأمام أو الخلف وتبقى في وضع الحياد رغم تحريك الذراع."
            ),
            troubleshootingSteps = listOf(
                Bilingual("Check forward and reverse solenoid coils at transmission top valve with multimeter (normal: 10 - 12 Ohms)", "ट्रांसमिशन के ऊपर दोनों सोलेनोइड का रेसिस्टेंस नापें (10-12 ओम होना चाहिए)"),
                Bilingual("Inspect wiring harness passing under floor plate where loader linkage can pinch cables", "फर्श के नीचे तार चेक करें कि कहीं लोडर के लोहे में दबकर कट तो नहीं गया")
            ),
            warningNote = Bilingual(
                en = "Always ensure parking brake is applied before troubleshooting transmission electrical fuses.",
                hi = "गियरबॉक्स का फ्यूज चेक करते समय हैंडब्रेक जरूर लगाकर रखें।",
                ar = "تأكد دائماً من شد فرامل الوقوف قبل فحص فيوزات ناقل الحركة."
            )
        ),
        FuseSpec(
            fuseId = "F3",
            boxLocation = FuseBoxLocation.MAIN_CABIN,
            ratingAmps = 20,
            colorStandard = "Yellow (20 Amp Standard ATO Blade)",
            protectedCircuitsEn = "Cabin Front & Rear Windscreen Wiper Motors & Washer Pumps",
            protectedCircuitsHi = "आगे और पीछे के वाइपर मोटर तथा पानी का वाशर पंप",
            protectedCircuitsAr = "محركات مساحات الزجاج الأمامية والخلفية ومضخة الغسيل",
            wireFeedSource = "Ignition Switch Terminal 15",
            blownSymptoms = Bilingual(
                en = "Wipers stop midway on windshield; washer fluid spray motor dead.",
                hi = "वाइपर शीशे के बीच में ही रुक जाता है और पानी की मोटर नहीं चलती।",
                ar = "تتوقف المساحات في منتصف الزجاج ولا تعمل مضخة المياه."
            ),
            troubleshootingSteps = listOf(
                Bilingual("Check if wiper blades are frozen or stuck to rubber glass before replacing fuse", "फ्यूज बदलने से पहले देखें कि वाइपर ब्लेड शीशे पर जाम तो नहीं है"),
                Bilingual("Unplug wiper motor; test motor current draw on bench (max 4.5 Amps under wet load)", "वाइपर मोटर खोलकर चेक करें कि वह 4.5 एम्पीयर से ज्यादा करंट तो नहीं ले रही")
            ),
            warningNote = Bilingual(
                en = "Do not force wiper linkage by hand while circuit is energized.",
                hi = "करंट चालू होने पर वाइपर की पत्तियों को हाथ से जबरदस्ती न खींचें।",
                ar = "لا تحرك أذرع المساحات يدوياً بالقوة أثناء توصيل الطاقة."
            )
        ),
        FuseSpec(
            fuseId = "F4",
            boxLocation = FuseBoxLocation.ENGINE_BAY,
            ratingAmps = 60,
            colorStandard = "Yellow / Blue (60 Amp Heavy Duty Maxi Fuse)",
            protectedCircuitsEn = "Engine Glow Plugs / Intake Air Grid Pre-Heater",
            protectedCircuitsHi = "इंजन हीटर प्लग / इनटेक एयर ग्रिड हीटर (सर्दियों में स्टार्टिंग हेतु)",
            protectedCircuitsAr = "شمعات التوهج وسخان هواء السحب المسبق بالمحرك",
            wireFeedSource = "Permanent Battery Cable via Starter B+ Stud",
            blownSymptoms = Bilingual(
                en = "Engine exhibits extreme hard starting in cold winter conditions; heavy white/grey unburnt diesel exhaust smoke.",
                hi = "सर्दियों में मशीन स्टार्ट होने में बहुत समय लेती है और सफेद कच्चा धुआं फेंकती है।"
            ),
            troubleshootingSteps = listOf(
                Bilingual("Measure resistance of each glow plug (0.8 - 1.2 Ohms to ground). A shorted plug will blow this 60A maxi fuse instantly", "हर हीटर प्लग का रेसिस्टेंस नापें (0.8 से 1.2 ओम); शॉर्ट प्लग तुरंत 60A फ्यूज उड़ा देता है"),
                Bilingual("Check pre-heat relay heavy contacts for welded contacts", "प्री-हीटर रिले की पत्ती चेक करें कि चिपक तो नहीं गई")
            ),
            warningNote = Bilingual(
                en = "Disconnect battery ground terminal before servicing 60A engine bay maxi fuses.",
                hi = "60 एम्पीयर मैक्सी फ्यूज बदलने से पहले बैटरी का अर्थिंग तार जरूर हटा लें।"
            )
        )
    )

    // 5. COMPLETE RELAY SYSTEM (PIN DIAGRAMS & BENCH TESTING)
    val relays: List<RelaySpec> = listOf(
        RelaySpec(
            relayId = "R1",
            functionEn = "Starter Motor Safety Relay (Micro / Mini ISO 4-Pin)",
            functionHi = "स्टार्टर मोटर सेफ्टी रिले (4-पिन ऑटो रिले)",
            functionAr = "مرحل أمان محرك السلف (4 أطراف ISO)",
            pin85 = Bilingual("Chassis Ground via Transmission Neutral Safety Switch (0V only in Neutral)", "ट्रांसमिशन न्यूट्रल स्विच से ग्राउंड (केवल न्यूट्रल में ही अर्थिंग मिलती है)"),
            pin86 = Bilingual("Ignition Switch Crank Terminal 50 (+12V during Key START)", "चाबी से आने वाला क्रैंक तार (सेल्फ मारने पर +12V)"),
            pin30 = Bilingual("+12V Permanent Heavy Battery Feed from Fuse Box", "बैटरी से सीधा 12V मोटा मेन करंट"),
            pin87 = Bilingual("Output to Starter Solenoid Terminal 50 (White/Red Wire)", "स्टार्टर सोलेनोइड टर्मिनल 50 को जाने वाला आउटपुट (सफेद/लाल तार)"),
            resistanceOhmsCoil = "75 - 90 Ohms across Pin 85 and Pin 86",
            testingProcedure = listOf(
                Bilingual("Bench Test: Apply 12V across Pin 85 and Pin 86 using jumper leads; you must hear a crisp metallic 'CLICK'", "बेंच टेस्ट: पिन 85 और 86 पर 12V बैटरी करंट दें; तेज 'कट' की आवाज आनी चाहिए"),
                Bilingual("Continuity Check: While energized, check continuity between Pin 30 and Pin 87 with multimeter (resistance must be < 0.1 Ohm)", "करंट लगे होने पर पिन 30 और 87 का रेसिस्टेंस 0.1 ओम से कम होना चाहिए")
            ),
            jumperBypassWarning = Bilingual(
                en = "EMERGENCY ONLY: Jumping Pin 30 to Pin 87 bypasses the transmission neutral safety lock. Machine CAN START IN GEAR and run over bystanders. Always verify transmission is in NEUTRAL and wheels are blocked before jumping.",
                hi = "आपातकालीन चेतावनी: पिन 30 को 87 से मिलाने पर गियर में भी सेल्फ घूम सकता है जिससे मशीन किसी पर चढ़ सकती है! हमेशा न्यूट्रल चेक करके ही इमरजेंसी बाईपास करें।"
            ),
            replacementPartNo = "JCB Part 716/30123 / Bosch 0 332 019 150",
            manualReference = "JCB Electrical Service Manual Section C-2"
        ),
        RelaySpec(
            relayId = "R2",
            functionEn = "Main Ignition Power Hold Relay (5-Pin Changeover ISO)",
            functionHi = "मेन इग्निशन पावर होल्ड रिले (5-पिन रिले)",
            functionAr = "مرحل تثبيت طاقة التشغيل الرئيسي (5 أطراف)",
            pin85 = Bilingual("Chassis Earth Ground (0V)", "चेसिस अर्थिंग (0V)"),
            pin86 = Bilingual("Ignition Switch Key ON Terminal 15 (+12V)", "चाबी स्विच ON टर्मिनल 15 (+12V)"),
            pin30 = Bilingual("+12V Constant Battery Supply from 40A Fusible Link", "40A फ्यूज से सीधा 12V बैटरी करंट"),
            pin87 = Bilingual("Switched +12V Main Rail Supply to Fuses F1 through F10", "फ्यूज F1 से F10 को जाने वाली मुख्य 12V सप्लाई"),
            pin87a = Bilingual("Accessory Unlatched / Radio Memory (Optional)", "एक्सेसरी आउटपुट"),
            resistanceOhmsCoil = "80 - 95 Ohms",
            testingProcedure = listOf(
                Bilingual("Measure voltage at Pin 30 (must read 12.6V battery voltage at all times)", "पिन 30 पर हमेशा 12.6V बैटरी करंट आना चाहिए"),
                Bilingual("Verify Pin 87 outputs 12.4V+ when ignition key is turned to ON", "चाबी ON करने पर पिन 87 पर 12.4V+ करंट निकलना चाहिए")
            ),
            jumperBypassWarning = Bilingual(
                en = "Do not leave Pin 30 jumped to Pin 87 overnight; it will drain the machine battery completely within 12 hours.",
                hi = "पिन 30 और 87 को रात भर डायरेक्ट न छोड़ें, इससे 12 घंटे में पूरी बैटरी उतर जाएगी।"
            ),
            replacementPartNo = "JCB Part 716/24200 (12V 40A 5-Pin)",
            manualReference = "JCB Service Manual Section C-2"
        )
    )

    // 6. ALL ELECTRICAL SENSORS (16 SENSORS WITH PINOUTS & BENCH TESTS)
    val sensors: List<ElectricalSensorSpec> = listOf(
        ElectricalSensorSpec(
            id = "sensor_engine_oil_pressure",
            sensorNameEn = "Engine Oil Pressure Switch / Sensor",
            sensorNameHi = "इंजन ऑयल प्रेशर स्विच / सेंसर",
            sensorNameAr = "حساس ومفتاح ضغط زيت المحرك",
            applicableMachines = listOf("JCB 3DX", "JCB 3CX Eco", "JCB 4CX", "CAT 424B"),
            physicalLocation = Bilingual(
                en = "Threaded into main engine oil gallery on the left-hand side of the cylinder block, below oil filter.",
                hi = "इंजन ब्लॉक के बाएं हिस्से में, ऑयल फिल्टर के नीचे मेन ऑयल गैलरी में कसा होता है।"
            ),
            connectorTypeAndPins = "1-Pin Spade or 2-Pin AMP Superseal Connector",
            operatingVoltage = "12V Ground-Switching",
            outputSignalType = Bilingual(
                en = "Normally Closed (NC) ground switch; opens circuit when oil pressure exceeds 0.8 bar (11.6 psi)",
                hi = "इंजन बंद होने पर अर्थिंग जोड़ता है; ऑयल प्रेशर 0.8 बार से ऊपर जाते ही अर्थिंग काट देता है जिससे लाल बत्ती बुझ जाती है"
            ),
            pinoutDetails = listOf(
                Bilingual("Pin 1: Signal wire to Dashboard Oil Lamp", "पिन 1: डैशबोर्ड ऑयल बत्ती का सिग्नल तार"),
                Bilingual("Body Thread: Screws into block for chassis ground return", "बॉडी चूड़ी: इंजन ब्लॉक से अर्थिंग लेती है")
            ),
            normalResistanceOrSpecs = "Engine OFF: 0.1 Ohm (Continuity to ground) | Engine Running > 1000 RPM: Infinity (Open Circuit)",
            failureSymptoms = listOf(
                Bilingual("Oil warning lamp stays illuminated at all times even with correct engine oil level", "तेल पूरा होने पर भी डैशबोर्ड पर लाल ऑयल बत्ती लगातार जलते रहना"),
                Bilingual("Oil leaking past plastic sensor body diaphragm into electrical spade connector", "सेंसर के प्लास्टिक से तेल लीक होकर तार के प्लग में भरना")
            ),
            multimeterBenchTesting = listOf(
                Bilingual("Step 1: Check continuity from center pin to brass thread with engine stopped; multimeter buzzer MUST BEEP", "कदम 1: बंद इंजन में पिन और चूड़ी के बीच मल्टीमीटर बीप बोलना चाहिए"),
                Bilingual("Step 2: Start engine; buzzer MUST STOP BEEPING (Open circuit). If buzzer keeps beeping, connect mechanical pressure gauge to verify actual oil pressure before condemning sensor", "कदम 2: स्टार्ट करते ही बीप बंद होनी चाहिए। यदि बीप बजती रहे तो पहले पाना गेज लगाकर असली प्रेशर नापें")
            ),
            manualReference = "JCB Service Manual Section B-8 (Lubrication & Warning Systems)"
        ),
        ElectricalSensorSpec(
            id = "sensor_coolant_temperature",
            sensorNameEn = "Engine Coolant Temperature (ECT) NTC Sensor",
            sensorNameHi = "इंजन कूलेंट तापमान (ECT) NTC सेंसर",
            sensorNameAr = "حساس حرارة سائل تبريد المحرك (ECT)",
            applicableMachines = listOf("JCB 3DX", "JCB 3CX Eco", "JCB 4CX", "JCB 5CX"),
            physicalLocation = Bilingual(
                en = "Screwed into thermostat housing outlet on cylinder head facing radiator.",
                hi = "सिलेंडर हेड पर थर्मोस्टेट हाउसिंग के पास पानी के रास्ते में लगा होता है।"
            ),
            connectorTypeAndPins = "2-Pin Delphi Packard Weather-Pack Connector",
            operatingVoltage = "5.0V DC Regulated ECU Reference",
            outputSignalType = Bilingual(
                en = "Negative Temperature Coefficient (NTC) Thermistor (Resistance decreases as temperature rises)",
                hi = "तापमान बढ़ने पर इसका रेसिस्टेंस (प्रतिरोध) घटता है और वोल्टेज कम होता है"
            ),
            pinoutDetails = listOf(
                Bilingual("Pin A: 5.0V Sensor Reference Feed from ECU Pin 18", "पिन A: ईसीयू से 5 वोल्ट रेफरेंस सप्लाई"),
                Bilingual("Pin B: Sensor Ground Return to ECU Pin 24", "पिन B: ईसीयू को सिग्नल ग्राउंड वापसी")
            ),
            normalResistanceOrSpecs = "At 20°C (Cold): 2,400 - 2,600 Ohms | At 80°C (Normal Operating): 280 - 320 Ohms | At 100°C: 175 Ohms",
            failureSymptoms = listOf(
                Bilingual("Temperature gauge stays pinned at maximum red scale or minimum cold", "सुई पूरी लाल निशान पर चली जाना या बिल्कुल न उठना"),
                Bilingual("Engine ECU de-rates power by 20% and radiator cooling fan runs at 100% full speed", "इंजन की ताकत 20% कम हो जाना और पंखा लगातार तेज चलना")
            ),
            multimeterBenchTesting = listOf(
                Bilingual("Unplug sensor. Set multimeter to 20kΩ resistance scale. Probe across Pin A and Pin B while immersing brass tip in hot kettle water; resistance must drop smoothly from 2500Ω down to 300Ω", "सेंसर खोलकर गर्म पानी में डालें; मल्टीमीटर पर रेसिस्टेंस 2500 ओम से घटकर 300 ओम तक लगातार कम होना चाहिए")
            ),
            manualReference = "JCB Engine Management Manual Section C-4"
        ),
        ElectricalSensorSpec(
            id = "sensor_crankshaft_position",
            sensorNameEn = "Crankshaft Position (CKP) Sensor (Engine Speed / Timing)",
            sensorNameHi = "क्रैंकशाफ्ट पोजीशन (CKP) सेंसर (इंजन स्पीड व टाइमिंग सेंसर)",
            sensorNameAr = "حساس موضع عمود المرفق وسرعة المحرك (CKP)",
            applicableMachines = listOf("JCB EcoMAX 4.4L / 4.8L", "CAT 3054C / C4.4", "Cummins 4BTA"),
            physicalLocation = Bilingual(
                en = "Mounted through flywheel housing adjacent to the engine flywheel reluctor ring (60-2 target teeth).",
                hi = "फ्लाईव्हील हाउसिंग पर, जहां अंदर घूमने वाले दांतेदार पहिए की सीध में लगा होता है।"
            ),
            connectorTypeAndPins = "3-Pin Shielded Bosch / Deutsch Plug: Pin 1 (Signal +), Pin 2 (Signal -), Pin 3 (Braided Shield Earth)",
            operatingVoltage = "Generates its own AC millivolt signal (Variable Reluctance)",
            outputSignalType = Bilingual(
                en = "Analog Sinusoidal AC voltage (0.5V to 4.5V AC RMS during cranking)",
                hi = "घूमते दांतों से खुद एसी (AC) वोल्टेज की तरंगे बनाता है (क्रैंकिंग में 1V से 3V AC)"
            ),
            pinoutDetails = listOf(
                Bilingual("Pin 1: CKP High Signal to ECU", "पिन 1: ईसीयू को टाइमिंग पल्स सिग्नल"),
                Bilingual("Pin 2: CKP Low Signal Return", "पिन 2: सिग्नल रिटर्न तार"),
                Bilingual("Pin 3: Braided Foil Noise Shield (prevents starter motor electrical noise interference)", "पिन 3: शोर रोकने वाली शील्ड अर्थिंग")
            ),
            normalResistanceOrSpecs = "Coil Resistance: 850 - 1,150 Ohms at 20°C | Air Gap: 0.8 mm to 1.2 mm",
            failureSymptoms = listOf(
                Bilingual("Engine cranks vigorously but will NEVER start (ECU cannot detect engine rotation to fire fuel injectors)", "सेल्फ खूब तेज घूमता है पर इंजन बिल्कुल स्टार्ट नहीं होता"),
                Bilingual("Tachometer (RPM meter) stays completely at 0 RPM during cranking", "सेल्फ मारते समय आरपीएम मीटर की सुई बिल्कुल नहीं हिलती")
            ),
            multimeterBenchTesting = listOf(
                Bilingual("Step 1 (Resistance): Measure resistance across Pin 1 and Pin 2 (must read 900 - 1100 Ohms; open circuit = dead sensor)", "कदम 1: पिन 1 और 2 के बीच 900 से 1100 ओम चेक करें"),
                Bilingual("Step 2 (AC Voltage Crank Test): Set multimeter to AC Volts (ṽ 2V scale). Crank engine; voltage across Pin 1 and 2 MUST read at least 0.8V to 1.5V AC. If 0V, sensor or reluctor ring is damaged", "कदम 2: मल्टीमीटर AC वोल्ट पर लगाएं। सेल्फ मारते समय कम से कम 0.8V से 1.5V AC आना चाहिए")
            ),
            manualReference = "JCB Common Rail Diagnostic Guide Section B-9"
        ),
        ElectricalSensorSpec(
            id = "sensor_water_in_fuel",
            sensorNameEn = "Water-in-Fuel (WIF) Probe Sensor",
            sensorNameHi = "वाटर-इन-फ्यूल (WIF) सेंसर (डीजल में पानी जांच सेंसर)",
            sensorNameAr = "حساس وجود الماء في الوقود (WIF)",
            applicableMachines = listOf("JCB 3DX", "JCB 3CX Eco", "JCB 4CX", "JCB NXT 215"),
            physicalLocation = Bilingual(
                en = "Screwed into bottom of fuel pre-filter transparent water separator bowl.",
                hi = "डीजल के प्राइमरी वाटर सेपरेटर फिल्टर के शीशे के कटोरे के नीचे कसा होता है।"
            ),
            connectorTypeAndPins = "2-Pin Sealed Oval Waterproof Plug",
            operatingVoltage = "12V Low-Current Sensing Circuit",
            outputSignalType = Bilingual(
                en = "Conductivity detection (Water conducts electricity across dual electrodes; pure diesel is non-conductive)",
                hi = "पानी जमा होने पर दोनों इलेक्ट्रोड के बीच बिजली का बहाव शुरू होता है और बत्ती जलती है"
            ),
            pinoutDetails = listOf(
                Bilingual("Pin 1: 12V Sense wire from cluster", "पिन 1: 12V सेंसिंग तार"),
                Bilingual("Pin 2: Ground return wire", "पिन 2: ग्राउंड वापसी तार")
            ),
            normalResistanceOrSpecs = "In Clean Diesel: > 1,000,000 Ohms (Infinite Resistance) | Submerged in Water: < 50,000 Ohms (Conducting)",
            failureSymptoms = listOf(
                Bilingual("Yellow water separator icon permanently glowing on instrument console", "डैशबोर्ड पर पानी वाली पीली बत्ती लगातार जलते रहना"),
                Bilingual("Risk of catastrophic common rail injector seizure if drained bowl warning is ignored", "यदि पानी न निकाला जाए तो हाई प्रेशर पंप व इंजेक्टर तुरंत सीज हो जाते हैं")
            ),
            multimeterBenchTesting = listOf(
                Bilingual("Unscrew sensor probe. Clean dry with rag. Resistance between two stainless tip pins must be infinite. Dip tip in cup of tap water; resistance must immediately drop below 50 kΩ", "साफ सूखे सेंसर पर अनंत रेसिस्टेंस होना चाहिए; पानी में डुबोते ही 50 kΩ से नीचे आ जाना चाहिए")
            ),
            manualReference = "JCB Operator Handbook Maintenance Section 5"
        )
    )

    // 7. ALL SWITCHES AND CONTROLS
    val switches: List<SwitchSpec> = listOf(
        SwitchSpec(
            id = "switch_ignition_rotary",
            switchNameEn = "Heavy Duty 4-Position Key Ignition Switch",
            switchNameHi = "4-पोजीशन हेवी ड्यूटी चाबी इग्निशन स्विच",
            switchNameAr = "مفتاح التشغيل الرئيسي بالمفتاح (4 أوضاع للخدمة الشاقة)",
            location = Bilingual("Right-hand steering column console panel", "स्टीयरिंग के दाहिनी तरफ कंसोल पैनल पर"),
            switchType = "4-Position Spring-Return Rotary Key Switch (Pos 0: OFF, Pos 1: ACC, Pos 2: IGN/ON, Pos 3: START)",
            terminalPinout = listOf(
                Bilingual("Terminal 30: Battery Direct (+12V Constant Feed)", "टर्मिनल 30: सीधा बैटरी का 12V मेन तार"),
                Bilingual("Terminal 15: Ignition Switched (+12V in Pos 2 & 3)", "टर्मिनल 15: चाबी ऑन करने पर चालू 12V तार"),
                Bilingual("Terminal 19: Pre-Heat / Glow Plug Position (+12V held left)", "टर्मिनल 19: हीटर प्लग चालू करने वाला तार"),
                Bilingual("Terminal 50: Starter Solenoid (+12V spring-return Pos 3)", "टर्मिनल 50: सेल्फ मारने पर निकलने वाला 12V तार")
            ),
            normalContinuityTruthTable = listOf(
                Bilingual("Key in OFF (0): No continuity between any terminals", "चाबी OFF: किसी टर्मिनल में आपस में कोई कनेक्शन नहीं"),
                Bilingual("Key in ON (2): Continuity BEEP between Term 30 and Term 15", "चाबी ON (2): टर्मिनल 30 और 15 आपस में जुड़ते हैं (बीप बोलेगा)"),
                Bilingual("Key in START (3): Continuity BEEP between Term 30, Term 15, and Term 50", "चाबी START (3): 30, 15 और 50 तीनों आपस में जुड़ जाते हैं")
            ),
            testingWithMultimeter = listOf(
                Bilingual("Disconnect battery before pulling switch plug. Set meter to continuity beeper. Touch probes to Term 30 and Term 50. Turn key to START; meter MUST BEEP. If no beep, internal brass contact discs are burnt; replace switch", "मल्टीमीटर बीप पर रखकर 30 और 50 पर लगाएं; सेल्फ की पोजीशन में बीप बजनी चाहिए")
            ),
            commonFailureModes = listOf(
                Bilingual("Worn mechanical tumbler allows key to fall out while machine is bouncing on rough terrain", "झटकों में चलती मशीन से चाबी का अपने आप बाहर गिर जाना"),
                Bilingual("Burnt Terminal 50 internal spring contact causes intermittent starter failure", "टर्मिनल 50 की अंदरूनी पत्ती जलने से कभी-कभी सेल्फ न लेना")
            ),
            manualReference = "JCB Electrical Schematics Section C-2"
        ),
        SwitchSpec(
            id = "switch_hazard_warning",
            switchNameEn = "Hazard Warning Flasher Switch",
            switchNameHi = "हैजार्ड चेतावनी (चारों इंडिकेटर) रॉकर स्विच",
            switchNameAr = "مفتاح أضواء التحذير الرباعية (الفلشر)",
            location = Bilingual("Front instrument dashboard", "डैशबोर्ड के सामने"),
            switchType = "Double-Pole Double-Throw (DPDT) Latching Rocker Switch with Internal Red Pilot Lamp",
            terminalPinout = listOf(
                Bilingual("Pin 1: Constant +12V Battery Feed (Fuse F6)", "पिन 1: सीधा 12V बैटरी करंट (फ्यूज F6)"),
                Bilingual("Pin 2: Flasher Unit Input (+)", "पिन 2: इंडिकेटर फ्लैशर रिले इनपुट"),
                Bilingual("Pin 3: Left Indicator Lamps Line", "पिन 3: बाएं तरफ के दोनों इंडिकेटर"),
                Bilingual("Pin 4: Right Indicator Lamps Line", "पिन 4: दाहिने तरफ के दोनों इंडिकेटर"),
                Bilingual("Pin 5: Ground for Internal Indicator Bulb", "पिन 5: स्विच की लाल बत्ती का अर्थिंग तार")
            ),
            normalContinuityTruthTable = listOf(
                Bilingual("Hazard OFF: Left and Right lines isolated from each other and from battery", "हैजार्ड बंद: बाएं और दाएं इंडिकेटर अलग-अलग रहते हैं"),
                Bilingual("Hazard ON: All 4 turn lamps interconnected and receiving pulsing 12V from flasher relay", "हैजार्ड चालू: चारों इंडिकेटर आपस में जुड़कर एक साथ लपकते हैं")
            ),
            testingWithMultimeter = listOf(
                Bilingual("Check constant 12V at Pin 1 with test light even when ignition key is completely removed", "चाबी निकली होने पर भी पिन 1 पर 12 वोल्ट टेस्ट लैंप जलना चाहिए")
            ),
            commonFailureModes = listOf(
                Bilingual("Internal bridge contacts oxidized from dust causing only one side of machine to flash in hazard mode", "स्विच में धूल जमने से हैजार्ड लगाने पर केवल एक ही तरफ की बत्ती जलना")
            ),
            manualReference = "JCB Lighting Circuit Schematics Section C-5"
        )
    )

    // 8. BATTERY, STARTER & ALTERNATOR COMPREHENSIVE GUIDE
    val startingChargingData = StartingChargingOverview(
        batterySpecs = Bilingual(
            en = "12V 130Ah Heavy Commercial Lead-Acid / EFB Battery (Minimum 950 Cold Cranking Amps - CCA)",
            hi = "12 वोल्ट 130Ah हैवी कमर्शियल बैटरी (न्यूनतम 950 CCA कोल्ड क्रैंकिंग एम्पीयर)"
        ),
        isolatorSwitchProcedure = listOf(
            Bilingual("Turn isolator key 90° anti-clockwise and withdraw key before any welding or electrical work", "वेल्डिंग या तार का काम करने से पहले कट-ऑफ चाबी को 90 डिग्री घुमाकर निकाल लें"),
            Bilingual("Never disconnect isolator while engine is running; this causes alternator load-dump voltage spike (> 60V) that destroys instrument cluster and ECU", "चलते इंजन में कभी भी कट-ऑफ स्विच बंद न करें, इससे 60V का करंट बनकर मीटर और ईसीयू फूंक देता है")
        ),
        starterMotorSpecs = Bilingual(
            en = "JCB 12V 3.0kW / 4.2kW Pre-engaged Starter Motor with Reduction Gearbox and Integrated Solenoid",
            hi = "जेसीबी 12V 3.0kW से 4.2kW रिडक्शन गियर स्टार्टर मोटर विथ हैवी सोलेनोइड"
        ),
        alternatorSpecs = Bilingual(
            en = "JCB / Denso 12V 95 Amp High-Output Alternator with Internal Solid-State Electronic Voltage Regulator",
            hi = "जेसीबी / डेंसो 12V 95 एम्पीयर अल्टरनेटर विथ इंटरनल इलेक्ट्रॉनिक वोल्टेज रेगुलेटर"
        ),
        chargingVoltages = listOf(
            Bilingual("Resting Battery Voltage (Engine OFF): 12.6V = 100% Charged | 12.0V = Discharged (Must recharge)", "इंजन बंद पर बैटरी वोल्टेज: 12.6V = पूरी चार्ज | 12.0V = डिस्चार्ज"),
            Bilingual("Cranking Minimum Voltage: Must not drop below 9.8V while cranking starter for 5 seconds", "क्रैंकिंग के समय वोल्टेज: सेल्फ मारते समय 9.8V से नीचे नहीं गिरना चाहिए"),
            Bilingual("Engine Running Charging Voltage at 1500 RPM: 13.8V to 14.4V DC across battery posts", "1500 RPM पर चार्जिंग वोल्टेज: 13.8V से 14.4V के बीच होना अनिवार्य है")
        )
    )

    // 9. MULTIMETER TRAINING MASTERCLASS (PRACTICAL STEP-BY-STEP)
    val multimeterTutorials: List<MultimeterTutorial> = listOf(
        MultimeterTutorial(
            id = "multi_dc_voltage",
            titleEn = "DC Voltage Testing on Live Circuits (⎓ 20V)",
            titleHi = "डीसी वोल्टेज टेस्टिंग (⎓ 20V स्केल पर सप्लाई जांच)",
            titleAr = "فحص الجهد المستمر DC على الدوائر الحية (20V)",
            meterSetting = "DC Volts (⎓ 20V Scale)",
            redLeadPort = "V/Ω/mA Socket",
            blackLeadPort = "COM Socket",
            safetyFirstRule = Bilingual(
                en = "Never switch meter to Current (Amps) or Resistance (Ohms) when probing live voltage circuits; doing so causes a direct dead-short that blows meter internal fuse.",
                hi = "चालू करंट नापते समय मल्टीमीटर को कभी भी एम्पीयर या ओम पर न रखें, इससे मीटर के अंदर का फ्यूज तुरंत उड़ जाता है।"
            ),
            stepByStepTesting = listOf(
                Bilingual("Step 1: Plug Black lead into COM and Red lead into V/Ω port", "कदम 1: काला तार COM में और लाल तार V/Ω सॉकेट में लगाएं"),
                Bilingual("Step 2: Turn rotary dial to DC Volts 20V (or Auto-Range DCV)", "कदम 2: सेलेक्टर नॉब को 20V DC पर सेट करें"),
                Bilingual("Step 3: Firmly attach Black probe alligator clip to clean unpainted chassis metal or battery negative post", "कदम 3: काले तार को मशीन की साफ लोहे की बॉडी या बैटरी के माइनस (-) पर लगाएं"),
                Bilingual("Step 4: Probe the wire terminal or connector pin with the sharp Red probe tip", "कदम 4: लाल पिन को तार के सिरे या सॉकेट के पिन पर छुएं"),
                Bilingual("Step 5: Read digital display: 12.0V to 14.4V confirms healthy voltage supply", "कदम 5: स्क्रीन पर देखें: 12.0V से 14.4V दिखने का मतलब करंट सही आ रहा है")
            ),
            goodReadingInterpretation = Bilingual(
                en = "12.4V - 12.8V (Key OFF/ON) or 13.8V - 14.4V (Engine Running): Circuit has full electrical potential.",
                hi = "12.4V से 14.4V: सप्लाई पूरी तरह ठीक और मजबूत है।"
            ),
            badReadingInterpretation = Bilingual(
                en = "0.0V (Circuit open/blown fuse) or 4V - 8V (High-resistance corrosion drop in corroded connector).",
                hi = "0.0V = तार टूटा या फ्यूज उड़ा है; 4V से 8V = प्लग में जंग लगने से करंट कमजोर आ रहा है।"
            ),
            realJcbExample = Bilingual(
                en = "Testing Fuel Stop Solenoid on JCB 3DX: Turn key ON. Red probe to solenoid terminal, Black probe to engine head. Must read 12.2V+.",
                hi = "जेसीबी 3DX पर डीजल सोलेनोइड टेस्ट: चाबी ON करें। लाल पिन सोलेनोइड के तार पर, काली पिन इंजन पर लगाएं। कम से कम 12.2V दिखना चाहिए।"
            )
        ),
        MultimeterTutorial(
            id = "multi_continuity_beeper",
            titleEn = "Continuity & Broken Wire Testing (🔊 Beeper)",
            titleHi = "कंटिन्यूटी और टूटा तार जांचना (🔊 बीप मोड)",
            titleAr = "فحص الاستمرارية واكتشاف الأسلاك المقطوعة (وضع الجرس)",
            meterSetting = "Continuity / Diode Test Symbol (🔊 / ⯈|)",
            redLeadPort = "V/Ω/mA Socket",
            blackLeadPort = "COM Socket",
            safetyFirstRule = Bilingual(
                en = "ALWAYS DISCONNECT BATTERY ISOLATOR SWITCH BEFORE CONTINUITY TESTING. Probing a live wire in continuity mode will damage multimeter processor.",
                hi = "कंटिन्यूटी चेक करने से पहले बैटरी कट-ऑफ स्विच 100% बंद रखें। चालू तार पर बीप टेस्ट करने से मल्टीमीटर खराब हो जाएगा।"
            ),
            stepByStepTesting = listOf(
                Bilingual("Step 1: Set dial to audio continuity sound symbol (🔊)", "कदम 1: मीटर को बीप (साउंड) वाले निशान पर सेट करें"),
                Bilingual("Step 2: Touch the two metal probe tips together; the meter must emit a continuous loud BEEP sound and read < 0.2 Ω", "कदम 2: दोनों पिनों को आपस में छुएं; तेज बीप बजनी चाहिए और 0.0 से 0.2 ओम दिखना चाहिए"),
                Bilingual("Step 3: Connect one probe to wire start point and second probe to wire end point across the harness", "कदम 3: एक पिन तार के शुरू में और दूसरी पिन तार के दूसरे छोर पर लगाएं"),
                Bilingual("Step 4: Continuous BEEP = Wire is intact and unbroken from end to end", "कदम 4: लगातार बीप बजे = तार बिल्कुल सही और जुड़ा हुआ है"),
                Bilingual("Step 5: Silence and 'OL' (Over Limit) = Wire is snapped, broken or severed inside loom", "कदम 5: आवाज न आना और 'OL' दिखना = तार अंदर से कट या टूट चुका है")
            ),
            goodReadingInterpretation = Bilingual(
                en = "Loud beep and < 0.5 Ohms resistance: Perfect copper circuit integrity.",
                hi = "तेज बीप और 0.5 ओम से कम: तार अंदर से मजबूत है।"
            ),
            badReadingInterpretation = Bilingual(
                en = "No sound and display reads 'OL' or '> 200 Ω': Open circuit or broken copper strands.",
                hi = "कोई आवाज नहीं या 'OL' आना: तार अंदर से कट गया है।"
            ),
            realJcbExample = Bilingual(
                en = "Checking reverse light wire from cabin floor to rear mudguard: Disconnect both ends. Probe both tips. Loud beep confirms harness is not broken.",
                hi = "रिवर्स लाइट का तार चेक करना: दोनों तरफ का प्लग खोलें। दोनों छोर पर पिन लगाएं। बीप बजने पर तार सही है।"
            )
        ),
        MultimeterTutorial(
            id = "multi_ground_testing",
            titleEn = "Earth / Chassis Ground Quality Voltage Drop Test",
            titleHi = "अर्थिंग और ग्राउंडिंग की गुणवत्ता जांच (वोल्टेज ड्रॉप टेस्ट)",
            titleAr = "فحص جودة التأريض وهبوط الجهد على الشاسيه",
            meterSetting = "DC Millivolts / Volts (⎓ 200mV or 2V Scale)",
            redLeadPort = "V/Ω/mA Socket",
            blackLeadPort = "COM Socket",
            safetyFirstRule = Bilingual(
                en = "Performs on live energized circuit under full operational load.",
                hi = "यह टेस्ट लोड चालू रखकर (जैसे लाइट जलाकर या सेल्फ मारकर) किया जाता है।"
            ),
            stepByStepTesting = listOf(
                Bilingual("Step 1: Turn ON the consumer load (e.g. headlights ON or starter cranking)", "कदम 1: संबंधित लाइट या लोड को चालू करें"),
                Bilingual("Step 2: Touch Black probe directly to negative battery post lead lead metal", "कदम 2: काली पिन को बैटरी के माइनस (-) खूंटे पर लगाएं"),
                Bilingual("Step 3: Touch Red probe to the ground terminal of the lamp or starter casing", "कदम 3: लाल पिन को लाइट के अर्थिंग तार या स्टार्टर बॉडी पर लगाएं"),
                Bilingual("Step 4: Observe voltage reading: Should be less than 0.200 Volts (200 mV)", "कदम 4: मीटर में वोल्टेज देखें: 0.20V (200 मिलीवोल्ट) से कम होना चाहिए")
            ),
            goodReadingInterpretation = Bilingual(
                en = "< 0.2V: Excellent low-resistance earth bond.",
                hi = "0.2V से कम: बेहतरीन और पक्की अर्थिंग।"
            ),
            badReadingInterpretation = Bilingual(
                en = "> 0.5V up to 12V: Poor, rusted or loose grounding stud causing dim lights or slow cranking.",
                hi = "0.5V से ज्यादा: अर्थिंग में जंग या ढीलापन है जिससे लाइट धीमी जलती है या सेल्फ कमजोर घूमता है।"
            ),
            realJcbExample = Bilingual(
                en = "Diagnosing dim work lights on JCB cabin: Ground voltage drop was 3.4V due to rust on A-pillar bolt. Wire-brushing stud restored full 12.6V brightness.",
                hi = "धीमी लाइट की जांच: कैबिन बोल्ट पर जंग के कारण 3.4V का नुकसान हो रहा था। बोल्ट को साफ करके कसने पर पूरी तेज रोशनी लौट आई।"
            )
        )
    )

    // 10. CONNECTORS & PINOUT DATABASE
    val connectors: List<ConnectorPinout> = listOf(
        ConnectorPinout(
            connectorId = "C-ECU-60P",
            typeAndHousing = "Deutsch DRC26-60P Sealed Industrial 60-Pin Header",
            systemAndLoom = Bilingual("Engine Management ECU Harness Header", "इंजन ईसीयू मेन 60-पिन कनेक्टर"),
            matingPartNo = "Deutsch DRC26-60S-A004 / JCB 728/10200",
            pins = listOf(
                PinDetail("1", "Red/White", 0xFFD32F2F, "Main Unswitched Battery +12V Feed", "मेन अनस्विच्ड 12V बैटरी सप्लाई", "12.6V Constant", "12.4V - 12.8V", "تغذية البطارية الدائمة +12 فولت"),
                PinDetail("2", "Black", 0xFF141311, "Power Ground Return to Chassis", "पावर ग्राउंड रिटर्न (अर्थिंग)", "0.0V Ground", "< 0.05V", "رجوع التأريض الرئيسي إلى الشاسيه"),
                PinDetail("18", "Blue/Yellow", 0xFF1976D2, "5.0V Sensor Reference Power", "5 वोल्ट सेंसर सप्लाई", "5.0V Regulated", "4.95V - 5.05V", "تغذية مرجعية للحساسات 5 فولت"),
                PinDetail("24", "Brown/Green", 0xFF6D4C41, "Sensor Clean Analog Ground", "सेंसर क्लीन एनालॉग ग्राउंड", "0.0V Reference", "< 0.01V", "أرضي الحساسات التناظري النظيف"),
                PinDetail("31", "Yellow/Black", 0xFFFBC02D, "CAN-Bus High Line (J1939 Telematics)", "कैन-बस हाई लाइन (टेलीमैटिक्स)", "2.5V - 3.5V Pulsing", "60 Ω Bus Resistance", "خط اتصال CAN-Bus العالي (J1939)")
            ),
            probePrecaution = Bilingual(
                en = "NEVER force standard thick multimeter probe tips into small Deutsch micro-pins from front face; use approved back-probing needles to prevent spreading socket pins.",
                hi = "सामने से मोटा पिन कभी न ठूंसे; हमेशा तार के पीछे से बारीक सुई लगाकर ही वोल्टेज नापें ताकि सॉकेट का पिन न फैले।"
            )
        ),
        ConnectorPinout(
            connectorId = "C-TRANS-4P",
            typeAndHousing = "Deutsch DT04-4P Black 4-Pin Receptacle",
            systemAndLoom = Bilingual("Transmission Synchroshuttle Control Solenoids", "ट्रांसमिशन सिंक्रोशटल सोलेनोइड सॉकेट"),
            matingPartNo = "Deutsch DT06-4S-CE02",
            pins = listOf(
                PinDetail("1", "Yellow/Red", 0xFFFBC02D, "Forward Solenoid +12V Control", "फॉरवर्ड सोलेनोइड +12V", "12V in FWD", "12V when F selected", "تحكم صمام الحركة للأمام +12 فولت"),
                PinDetail("2", "Yellow/Green", 0xFFFBC02D, "Reverse Solenoid +12V Control", "रिवर्स सोलेनोइड +12V", "12V in REV", "12V when R selected", "تحكم صمام الحركة للخلف +12 فولت"),
                PinDetail("3", "Black", 0xFF141311, "Forward Solenoid Ground", "फॉरवर्ड सोलेनोइड अर्थिंग", "0.0V", "< 0.1V", "أرضي صمام الأمام"),
                PinDetail("4", "Black", 0xFF141311, "Reverse Solenoid Ground", "रिवर्स सोलेनोइड अर्थिंग", "0.0V", "< 0.1V", "أرضي صمام الخلف")
            ),
            probePrecaution = Bilingual(
                en = "Check rubber wedge lock is present inside connector to prevent moisture shorting pins.",
                hi = "सॉकेट के अंदर नारंगी रबड़ का लॉक जरूर लगा हो ताकि पानी से दोनों पिन आपस में शॉर्ट न हों।"
            )
        )
    )

    // Helper functions for search
    fun searchHarnesses(query: String): List<WiringHarnessModel> {
        val q = query.trim().lowercase()
        if (q.isEmpty()) return wiringHarnesses
        return wiringHarnesses.filter {
            it.harnessNameEn.lowercase().contains(q) ||
                    it.harnessNameHi.lowercase().contains(q) ||
                    it.harnessNameAr.lowercase().contains(q) ||
                    it.machineModels.any { m -> m.lowercase().contains(q) } ||
                    it.wires.any { w -> w.wireId.lowercase().contains(q) || w.colourCode.lowercase().contains(q) }
        }
    }

    fun searchLights(query: String): List<MachineLight> {
        val q = query.trim().lowercase()
        if (q.isEmpty()) return machineLights
        return machineLights.filter {
            it.nameEn.lowercase().contains(q) ||
                    it.nameHi.lowercase().contains(q) ||
                    it.nameAr.lowercase().contains(q) ||
                    it.fuseNumberAndRating.lowercase().contains(q) ||
                    it.positiveWireColour.lowercase().contains(q)
        }
    }

    fun searchSensors(query: String): List<ElectricalSensorSpec> {
        val q = query.trim().lowercase()
        if (q.isEmpty()) return sensors
        return sensors.filter {
            it.sensorNameEn.lowercase().contains(q) ||
                    it.sensorNameHi.lowercase().contains(q) ||
                    it.sensorNameAr.lowercase().contains(q) ||
                    it.applicableMachines.any { m -> m.lowercase().contains(q) }
        }
    }
}

data class StartingChargingOverview(
    val batterySpecs: Bilingual,
    val isolatorSwitchProcedure: List<Bilingual>,
    val starterMotorSpecs: Bilingual,
    val alternatorSpecs: Bilingual,
    val chargingVoltages: List<Bilingual>
)
