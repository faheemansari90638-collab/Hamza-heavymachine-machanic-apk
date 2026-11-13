package com.example.data

import com.example.R
import com.example.model.*

internal object JcbPartsGroupA {

    val parts: List<JcbPart> = listOf(
        // 1. ENGINE SYSTEM
        JcbPart(
            id = "part_engine_assembly",
            partNumber = "320/40500 (JCB Dieselmax 444) — Verify Engine Serial",
            system = SystemCategory.ENGINE,
            nameEn = "Engine (4-Cylinder Diesel Powerplant)",
            nameHi = "इंजन (4-सिलेंडर डीजल इंजन असेंबली)",
            nameAr = "المحرك",
            imageResId = R.drawable.img_part_engine,
            supportedModels = listOf("JCB 3CX", "JCB 4CX", "JCB 3DX", "JCB 5CX", "CAT Backhoe"),
            modelDifferences = listOf(
                Bilingual(
                    en = "JCB 3DX / 3CX Eco uses JCB 444 / EcoMAX 4.4L; older 3CX used Perkins 1004/1104; CAT 424B/428 uses Perkins/CAT C4.4.",
                    hi = "JCB 3DX / 3CX Eco में 4.4L EcoMAX इंजन, पुराने 3CX में Perkins 1004/1104 और CAT में CAT C4.4 इंजन होता है।",
                    ar = "تستخدم JCB 3DX و3CX محرك EcoMAX 4.4 لتر، بينما تستخدم الموديلات الأقدم Perkins 1104، وتستخدم CAT محرك CAT C4.4."
                )
            ),
            viewAngles = listOf(
                PartViewAngle(
                    Bilingual("Front Belt & Pulley Side", "फ्रंट बेल्ट व पुली साइड", "الواجهة الأمامية للسير والبكرات"),
                    Bilingual("Houses crank pulley, water pump, fan drive, and serpentine belt tensioner.", "यहाँ क्रैंक पुली, वॉटर पंप और फैन बेल्ट टेंशनर लगे होते हैं।", "تضم بكرة الكرنك ومضخة المياه وشداد السير.")
                ),
                PartViewAngle(
                    Bilingual("Left Injection & Filter Side", "बायां फ्यूल व फिल्टर साइड", "الجانب الأيسر للوقود والفلاتر"),
                    Bilingual("Contains fuel lift pump, spin-on oil filter, fuel filters, and starter motor.", "इस तरफ ऑयल फिल्टर, डीजल फिल्टर और स्टार्टर मोटर लगे होते हैं।", "يحتوي على فلتر الزيت وفلاتر الديزل والسلف.")
                )
            ),
            location = Bilingual(
                en = "Mounted inside the front engine bay chassis rails beneath the lockable tilt bonnet.",
                hi = "मशीन के अगले हिस्से में बोनट के नीचे मुख्य चेसिस फ्रेम पर माउंट होता है।",
                ar = "مثبت في الحجرة الأمامية على شاسيه الآلة أسفل غطاء المحرك الأمامي."
            ),
            workingPrinciple = Bilingual(
                en = "4-stroke compression-ignition diesel engine compressing intake air up to ~17:1 ratio before injecting atomized diesel at high pressure, converting thermal combustion energy into mechanical torque for the hydraulic pump and drivetrain.",
                hi = "4-स्ट्रोक डीजल इंजन जो हवा को दबाकर गर्म करता है और हाई प्रेशर डीजल स्प्रे करके पिस्टन को घुमाता है, जिससे हाइड्रोलिक पंप और गियरबॉक्स चलते हैं।",
                ar = "محرك ديزل رباعي الأشواط يضغط الهواء بنسبة عالية ثم يحقن الوقود تحت ضغط مرتفع لتحويل الطاقة الحرارية إلى عزم ميكانيكي يشغل المضخة الهيدروليكية وناقل الحركة."
            ),
            damageSymptoms = listOf(
                Bilingual("Excessive white, blue, or thick black exhaust smoke", "साइलेंसर से अत्यधिक सफेद, नीला या काला धुआं निकलना", "خروج دخان أبيض أو أزرق أو أسود كثيف من العادم"),
                Bilingual("Metallic knocking sound, low oil pressure warning, or overheating", "इंजन से भारी ठक-ठक की आवाज, ऑयल प्रेशर गिरना या ओवरहीटिंग", "صوت طرق معدني، انخفاض ضغط الزيت أو ارتفاع حرارة المحرك"),
                Bilingual("Excessive crankcase blow-by vapor from breather pipe", "ब्रीदर पाइप से ज्यादा धुआं या तेल फेंकना (बैक कंप्रेशन)", "خروج أبخرة وضغط زائد من أنبوب التبخير")
            ),
            inspectionProcedure = listOf(
                Bilingual("Check engine oil level, color (milky = coolant leak), and metal particles on drain magnet", "डिपस्टिक से तेल का स्तर और रंग जांचें (दूधिया रंग पानी मिलने का संकेत है)", "افحص مستوى الزيت ولونه (اللون الحليبي يدل على اختلاط الماء بالزيت)"),
                Bilingual("Perform cylinder compression pressure test (healthy diesel: typically 24–30 bar per cylinder; check OEM sheet)", "प्रत्येक सिलेंडर का कंप्रेशन टेस्ट करें (विवरण हेतु संबंधित इंजन मैन्युअल देखें)", "اختبر ضغط الانضغاط في كل أسطوانة ومطابقته لمواصفات الشركة المصنعة"),
                Bilingual("Inspect breather hose for blow-by and test cooling system for combustion gas bubbles", "ब्रीदर से बैक कंप्रेशन और रेडिएटर में बुलबुलों की जांच करें", "افحص خرطوم التبخير واختبر وجود فقاعات غاز في المبرد")
            ),
            repairInstructions = listOf(
                Bilingual("Always disconnect battery negative isolator before servicing engine electricals or starters", "इंजन पर काम करने से पहले बैटरी का नेगेटिव आइसोलेटर स्विच बंद करें", "افصل القطب السالب للبطارية دائماً قبل بدء أي صيانة كهربائية أو ميكانيكية"),
                Bilingual("Use calibrated torque wrenches on cylinder head, main caps, and flywheel bolts in sequence", "सिलेंडर हेड और मेन कैप बोल्ट हमेशा मैन्युअल टॉर्क क्रम के अनुसार ही कसें", "استخدم مفتاح عزم معاير لربط مسامير رأس الأسطوانة والمحامل الرئيسية بالتسلسل الصحيح"),
                Bilingual("Flush cooling and oil galleries completely before initial post-overhaul startup", "ओवरहाल के बाद स्टार्ट करने से पहले कूलिंग और ऑयल लाइन साफ करके नया ऑयल डालें", "اغسل مسارات التبريد والزيت بالكامل قبل التشغيل الأول بعد العمرة")
            ),
            safetyWarning = Bilingual(
                en = "DANGER: Keep clear of rotating fan blades and belts. Allow coolant and exhaust manifold to cool completely before opening.",
                hi = "सावधानी: चलते इंजन के पंखे और बेल्ट से दूर रहें। गर्म इंजन में कभी भी रेडिएटर ढक्कन न खोलें।",
                ar = "تحذير: ابتعد عن المروحة والسيور أثناء الدوران، ولا تفتح غطاء المبرد والمحرك ساخن."
            ),
            torqueSpec = "Varies by engine family (JCB 444 / Perkins / CAT) — verify OEM torque chart",
            diagramPoints = listOf(
                DiagramPoint(1, "Cylinder Head & Rocker Cover", "सिलेंडर हेड व रॉकर कवर", "Houses intake/exhaust valves and injectors", "वाल्व और इंजेक्टर रखने वाला ऊपरी भाग", "رأس الأسطوانة وغطاء الصمامات", "يحتوي على الصمامات والحاقنات"),
                DiagramPoint(2, "Engine Block & Pistons", "इंजन ब्लॉक व पिस्टन", "Cast-iron core housing 4 cylinders", "4 सिलेंडर वाला मुख्य लोहे का ब्लॉक", "جسم المحرك والأسطوانات", "كتلة حديدية تضم 4 أسطوانات"),
                DiagramPoint(3, "Oil Sump & Spin-on Filter", "ऑयल चैंबर व फिल्टर", "Stores engine oil and filters debris", "इंजन ऑयल जमा करने व छानने का भाग", "وعاء الزيت وفلتر الزيت", "يخزن زيت المحرك وينقيه من الشوائب"),
                DiagramPoint(4, "Flywheel Housing", "फ्लाईव्हील हाउसिंग", "Couples engine torque to transmission and pump", "इंजन की ताकत गियरबॉक्स तक भेजने वाला भाग", "غطاء الحدافة (الفلاي ويل)", "ينقل العزم من المحرك إلى ناقل الحركة")
            ),
            manualReference = "JCB Service Manual Section B (Engine Assembly & Overhaul)"
        ),

        JcbPart(
            id = "part_turbocharger",
            partNumber = "320/06076 / 02/203000 (Model Dependent)",
            system = SystemCategory.ENGINE,
            nameEn = "Turbocharger Assembly (Wastegate Type)",
            nameHi = "टर्बोचार्जर असेंबली (वेस्टगेट टाइप)",
            nameAr = "الشاحن التوربيني (تيربو)",
            imageResId = R.drawable.img_part_turbocharger,
            supportedModels = listOf("JCB 3CX", "JCB 4CX", "JCB 3DX Super/Xtra", "JCB 5CX", "CAT Backhoe"),
            modelDifferences = listOf(
                Bilingual(
                    en = "Naturally aspirated JCB 3DX (49HP) does NOT have a turbo; 3DX Super (74HP) & 3CX use wastegate turbo; 4CX/5CX (109-118HP) may use VGT.",
                    hi = "49HP 3DX में टर्बो नहीं होता; 74HP 3DX Super व 3CX में वेस्टगेट टर्बो और 4CX/5CX में VGT टर्बो लगता है।",
                    ar = "طراز 3DX بقوة 49 حصان لا يحتوي على تيربو، أما 3DX Super و3CX فتستخدم تيربو ببوابة عادم، و4CX/5CX قد تستخدم تيربو هندسة متغيرة."
                )
            ),
            viewAngles = listOf(
                PartViewAngle(
                    Bilingual("Exhaust Turbine Side", "एग्जॉस्ट टर्बाइन साइड", "جانب التوربين العادم"),
                    Bilingual("Cast-iron scroll bolted to exhaust manifold driving the shaft.", "गर्म गैस से घूमने वाला ढलवां लोहे का हिस्सा।", "غلاف حديد زهر متصل بمجمع العادم لتدوير العمود.")
                ),
                PartViewAngle(
                    Bilingual("Oil Feed & Drain Ports", "ऑयल इनलेट व रिटर्न पोर्ट", "منافذ دخول وخروج الزيت"),
                    Bilingual("Top banjo feeds pressurized oil; bottom wide flange drains to sump.", "ऊपर से प्रेशर ऑयल आता है और नीचे चौड़े पाइप से वापस जाता है।", "المنفذ العلوي لدخول الزيت المضغوط والسفلي لرجوعه للوعاء.")
                )
            ),
            location = Bilingual(
                en = "Bolted directly to the exhaust manifold on the right side of the engine block.",
                hi = "इंजन ब्लॉक के दाहिनी ओर एग्जॉस्ट मैनिफोल्ड के ऊपर कसा होता है।",
                ar = "مثبت مباشرة على مجمع العادم في الجانب الأيمن من كتلة المحرك."
            ),
            workingPrinciple = Bilingual(
                en = "Uses hot exhaust gas velocity to spin a turbine wheel and intake compressor impeller at high RPM, forcing dense compressed air into cylinders to increase power and combustion efficiency.",
                hi = "एग्जॉस्ट गैस के प्रेशर से टर्बाइन पहिए को तेज गति से घुमाता है, जो ठंडी हवा को दबाकर सिलेंडरों में भेजता है जिससे इंजन की ताकत बढ़ती है।",
                ar = "يستفيد من تدفق غازات العادم لتدوير التوربين والمروحة الضاغطة لضخ هواء مضغوط وكثيف داخل الأسطوانات لرفع القدرة والعزم."
            ),
            damageSymptoms = listOf(
                Bilingual("Excessive black exhaust smoke under heavy load", "भारी लोड पर अत्यधिक काला धुआं निकलना", "خروج دخان أسود كثيف تحت الحمل الثقيل"),
                Bilingual("High-pitched whistling or metallic scraping noise", "तेज सीटी या धातु रगड़ने की आवाज", "صوت صفير حاد أو احتكاك معدني"),
                Bilingual("Blue smoke and oil inside intercooler intake hoses", "साइलेंसर से नीला धुआं और इनटेक पाइप में तेल आना", "دخان أزرق وتسرب زيت داخل خراطيم السحب")
            ),
            inspectionProcedure = listOf(
                Bilingual("Remove intake hose and check compressor blades for nicks or contact with housing", "एयर इनटेक पाइप हटाकर पंखुड़ियों में कटाव या रगड़ जांचें", "افصل خرطوم السحب وافحص ريش الضاغط بحثاً عن تلف أو احتكاك"),
                Bilingual("Check shaft axial and radial play by hand (axial play must be minimal, zero blade rub)", "शाफ्ट को हाथ से हिलाकर प्ले चेक करें (पंखुड़ी बॉडी से न टकराए)", "افحص خلوص العمود المحوري والقطري يدوياً مع عدم تلامس الريش"),
                Bilingual("Inspect oil feed and drain lines for carbon blockages", "ऑयल सप्लाई और रिटर्न पाइप में कार्बन जाम चेक करें", "تأكد من عدم انسداد أنابيب تغذية وتصريف الزيت بالكربون")
            ),
            repairInstructions = listOf(
                Bilingual("Allow exhaust manifold to cool completely before removing mounting nuts", "इंजन ठंडा होने पर ही एग्जॉस्ट नट खोलें", "اترك مجمع العادم يبرد تماماً قبل فك صواميل التثبيت"),
                Bilingual("Always fit new genuine multilayer exhaust gaskets (never silicone sealant)", "हमेशा नया ओरिजिनल स्टील गैस्केट लगाएं, सिलिकॉन ट्यूब न लगाएं", "استبدل الجوانات دائماً بأخرى أصلية ولا تستخدم السيليكون مطلقاً"),
                Bilingual("Pre-lube turbo center bearing with clean engine oil before tightening oil feed pipe", "नया टर्बो लगाने से पहले ऑयल इनलेट में साफ इंजन ऑयल भरें", "املأ مدخل الزيت بزيت محرك نظيف لتشحيم المحامل قبل التشغيل الأول")
            ),
            safetyWarning = Bilingual(
                en = "WARNING: Turbo housing exceeds 600°C. Never shut down engine immediately from full load—idle for 2–3 minutes to cool bearings.",
                hi = "चेतावनी: गर्म टर्बो 600°C से अधिक गर्म होता है। काम के तुरंत बाद इंजन बंद न करें, 2-3 मिनट आइडल चलाएं।",
                ar = "تحذير: تتجاوز حرارة التيربو 600 درجة مئوية. اترك المحرك يعمل ببطء 2-3 دقائق قبل الإطفاء."
            ),
            torqueSpec = "Consult engine-specific OEM torque chart (Flange ~40–50 Nm)",
            diagramPoints = listOf(
                DiagramPoint(1, "Turbine Exhaust Housing", "एग्जॉस्ट टर्बाइन हाउसिंग", "Driven by hot exhaust gases", "गर्म गैस से चलने वाला भाग", "غلاف توربين العادم", "يدور بفعل غازات العادم الساخنة"),
                DiagramPoint(2, "Compressor Cold Housing", "कंप्रेसर कोल्ड हाउसिंग", "Compresses intake air to cylinders", "हवा दबाकर इंजन में भेजने वाला भाग", "غلاف ضاغط الهواء", "يضغط الهواء نحو الأسطوانات"),
                DiagramPoint(3, "Centre Bearing Housing", "सेंटर बेयरिंग हाउसिंग", "Oil-cooled high-speed shaft core", "ऑयल से ठंडा होने वाली बेयरिंग", "قلب المحامل المركزي", "يحتوي على عمود الدوران المبرد بالزيت"),
                DiagramPoint(4, "Wastegate Actuator", "वेस्टगेट एक्चुएटर", "Limits maximum boost pressure", "अधिकतम हवा दबाव नियंत्रक वाल्व", "منظم ضغط التيربو", "يتحكم بالضغط الأقصى للهواء")
            ),
            manualReference = "JCB Service Manual Section B (Turbocharged Engine Systems)"
        ),

        JcbPart(
            id = "part_crankshaft",
            partNumber = "320/03114 / 02/202400 (Verify Undersize)",
            system = SystemCategory.ENGINE,
            nameEn = "Forged Steel Crankshaft",
            nameHi = "इंजन क्रैंकशाफ्ट (मुख्य शाफ्ट)",
            nameAr = "عمود المرفق (الكرنك)",
            imageResId = R.drawable.img_part_crankshaft,
            supportedModels = listOf("JCB 3CX", "JCB 4CX", "JCB 3DX", "JCB 5CX", "CAT Backhoe"),
            modelDifferences = listOf(
                Bilingual(
                    en = "Journal diameters and gear-driven balancer shafts differ between JCB 444, Perkins 1104, and CAT C4.4 blocks.",
                    hi = "JCB 444, Perkins 1104 और CAT C4.4 इंजन में जर्नल साइज और बैलेंसर गियर अलग-अलग होते हैं।",
                    ar = "تختلف أقطار الكراسي وتروس الموازنة بين محركات JCB 444 وPerkins 1104 وCAT C4.4."
                )
            ),
            location = Bilingual(
                en = "Bottom crankcase bedplate of engine block supported by 5 main bearing caps.",
                hi = "इंजन ब्लॉक के सबसे निचले हिस्से में 5 मेन बेयरिंग कैप्स के अंदर लगा होता है।",
                ar = "في الجزء السفلي من كتلة المحرك مدعوماً بخمسة أغطية محامل رئيسية."
            ),
            workingPrinciple = Bilingual(
                en = "Converts linear up-and-down piston force via connecting rods into continuous rotational torque driving the flywheel, hydraulic pump, and transmission.",
                hi = "पिस्टन की ऊपर-नीचे की गति को घूमने की ताकत में बदलकर फ्लाईव्हील और पंप को घुमाता है।",
                ar = "يحول الحركة الترددية للمكابس عبر أذرع التوصيل إلى حركة دورانية مستمرة لتشغيل الحدافة وناقل الحركة."
            ),
            damageSymptoms = listOf(
                Bilingual("Deep metallic knocking from lower engine block under load", "इंजन के नीचे से भारी ठक-ठक की आवाज", "صوت طرق عميق من أسفل المحرك عند التحميل"),
                Bilingual("Low engine oil pressure warning lamp at hot idle", "इंजन गर्म होने पर ऑयल प्रेशर लाइट जलना", "إضاءة لمبة ضغط الزيت عند التسخين"),
                Bilingual("Scored journals or bearing metal shavings in oil sump", "चैंबर में पीतल या लोहे का बुरादा मिलना", "وجود برادة معدنية أو خدوش على الكراسي")
            ),
            inspectionProcedure = listOf(
                Bilingual("Measure main and big-end journals with outside micrometer for ovality/taper", "माइक्रोमीटर से जर्नल की गोलाई और घिसाव नापें", "قس أقطار كراسي المحور والذراع بالميكرومتر للتأكد من عدم التآكل أو البيضاوية"),
                Bilingual("Check shaft straightness (runout) on V-blocks with dial indicator", "डायल गेज से क्रैंक का सीधापन चेक करें", "افحص استقامة العمود على قوالب V باستخدام ساعة القياس"),
                Bilingual("Clean and probe internal cross-drilled oil passages", "क्रैंक के अंदर बने ऑयल सुराखों की सफाई चेक करें", "نظف قنوات الزيت الداخلية وتأكد من خلوها من الانسداد")
            ),
            repairInstructions = listOf(
                Bilingual("Regrind only to approved undersizes (-0.25mm / -0.50mm) per OEM manual", "केवल कंपनी अप्रूव्ड साइज (-0.25 / -0.50mm) पर ही ग्राइंड कराएं", "يُخرط العمود فقط بالمقاسات المعتمدة من المصنع (-0.25 / -0.50 مم)"),
                Bilingual("Match bearing shell oil holes and check end-float with thrust washers", "बेयरिंग के ऑयल सुराख मिलाकर लगाएं और थ्रस्ट वाशर से एंड-प्ले सेट करें", "طابق ثقوب الزيت في السبائك واضبط الخلوص الطولي بوردات الدفع"),
                Bilingual("Torque main caps in exact multi-stage sequence per engine manual", "मेन कैप बोल्ट को मैन्युअल के चरणों के अनुसार ही टॉर्क करें", "اربط أغطية المحامل الرئيسية على مراحل حسب دليل المحرك")
            ),
            safetyWarning = Bilingual(
                en = "WARNING: Crankshaft is heavy (~40–50 kg). Use hoist or two-person lift to avoid hand crush injury.",
                hi = "चेतावनी: क्रैंकशाफ्ट भारी (~45 किग्रा) होता है, इसे होइस्ट या दो लोगों की मदद से उठाएं।",
                ar = "تحذير: وزن عمود المرفق ثقيل (~45 كجم)؛ استخدم رافعة أو شخصين لتجنب الإصابات."
            ),
            torqueSpec = "Follow OEM 3-stage torque + angle spec per engine serial",
            diagramPoints = listOf(
                DiagramPoint(1, "Main Journals", "मेन जर्नल्स", "Supported in block main bearings", "ब्लॉक में टिकने वाले हिस्से", "كراسي التحميل الرئيسية", "ترتكز داخل محامل كتلة المحرك"),
                DiagramPoint(2, "Rod Journals (Crankpins)", "कनेक्टिंग रॉड जर्नल्स", "Offset pins driving piston rods", "पिस्टन रॉड जुड़ने वाले हिस्से", "كراسي أذرع التوصيل", "تتصل بأذرع المكابس"),
                DiagramPoint(3, "Counterweights", "काउंटर वेट्स", "Balances engine vibration", "कंपन संतुलित करने वाले वजन", "أثقال الموازنة", "تقلل الاهتزازات أثناء الدوران"),
                DiagramPoint(4, "Flywheel Flange", "फ्लाईव्हील फ्लैंज", "Drives flywheel and transmission", "पीछे फ्लाईव्हील कसने का हिस्सा", "شفة تثبيت الحدافة", "تثبت عليها الحدافة لنقل الحركة")
            ),
            manualReference = "JCB Engine Overhaul Manual Publication 9806/3000"
        ),

        // 2. HYDRAULIC SYSTEM
        JcbPart(
            id = "part_main_hydraulic_pump",
            partNumber = "20/925580 / 332/F9030 (Gear) / Piston Pump (4CX/5CX)",
            system = SystemCategory.HYDRAULIC,
            nameEn = "Hydraulic Pump",
            nameHi = "हाइड्रोलिक पंप",
            nameAr = "مضخة هيدروليكية",
            imageResId = R.drawable.img_part_hydraulic_pump,
            supportedModels = listOf("JCB 3CX", "JCB 4CX", "JCB 3DX", "JCB 5CX", "CAT Backhoe"),
            modelDifferences = listOf(
                Bilingual(
                    en = "JCB 3DX / standard 3CX uses dual-section Tandem Gear Pump; 4CX / 5CX / CAT variable-flow models use Load-Sensing Axial Piston Pump.",
                    hi = "JCB 3DX में ट्विन-सेक्शन गियर पंप होता है, जबकि 4CX, 5CX और कई CAT मॉडलों में वेरिएबल एक्सियल पिस्टन पंप होता है।",
                    ar = "تستخدم JCB 3DX و3CX القياسية مضخة تروس ثنائية، بينما تستخدم 4CX و5CX وبعض موديلات CAT مضخة مكبسية متغيرة الإزاحة."
                )
            ),
            viewAngles = listOf(
                PartViewAngle(
                    Bilingual("Drive Spline Front View", "ड्राइव स्प्लाइन फ्रंट व्यू", "المنظر الأمامي لعمود الإدارة"),
                    Bilingual("2-bolt/4-bolt SAE mounting flange with splined input shaft.", "पीटीओ गियरबॉक्स से जुड़ने वाला स्प्लाइन शाफ्ट और फ्लैंज।", "شفة التثبيت وعمود الإدارة المسنن المتصل بناقل الحركة.")
                ),
                PartViewAngle(
                    Bilingual("Side Suction & Pressure Ports", "साइड सक्शन व प्रेशर पोर्ट", "منافذ السحب والضغط الجانبية"),
                    Bilingual("Large suction flange draws from tank; twin outlets feed loader & backhoe valves.", "बड़ा पोर्ट टैंक से तेल खींचता है और दो छोटे पोर्ट वॉल्व में प्रेशर भेजते हैं।", "منفذ السحب الكبير من الخزان ومنافذ الضغط العالي إلى صمام التحكم.")
                )
            ),
            location = Bilingual(
                en = "Mounted onto the rear Power Take-Off (PTO) flange of the transmission behind the engine.",
                hi = "इंजन और गियरबॉक्स के पीछे पीटीओ (PTO) माउंटिंग पर लगा होता है।",
                ar = "مثبتة على مأخذ القدرة الخلفي (PTO) بناقل الحركة أسفل المقصورة."
            ),
            workingPrinciple = Bilingual(
                en = "Draws hydraulic fluid from the reservoir through a suction strainer and displaces it under high pressure (up to ~225–255 bar depending on model) to operate all loader, backhoe, and steering cylinders.",
                hi = "टैंक से हाइड्रोलिक तेल खींचकर भारी दबाव के साथ कंट्रोल वॉल्व ब्लॉक में भेजता है, जिससे लोडर, बूम, बकेट और स्टीयरिंग काम करते हैं।",
                ar = "تسحب الزيت الهيدروليكي من الخزان وتدفعه تحت ضغط مرتفع لتشغيل أذرع المحمل الأمامي والحفار الخلفي ونظام التوجيه."
            ),
            damageSymptoms = listOf(
                Bilingual("Slow hydraulic lift/digging cycle times especially when oil warms up", "तेल गर्म होने पर लोडर और बकेट बहुत धीमे उठना", "بطء حركة الأذرع والجرافة خاصة عند سخونة الزيت"),
                Bilingual("Loud cavitation whining or rattling from under cabin floor", "कैबिन के नीचे पंप से तेज सीटी या खड़खड़ाहट", "صوت صفير أو طقطقة عالية من المضخة أسفل المقصورة"),
                Bilingual("Foaming/aerated oil in tank sight glass and overheated pump body", "टैंक में झाग बनना और पंप बॉडी का अत्यधिक गर्म होना", "تكوّن رغوة في خزان الزيت وارتفاع حرارة جسم المضخة")
            ),
            inspectionProcedure = listOf(
                Bilingual("Connect 0–400 bar pressure gauge to main test port and verify MRV pressure at working temp", "टेस्ट पोर्ट पर 400 बार का प्रेशर गेज लगाकर मेन रिलीफ प्रेशर नापें", "وصّل ساعة فحص الضغط 0-400 بار بمنفذ الاختبار وقس الضغط عند حرارة التشغيل"),
                Bilingual("Inspect suction hose for collapse/air leak and suction strainer for brass filings", "सक्शन पाइप में हवा रिसाव और जाली में पीतल का बुरादा चेक करें", "افحص خرطوم السحب ومصفاة الخزان بحثاً عن برادة نحاسية أو تسرب هواء"),
                Bilingual("Check input shaft spline wear and drive coupling condition", "इनपुट शाफ्ट के दांतों (स्प्लाइन) का घिसाव जांचें", "افحص أسنان عمود الإدارة والوصلة الميكانيكية")
            ),
            repairInstructions = listOf(
                Bilingual("Drain tank, clean bottom sediment, and replace suction & return filters before installing new pump", "नया पंप लगाने से पहले टैंक साफ करें और सक्शन/रिटर्न फिल्टर बदलें", "أفرغ الخزان ونظفه واستبدل فلاتر السحب والرجوع قبل تركيب المضخة الجديدة"),
                Bilingual("Pre-fill pump chamber with clean hydraulic oil (ISO VG 46/68) to avoid dry start", "लगाने से पहले पंप के अंदर साफ हाइड्रोलिक ऑयल भरें", "املأ جسم المضخة بزيت هيدروليكي نظيف قبل التشغيل لتجنب الدوران الجاف"),
                Bilingual("Run engine at low idle for 5–10 minutes to purge trapped air before operating under load", "लोड देने से पहले 5-10 मिनट धीमी रेस पर हवा बाहर निकालें", "شغّل المحرك على السرعة الخاملة 5-10 دقائق لتفريغ الهواء المحبوس")
            ),
            safetyWarning = Bilingual(
                en = "DANGER: High-pressure hydraulic oil injection hazard! Never inspect for pinhole leaks with bare hands; always depressurize circuits before loosening fittings.",
                hi = "खतरा: हाई प्रेशर तेल का फव्वारा चमड़ी फाड़ सकता है! कभी हाथ से लीकेज न टटोलें और पाइप खोलने से पहले प्रेशर खत्म करें।",
                ar = "خطر: تدفق الزيت الهيدروليكي عالي الضغط قد يخترق الجلد! لا تتحسس التسربات باليد أبداً وفرّغ الضغط قبل الفك."
            ),
            torqueSpec = "Consult OEM spec for exact flange/port torques (~70–90 Nm mounting bolts)",
            diagramPoints = listOf(
                DiagramPoint(1, "Input Drive Spline Shaft", "इनपुट ड्राइव स्प्लाइन शाफ्ट", "Receives power from transmission PTO", "गियरबॉक्स से ताकत लेने वाला शाफ्ट", "عمود الإدارة المسنن", "يستقبل الحركة من مأخذ القدرة"),
                DiagramPoint(2, "Hardened Pumping Gears", "पंपिंग गियर सेट", "Displaces oil from inlet to outlet", "तेल को दबाकर आगे भेजने वाले गियर", "تروس الضخ المقساة", "تدفع الزيت من المدخل للمخرج"),
                DiagramPoint(3, "Bronze Thrust Plates", "ब्रास प्रेशर प्लेट्स", "Maintains side clearance sealing", "गियर के बगल से तेल लीक रोकने वाली प्लेट", "ألواح الدفع النحاسية", "تمنع التسرب الداخلي على جانبي التروس"),
                DiagramPoint(4, "Suction & Delivery Ports", "सक्शन व डिलीवरी पोर्ट", "Oil intake and pressurized exit ports", "तेल आने व जाने के मुख्य पोर्ट", "منافذ السحب والطرد", "منفذ دخول الزيت ومخرج الضغط العالي")
            ),
            manualReference = "JCB Service Manual Section E (Hydraulic Pumps & Relief Valves)"
        ),

        JcbPart(
            id = "part_control_valve_block",
            partNumber = "25/221200 / Model-Specific Spool Bank",
            system = SystemCategory.HYDRAULIC,
            nameEn = "Hydraulic Control Valve Block (Multi-Spool)",
            nameHi = "हाइड्रोलिक कंट्रोल वॉल्व ब्लॉक",
            nameAr = "صمام التحكم الهيدروليكي (الموزع)",
            imageResId = R.drawable.img_part_control_valve,
            supportedModels = listOf("JCB 3CX", "JCB 4CX", "JCB 3DX", "JCB 5CX", "CAT Backhoe"),
            modelDifferences = listOf(
                Bilingual(
                    en = "Manual lever mechanical valves on 3DX vs Pilot/Servo Joystick sectional valves on 4CX/5CX/Advanced 3CX.",
                    hi = "3DX में सीधे लीवर से चलने वाला वॉल्व ब्लॉक और 4CX/5CX में सर्वो जॉयस्टिक वॉल्व ब्लॉक होता है।",
                    ar = "تعمل صمامات 3DX بالعتلات الميكانيكية، بينما تعمل طرازات 4CX و5CX بصمامات تحكم مؤازرة (جويستك)."
                )
            ),
            location = Bilingual(
                en = "Mounted beneath the rear backhoe operator console (and front loader valve under cabin right floor).",
                hi = "पिछले बैकहो लीवरों के ठीक नीचे (तथा लोडर वॉल्व कैबिन के दाईं ओर नीचे) फिट होता है।",
                ar = "مثبت أسفل وحدة تحكم الحفار الخلفي (وموزع المحمل الأمامي أسفل أرضية المقصورة اليمنى)."
            ),
            workingPrinciple = Bilingual(
                en = "Precision-machined spools shift inside cast-iron bores to route pressurized oil to boom, dipper, bucket, or stabilizer rams while protecting circuits via Main & Auxiliary Relief Valves.",
                hi = "ऑपरेटर द्वारा लीवर चलाने पर अंदर के स्पूल खिसकते हैं और प्रेशर वाले तेल को चुने गए सिलेंडर में भेजते हैं।",
                ar = "تتحرك البكرات الدقيقة داخل جسم الصمام لتوجيه الزيت المضغوط إلى الأسطوانات المطلوبة مع حماية الدائرة بصمامات التنفيس."
            ),
            damageSymptoms = listOf(
                Bilingual("Boom or loader arms slowly sink/drift downward under load", "लीवर छोड़ने पर बूम या लोडर का अपने आप नीचे गिरना", "هبوط الأذرع تدريجياً تلقائياً عند ترك عصا التحكم"),
                Bilingual("Oil leaking externally from spool end caps and dust boots", "स्पूल के किनारों से बाहर तेल टपकना", "تسرب زيت خارجي من نهايات البكرات والأختام"),
                Bilingual("Sticking control levers failing to return smoothly to neutral", "कंट्रोल लीवर का अटकना या बीच में वापस न आना", "تصلب عتلات التحكم وعدم عودتها للوضع المحايد")
            ),
            inspectionProcedure = listOf(
                Bilingual("Wash valve bank clean and inspect spool O-rings for leaks while idling", "वॉल्व ब्लॉक साफ करके स्पूल सील से तेल रिसाव देखें", "نظف الموزع وافحص تسرب الزيت حول حلقات البكرات أثناء التشغيل"),
                Bilingual("Perform cylinder drift test over 10 minutes with bucket raised", "बकेट ऊपर उठाकर 10 मिनट में नीचे आने की दूरी नापें", "اختبر ثبات الأسطوانات لمدة 10 دقائق مع رفع الجرافة"),
                Bilingual("Remove and inspect Main Relief Valve (MRV) & ARV poppet seats for debris", "MRV और ARV वाल्व खोलकर स्प्रिंग व कचरा चेक करें", "افحص صمام التنفيس الرئيسي والفرعي للتأكد من سلامة النوابض ونظافة المقاعد")
            ),
            repairInstructions = listOf(
                Bilingual("Relieve all hydraulic pressure (engine OFF, cycle levers 10 times) and label every hose before removal", "इंजन बंद कर लीवर हिलाकर प्रेशर खत्म करें और हर पाइप पर नंबर लिखें", "فرّغ الضغط بالكامل بتحريك العتلات والمحرك مطفأ ورقّم كل خرطوم قبل الفك"),
                Bilingual("Never polish or sand spools; spools are factory-matched to their bore", "स्पूल पर कभी रेगमाल न घिसें; यह बॉडी से माइक्रोन फिटिंग में होते हैं", "لا تصنفر البكرات أبداً لأن خلوصها الدقيق متطابق مع جسم الصمام"),
                Bilingual("Install new spool O-ring seals & backup rings lubricated with clean oil", "साफ तेल लगाकर नई स्पूल सील किट व बैकअप रिंग लगाएं", "ركب طقم الحلقات المانعة للتسرب الجديد مع تشحيمه بزيت نظيف")
            ),
            safetyWarning = Bilingual(
                en = "CRITICAL: Lower front shovel and backhoe bucket fully onto ground before loosening any valve hose.",
                hi = "सावधानी: कोई भी पाइप खोलने से पहले लोडर और बकेट को जमीन पर टिका दें।",
                ar = "هام: أنزل الجرافة الأمامية والحفار على الأرض تماماً قبل فك أي خرطوم."
            ),
            torqueSpec = "Spool End Caps & ARV Cartridges: refer to valve OEM manual (~35–50 Nm)",
            diagramPoints = listOf(
                DiagramPoint(1, "Main Relief Valve (MRV)", "मेन रिलीफ वॉल्व", "Limits peak system pressure", "सिस्टम का अधिकतम प्रेशर सीमित रखने वाला वाल्व", "صمام التنفيس الرئيسي", "يحدد الضغط الأقصى للنظام"),
                DiagramPoint(2, "Precision Spools", "कंट्रोल स्पूल", "Direct oil flow port-to-port", "तेल का रास्ता बदलने वाले स्पूल", "البكرات المنزلقة", "توجه مسار الزيت لكل أسطوانة"),
                DiagramPoint(3, "Auxiliary Relief Valves (ARV)", "ऑक्जिलरी रिलीफ वॉल्व", "Cushions cylinder shock loads", "झटकों से सिलेंडर बचाने वाले वाल्व", "صمامات الأمان الفرعية", "تحمي الأسطوانات من الصدمات"),
                DiagramPoint(4, "Tank Return Gallery", "टैंक रिटर्न गैलरी", "Routes exhaust oil back to filter", "वापसी तेल टैंक तक भेजने का मार्ग", "مجرى الراجع للخزان", "يعيد الزيت المستخدم إلى الفلتر والخزان")
            ),
            manualReference = "JCB Workshop Manual Section E-3 (Hydraulic Control Valves)"
        ),

        JcbPart(
            id = "part_boom_ram",
            partNumber = "556/43400 / Cylinder Diameter Varies by Model",
            system = SystemCategory.HYDRAULIC,
            nameEn = "Hydraulic Cylinder (Boom / Dipper / Loader Ram)",
            nameHi = "हाइड्रोलिक सिलेंडर (रैम)",
            nameAr = "الأسطوانة الهيدروليكية (بستم)",
            imageResId = R.drawable.img_part_hydraulic_ram,
            supportedModels = listOf("JCB 3CX", "JCB 4CX", "JCB 3DX", "JCB 5CX", "CAT Backhoe"),
            modelDifferences = listOf(
                Bilingual(
                    en = "Bore/rod diameters and gland nut designs (threaded collar vs bolted flange) vary across 3DX, 3CX, 4CX, 5CX, and CAT machines.",
                    hi = "3DX, 3CX, 4CX, 5CX और CAT में सिलेंडर बोर साइज व ग्लैंड नट डिजाइन (थ्रेडेड vs बोल्टेड) अलग होते हैं।",
                    ar = "تختلف أقطار الأسطوانة والذراع وطريقة تثبيت الغطاء (سن لولبي أو مسامير) حسب طراز الآلة."
                )
            ),
            location = Bilingual(
                en = "Mounted externally on loader arms, backhoe boom, dipper, bucket linkage, and stabilizer legs.",
                hi = "लोडर आर्म, बूम, डिपर, बकेट और स्टेबलाइजर लेग्स पर पिनों के सहारे लगा होता है।",
                ar = "مثبتة خارجياً على أذرع المحمل الأمامي وذراع الحفار والجرافة وأرجل التثبيت."
            ),
            workingPrinciple = Bilingual(
                en = "Double-acting hydraulic actuator where pressurized fluid pushes against either side of the internal piston seal to extend or retract the hard-chrome steel rod with multi-ton force.",
                hi = "डबल-एक्टिंग सिलेंडर जिसमें पिस्टन के एक तरफ तेल भरने से क्रोम रॉड बाहर निकलती है और दूसरी तरफ तेल जाने से अंदर आती है।",
                ar = "مشغل هيدروليكي ثنائي الفعل يدفع المكبس للخارج أو الداخل عبر ضغط الزيت لتحريك الذراع الكرومي بقوة عالية."
            ),
            damageSymptoms = listOf(
                Bilingual("Oil dripping or spraying past the rod wiper and gland seal", "सिलेंडर के मुंह (ग्लैंड नट) से तेल बहना", "تسرب الزيت حول ذراع الأسطوانة وغطاء السد"),
                Bilingual("Internal piston seal leak causing cylinder drift under load", "अंदरूनी पिस्टन सील कटने से बूम का अपने आप नीचे खिसकना", "انخفاض الذراع تلقائياً بسبب تلف سدادات المكبس الداخلية"),
                Bilingual("Scratched, pitted chrome rod or bent shaft from rock impacts", "क्रोम रॉड पर गहरी खरोंच या रॉड का मुड़ जाना", "خدوش على الذراع الكرومي أو اعوجاجه بسبب الصدمات")
            ),
            inspectionProcedure = listOf(
                Bilingual("Extend rod fully and inspect chrome plating for gouges or rust pits", "रॉड पूरी खोलकर क्रोम पॉलिश पर खरोंच या गड्ढे चेक करें", "افتح الذراع بالكامل وافحص طبقة الكروم بحثاً عن خدوش أو صدأ"),
                Bilingual("Check rod straightness and pivot bush clearances at both eyes", "रॉड का सीधापन और पिन-बुश का प्ले चेक करें", "تأكد من استقامة الذراع وخلوص البطانات والبنوز"),
                Bilingual("Inspect inside cylinder barrel for longitudinal scoring during disassembly", "खोलने पर सिलेंडर ट्यूब के अंदर की सतह में खरोंच जांचें", "افحص الجدار الداخلي للأسطوانة للتأكد من نعومته وخلوه من الخدوش")
            ),
            repairInstructions = listOf(
                Bilingual("Secure ram in bench vise and unscrew gland nut using correct C-spanner/pin wrench", "बेंच पर बांधकर सही ग्लैंड रिंच से ग्लैंड नट खोलें", "ثبّت الأسطوانة وفك الصامولة الحلقية بمفتاح السحب المخصص"),
                Bilingual("Replace full matched seal kit (piston seal, rod seal, wear rings, wiper, O-rings)", "हमेशा पूरी सील किट (पिस्टन सील, रॉड सील, वियर रिंग, वाइपर) बदलें", "استبدل طقم موانع التسرب بالكامل (سداد المكبس والذراع وحلقات التوجيه والكاشطة)"),
                Bilingual("Verify piston nut lock mechanism/threadlocker and bleed air gently on reinstallation", "पिस्टन नट को लॉक व टॉर्क करके फिट करने के बाद धीरे-धीरे हवा निकालें", "تأكد من تثبيت صامولة المكبس وفرّغ الهواء برفق بعد التركيب")
            ),
            safetyWarning = Bilingual(
                en = "DANGER: Support heavy boom/loader arms on safety struts before knocking out cylinder pivot pins.",
                hi = "खतरा: पिन निकालने से पहले बूम या लोडर को स्टैंड व सेफ्टी लॉक से सुरक्षित सहारा दें।",
                ar = "خطر: ادعم الأذرع الثقيلة بقوائم أمان ميكانيكية قبل طرق بنوز الأسطوانة."
            ),
            torqueSpec = "Piston nut & gland nut torque varies widely by ram bore size — check OEM manual",
            diagramPoints = listOf(
                DiagramPoint(1, "Hard-Chrome Steel Rod", "हार्ड क्रोम रॉड", "High-strength chrome-plated piston shaft", "मजबूत क्रोम चढ़ा स्टील शाफ्ट", "الذراع الكرومي المقسى", "عمود فولاذي مطلي بالكروم لمقاومة التآكل"),
                DiagramPoint(2, "Honed Cylinder Barrel", "पॉलिश बैरल ट्यूब", "Seamless steel tube housing piston", "अंदर से चिकनी पॉलिश नली", "جسم الأسطوانة المصقول", "أنبوب فولاذي أملس من الداخل"),
                DiagramPoint(3, "Gland Nut & Rod Wiper", "ग्लैंड नट व वाइपर सील", "Cleans dirt off rod & retains high pressure", "धूल रोकने और प्रेशर सील रखने वाला भाग", "صامولة السد والمانع", "تنظف الذراع من الأتربة وتمنع تسرب الزيت"),
                DiagramPoint(4, "Piston Head & Seal Ring", "पिस्टन हेड व सील रिंग", "Separates extend & retract chambers", "दोनों तरफ प्रेशर बांटने वाला पिस्टन", "رأس المكبس وحلقة السد", "يفصل غرفتي التمدد والانكماش")
            ),
            manualReference = "JCB Hydraulic Cylinder Overhaul Manual Section E-4"
        ),

        // 3. ELECTRICAL SYSTEM
        JcbPart(
            id = "part_starter_motor",
            partNumber = "714/40159 / 320/09022 (12V 3.0–4.2kW Reduction)",
            system = SystemCategory.ELECTRICAL,
            nameEn = "Starter Motor",
            nameHi = "स्टार्टर मोटर (सेल्फ)",
            nameAr = "محرك بادئ التشغيل",
            imageResId = R.drawable.img_part_starter_motor,
            supportedModels = listOf("JCB 3CX", "JCB 4CX", "JCB 3DX", "JCB 5CX", "CAT Backhoe"),
            modelDifferences = listOf(
                Bilingual(
                    en = "Pinion tooth count (e.g. 10T vs 11T) and nose cone bolt pattern (3-bolt vs 2-bolt) differ between JCB 444, Perkins, and CAT engines.",
                    hi = "JCB 444, Perkins और CAT इंजन में पिनियन दांतों (10T/11T) और बोल्ट पैटर्न का अंतर होता है।",
                    ar = "يختلف عدد أسنان الترس (10 أو 11 سناً) وتوزيع مسامير التثبيت بين محركات JCB وPerkins وCAT."
                )
            ),
            viewAngles = listOf(
                PartViewAngle(
                    Bilingual("Pinion Drive Gear End", "पिनियन गियर सिरा", "جهة ترس التعشيق"),
                    Bilingual("Engages engine flywheel ring gear when solenoid energizes.", "सेल्फ मारने पर फ्लाईव्हील के दांतों से जुड़ता है।", "يتعشق مع ترس الحدافة عند تدوير المفتاح.")
                ),
                PartViewAngle(
                    Bilingual("Solenoid Terminal Side", "सोलेनोइड टर्मिनल साइड", "جهة ملف السلف والتوصيلات"),
                    Bilingual("Thick B+ battery stud (M8/M10) and small Terminal 50 trigger spade/stud.", "मोटी बैटरी + केबल स्टड और पतला 50 नंबर स्टार्ट स्विच तार।", "مسمار البطارية الرئيسي B+ والطرف الصغير لإشارة التشغيل من السويتش.")
                )
            ),
            location = Bilingual(
                en = "Bolted to the left/right flywheel housing beside the rear of the engine block.",
                hi = "इंजन ब्लॉक के निचले पिछले हिस्से में फ्लाईव्हील हाउसिंग पर लगा होता है।",
                ar = "مثبت على غطاء الحدافة بجانب الجزء الخلفي من كتلة المحرك."
            ),
            workingPrinciple = Bilingual(
                en = "12V high-current DC electric motor with piggyback solenoid relay. Ignition key energizes the solenoid coil to slide the pinion gear into the flywheel ring gear and simultaneously bridge heavy battery contacts to crank the diesel engine.",
                hi = "चाबी घुमाने पर सोलेनोइड स्विच पिनियन को फ्लाईव्हील में फंसाता है और बैटरी के भारी करंट से मोटर तेज घूमकर इंजन स्टार्ट करती है।",
                ar = "عند تشغيل المفتاح، يدفع الملف اللولبي ترس البندكس للتعشيق مع الحدافة ويوصل تيار البطارية العالي لتدوير المحرك."
            ),
            damageSymptoms = listOf(
                Bilingual("Single loud 'CLICK' without engine cranking", "चाबी घुमाने पर केवल 'कट' की आवाज आना, इंजन न घूमना", "سماع صوت طقة واحدة دون دوران المحرك"),
                Bilingual("Sluggish, slow cranking speed even with a fully charged battery", "पूरी चार्ज बैटरी होने पर भी सेल्फ का धीमा घूमना", "بطء دوران السلف رغم سلامة البطارية وشحنها"),
                Bilingual("Grinding screech when pinion fails to mesh with flywheel teeth", "सेल्फ मारते समय दांत घिसने की तेज आवाज आना", "صوت احتكاك وصرير بسبب عدم تعشيق الترس مع الحدافة")
            ),
            inspectionProcedure = listOf(
                Bilingual("Measure voltage drop on main positive cable and engine ground strap while cranking", "क्रैंकिंग के दौरान बैटरी केबल और अर्थिंग पर वोल्टेज ड्रॉप नापें", "قس هبوط الجهد على كابل البطارية الموجب والسالب الأرضي أثناء التشغيل"),
                Bilingual("Check Terminal 50 trigger wire receives full 12V when key turned to START in neutral", "न्यूट्रल में चाबी घुमाने पर पतले तार (Terminal 50) पर 12V चेक करें", "تأكد من وصول 12 فولت لطرف الإشارة (50) عند تدوير المفتاح على الوضع المحايد"),
                Bilingual("Bench-inspect carbon brushes, commutator wear, and solenoid copper contacts", "बेंच पर खोलकर कार्बन ब्रश, आर्मेचर और सोलेनोइड कॉन्टैक्ट चेक करें", "افحص الفحمات (الفرش الكربونية) والملف اللولبي على طاولة الفحص")
            ),
            repairInstructions = listOf(
                Bilingual("DISCONNECT battery isolator / negative clamp FIRST before loosening starter positive cable", "सेल्फ का कोई भी तार खोलने से पहले बैटरी आइसोलेटर जरूर बंद करें", "افصل البطارية أولاً قبل لمس كابلات محرك بادئ التشغيل"),
                Bilingual("Inspect flywheel ring gear teeth through starter opening before fitting new unit", "नया सेल्फ लगाने से पहले फ्लाईव्हील के दांतों की हालत जरूर देखें", "افحص أسنان ترس الحدافة من فتحة السلف قبل تركيب الوحدة الجديدة"),
                Bilingual("Clean starter mounting flange face to ensure clean metal-to-metal ground return", "सेल्फ और हाउसिंग की सतह साफ करके लगाएं ताकि सही अर्थिंग मिले", "نظف سطح التثبيت لضمان توصيل أرضي ممتاز عبر جسم المحرك")
            ),
            safetyWarning = Bilingual(
                en = "DANGER: Never jump-start across starter solenoid terminals with a screwdriver while machine is in gear—machine can lurch and crush you!",
                hi = "खतरा: कभी भी पेचकस से सेल्फ डायरेक्ट न करें! यदि गियर डला होगा तो मशीन तुरंत चलकर कुचल सकती है।",
                ar = "خطر: لا تقم أبداً بتوصيل أطراف السلف مباشرة بمفك أثناء وجود الآلة في تعشيق الحركة لتفادي انطلاق الآلة فجأة!"
            ),
            torqueSpec = "Mounting Bolts: ~45–60 Nm | Main B+ Nut: ~15 Nm (avoid twisting copper stud)",
            diagramPoints = listOf(
                DiagramPoint(1, "Starter Solenoid Switch", "सेल्फ सोलेनोइड स्विच", "Pushes pinion and bridges 12V load", "पिनियन आगे धकेलने व करंट जोड़ने वाला स्विच", "المفتاح اللولبي (أوتوماتيك السلف)", "يدفع الترس ويوصل التيار الرئيسي"),
                DiagramPoint(2, "Bendix Pinion & Clutch", "बेंडिक्स पिनियन गियर", "Overrunning clutch engages flywheel", "फ्लाईव्हील घुमाने वाला वन-वे गियर", "ترس البندكس والقابض", "يتعشق مع الحدافة ويفصل بعد الدوران"),
                DiagramPoint(3, "Planetary Reduction Gearset", "प्लेनेटरी रिडक्शन गियर", "Multiplies cranking torque", "कम करंट में अधिक घुमाव ताकत देने वाला गियर", "مجموعة التروس الكوكبية", "تضاعف عزم التدوير للمحركات الثقيلة"),
                DiagramPoint(4, "Field Winding & Armature", "आर्मेचर व कार्बन ब्रश", "High-torque DC electric motor core", "मुख्य मोटर कॉइल और कार्बन ब्रश", "العضو الدوار والفرش", "قلب المحرك الكهربائي عالي العزم")
            ),
            manualReference = "JCB Electrical Service Manual Section C (Starting Circuit)"
        ),

        JcbPart(
            id = "part_alternator",
            partNumber = "714/40152 / 320/08560 (12V 95A–120A)",
            system = SystemCategory.ELECTRICAL,
            nameEn = "Alternator",
            nameHi = "अल्टरनेटर",
            nameAr = "المولد الكهربائي",
            imageResId = R.drawable.img_part_alternator,
            supportedModels = listOf("JCB 3CX", "JCB 4CX", "JCB 3DX", "JCB 5CX", "CAT Backhoe"),
            modelDifferences = listOf(
                Bilingual(
                    en = "Amperage output (65A/85A on older 3DX vs 95A–120A on A/C cab 3CX/4CX) and W-terminal tachometer signal differ by machine spec.",
                    hi = "पुराने 3DX में 65A-85A और एसी कैबिन वाले 3CX/4CX में 95A-120A अल्टरनेटर व टैकोमीटर W-टर्मिनल होता है।",
                    ar = "تختلف شدة التيار (65-85 أمبير في 3DX مقابل 95-120 أمبير في المقصورات المكيفة) ومخرج إشارة عداد RPM."
                )
            ),
            viewAngles = listOf(
                PartViewAngle(
                    Bilingual("Poly-V Belt Pulley Front", "आगे का पुली सिरा", "واجهة البكرة الأمامية"),
                    Bilingual("Multi-ribbed or V-belt pulley driven by engine crankshaft.", "इंजन बेल्ट से घूमने वाली पुली।", "البكرة التي يديرها سير المحرك.")
                ),
                PartViewAngle(
                    Bilingual("Rear B+ / D+ / W Terminals", "पीछे B+, D+ और W टर्मिनल", "الأطراف الخلفية B+ وD+ وW"),
                    Bilingual("B+ charges battery; D+ excites coil via dash lamp; W feeds RPM gauge.", "B+ बैटरी चार्ज करता है, D+ डैशबोर्ड बत्ती से जुड़ा है और W आरपीएम बताता है।", "B+ للشحن، D+ للمبة التحذير والإثارة، وW لإشارة عداد الدوران.")
                )
            ),
            location = Bilingual(
                en = "Mounted on an adjustable tension bracket at the front-top of the engine driven by the fan belt.",
                hi = "इंजन के अगले हिस्से में फैन बेल्ट के साथ एडजस्टेबल ब्रैकेट पर लगा होता है।",
                ar = "مثبت في مقدمة المحرك على حامل شداد ويُدار بواسطة سير المروحة."
            ),
            workingPrinciple = Bilingual(
                en = "Generates 3-phase AC electricity via a rotating electromagnetic rotor inside stationary stator windings, then rectifies it through internal silicon diodes into regulated 13.8V–14.4V DC to recharge the battery and power machine electronics.",
                hi = "इंजन बेल्ट से घूमकर चुंबकीय क्षेत्र द्वारा बिजली बनाता है और डायोड रेक्टिफायर की मदद से 13.8V-14.4V डीसी वोल्टेज में बदलकर बैटरी चार्ज करता है।",
                ar = "يولد تياراً متردداً ثلاثي الطور ويحوله عبر مجموعة الدايودات ومنظم الجهد إلى تيار مستمر منتظم (13.8-14.4 فولت) لشحن البطارية."
            ),
            damageSymptoms = listOf(
                Bilingual("Red battery warning light remains glowing on dashboard while engine runs", "इंजन चालू रहने पर भी डैशबोर्ड पर लाल बैटरी बत्ती जलते रहना", "استمرار إضاءة لمبة البطارية الحمراء أثناء عمل المحرك"),
                Bilingual("RPM tachometer needle drops to zero (loss of W-terminal AC pulse)", "आरपीएम मीटर की सुई का शून्य पर गिर जाना", "توقف عداد دورات المحرك RPM عن العمل"),
                Bilingual("Repeatedly discharged battery or whining bearing roar", "बैटरी बार-बार डाउन होना या बेयरिंग से तेज आवाज आना", "تفريغ البطارية المتكرر أو صدور صوت ضجيج من الرولمان بلي")
            ),
            inspectionProcedure = listOf(
                Bilingual("Check poly-V belt tension and alignment first (loose belt drops voltage under load)", "सबसे पहले फैन बेल्ट का तनाव व घिसाव जांचें", "افحص شد السير وسلامته أولاً لأن ارتخاءه يمنع الشحن الصحيح"),
                Bilingual("Measure DC voltage across battery terminals at 1500 RPM (healthy charging: 13.8V–14.4V)", "1500 RPM पर बैटरी पर वोल्टेज नापें (13.8 से 14.4 वोल्ट होना चाहिए)", "قس الجهد على أقطاب البطارية عند 1500 دورة/دقيقة (يجب أن يكون 13.8-14.4 فولت)"),
                Bilingual("Switch multimeter to AC Volts across battery to detect faulty rectifier diodes (< 0.2V AC normal)", "डायोड खराबी पकड़ने के लिए बैटरी पर AC वोल्ट चेक करें (< 0.2V होना चाहिए)", "افحص التموج المتردد AC على البطارية للتأكد من سلامة الدايودات (أقل من 0.2 فولت)")
            ),
            repairInstructions = listOf(
                Bilingual("Always disconnect battery negative terminal before removing B+ lead on alternator", "अल्टरनेटर का तार खोलने से पहले बैटरी नेगेटिव टर्मिनल हटा दें", "افصل القطب السالب للبطارية قبل فك سلك B+ من الدينامو"),
                Bilingual("Never disconnect battery cables while engine is running—voltage spike destroys ECU & regulator", "इंजन चालू हालत में कभी भी बैटरी का खूंटा न हटाएं; ईसीयू उड़ सकता है", "لا تفصل البطارية أبداً والمحرك يدور لتجنب تلف وحدة التحكم ومنظم الجهد"),
                Bilingual("Inspect D+ warning bulb circuit; if open, alternator may fail to self-excite at low RPM", "डैशबोर्ड बैटरी बत्ती व पतले D+ तार का करंट जांचें", "تحقق من سلامة دائرة لمبة التحذير D+ المسؤولة عن الإثارة الأولية")
            ),
            safetyWarning = Bilingual(
                en = "WARNING: B+ stud is permanently live at 12V! Shorting with a wrench causes severe arc burns or battery explosion.",
                hi = "चेतावनी: B+ टर्मिनल पर हमेशा 12V रहता है! पाना टकराने से भारी स्पार्क और आग लग सकती है।",
                ar = "تحذير: طرف B+ موصل دائماً بموجب البطارية؛ ملامسته بالمفاتيح المعدنية يسبب شراراً وحريقاً."
            ),
            torqueSpec = "Belt Tension & Pivot Bolts: check model spec | B+ M6/M8 Nut: ~8–12 Nm",
            diagramPoints = listOf(
                DiagramPoint(1, "Multi-Ribbed Drive Pulley", "ड्राइव बेल्ट पुली", "Driven by engine crankshaft belt", "इंजन बेल्ट से घूमने वाली पुली", "بكرة الإدارة", "تستقبل الحركة من سير المحرك"),
                DiagramPoint(2, "Rotor & Stator Coils", "रोटर व स्टेटर कॉइल", "Generates 3-phase charging current", "बिजली पैदा करने वाली तांबे की वाइंडिंग", "العضو الدوار والملف الثابت", "تولد التيار الكهربائي ثلاثي الطور"),
                DiagramPoint(3, "Internal Voltage Regulator", "वोल्टेज रेगुलेटर व ब्रश", "Caps voltage at ~14.2V", "वोल्टेज को 14.2V पर नियंत्रित करने वाला भाग", "منظم الجهد الداخلي", "يثبت جهد الشحن عند حدود 14.2 فولت"),
                DiagramPoint(4, "B+ / D+ / W Rear Terminals", "पिछले कनेक्शन टर्मिनल", "Battery output, dash exciter, RPM pulse", "चार्जिंग, लाइट और आरपीएम टर्मिनल", "أطراف التوصيل الخلفية", "مخرج الشحن ولمبة الطبلون وإشارة RPM")
            ),
            manualReference = "JCB Electrical & Charging Manual Section C-2"
        ),

        JcbPart(
            id = "part_battery",
            partNumber = "12V 110Ah–130Ah (850–950 CCA Heavy Commercial)",
            system = SystemCategory.ELECTRICAL,
            nameEn = "Battery",
            nameHi = "बैटरी",
            nameAr = "البطارية",
            imageResId = R.drawable.img_part_battery,
            supportedModels = listOf("JCB 3CX", "JCB 4CX", "JCB 3DX", "JCB 5CX", "CAT Backhoe"),
            modelDifferences = listOf(
                Bilingual(
                    en = "Standard 3DX uses 1x 12V 110–130Ah battery; cold-climate 4CX/5CX or 24V heavy CAT excavators may run dual batteries.",
                    hi = "3DX में एक 12V 110-130Ah बैटरी लगती है; ठंडे इलाकों के 4CX/5CX या कुछ 24V मशीनों में डबल बैटरी होती है।",
                    ar = "تستخدم 3DX بطارية واحدة 12 فولت 110-130 أمبير، بينما قد تستخدم 4CX و5CX أو أنظمة 24 فولت بطاريتين."
                )
            ),
            viewAngles = listOf(
                PartViewAngle(
                    Bilingual("Top Post Terminals", "ऊपरी पॉजिटिव व नेगेटिव खूंटे", "الأقطاب العلوية الموجب والسالب"),
                    Bilingual("Heavy SAE tapered lead posts (+ Red / - Black) with clamp bolts.", "मोटे लेड टर्मिनल (+ लाल और - काला) जिन पर मुख्य केबल कसते हैं।", "أقطاب رصاصية سميكة (+ أحمر / - أسود) لتوصيل كابلات السلف والشاسيه.")
                )
            ),
            location = Bilingual(
                en = "Housed inside a lockable steel battery box mounted beneath the cabin step or under front bonnet.",
                hi = "कैबिन के सीढ़ी बॉक्स (स्टेप बॉक्स) के अंदर या बोनट के पास लॉक वाले लोहे के बक्से में रखी होती है।",
                ar = "داخل صندوق بطارية فولاذي محكم الإغلاق أسفل سلم المقصورة أو تحت الغطاء الأمامي."
            ),
            workingPrinciple = Bilingual(
                en = "Lead-acid electrochemical energy storage delivering 850+ Cold Cranking Amps (CCA) to crank high-compression diesel engines while stabilizing system voltage for the ECU and sensors.",
                hi = "रासायनिक ऊर्जा को बिजली में संचित करके स्टार्टर मोटर को 850+ एम्पीयर की भारी ताकत देती है और ईसीयू व लाइट्स के वोल्टेज को स्थिर रखती है।",
                ar = "بطارية رصاص-حمض تخزن الطاقة وتوفر تيار إقلاع عالياً لتشغيل محرك الديزل كما تعمل على استقرار الجهد لوحدة التحكم الإلكتروني."
            ),
            damageSymptoms = listOf(
                Bilingual("Slow cranking or dashboard display dimming/resetting during start", "सेल्फ धीमा चलना या स्टार्ट करते समय मीटर डिस्प्ले बंद होना", "ضعف تدوير المحرك أو انطفاء شاشة الطبلون عند التشغيل"),
                Bilingual("Green/white acid sulfation crust around terminal clamps", "खूंटों पर सफेद या हरा कार्बन जमा होना", "تراكم أملاح الكبريت البيضاء أو الخضراء على الأقطاب"),
                Bilingual("Swollen plastic casing or boiling rotten-egg smell (overcharging)", "बैटरी का फूलना या सड़े अंडे जैसी बदबू आना", "انتفاخ جسم البطارية أو رائحة غاز قوية بسبب الشحن الزائد")
            ),
            inspectionProcedure = listOf(
                Bilingual("Measure resting open-circuit voltage after 2 hours rest (12.6V = 100%, < 12.1V = discharged)", "मशीन बंद होने पर वोल्टेज नापें (12.6V फुल चार्ज, 12.1V से कम चार्ज की जरूरत)", "قس جهد البطارية وهي في وضع الراحة (12.6 فولت مشحونة بالكامل، أقل من 12.1 فولت تحتاج شحن)"),
                Bilingual("Inspect electrolyte level (for serviceable caps) and specific gravity with hydrometer (~1.265)", "डिस्टिल्ड वाटर लेवल और ग्रेविटी चेक करें (केवल डिस्टिल्ड वाटर ही डालें)", "افحص مستوى السائل والكثافة النوعية بمقياس الكثافة (1.265)"),
                Bilingual("Check chassis earth strap connection and master battery isolator switch resistance", "चेसिस अर्थिंग केबल और बैटरी कट-ऑफ स्विच का ढीलापन जांचें", "افحص كابل التأريض بالشاسيه ومفتاح عزل البطارية")
            ),
            repairInstructions = listOf(
                Bilingual("Disconnect NEGATIVE (-) clamp first and reconnect NEGATIVE (-) clamp last to avoid tool sparks", "हमेशा पहले नेगेटिव (-) तार खोलें और सबसे अंत में नेगेटिव (-) तार जोड़ें", "افصل القطب السالب (-) أولاً ووصله أخيراً لتفادي حدوث قوس كهربائي"),
                Bilingual("Clean posts and clamps with baking soda solution + wire brush, then coat lightly with petroleum jelly", "खूंटों को गर्म पानी व ब्रश से साफ करके टाइट कसें और पेट्रोलियम जेली लगाएं", "نظف الأقطاب بفرشاة سلكية ثم ادهنها بطبقة خفيفة من الفازلين لمنع الأكسدة"),
                Bilingual("Top up cells ONLY with pure distilled/deionized water—never tap water or acid", "बैटरी में केवल डिस्टिल्ड वाटर ही डालें, नल का पानी या तेजाब कभी न डालें", "زود الخلايا بالماء المقطر فقط ولا تستخدم ماء الصنبور أو الحمض")
            ),
            safetyWarning = Bilingual(
                en = "DANGER: Batteries emit explosive hydrogen gas & contain sulfuric acid! Keep sparks/flames away and turn OFF isolator switch before welding on machine.",
                hi = "खतरा: बैटरी में तेजाब व विस्फोटक गैस होती है! वेल्डिंग करने से पहले बैटरी आइसोलेटर स्विच बंद कर दें व केबल हटा दें।",
                ar = "خطر: تطلق البطاريات غاز الهيدروجين القابل للانفجار وتحتوي على حمض الكبريتيك! افصل البطارية تماماً قبل إجراء أي لحام كهربائي على الآلة."
            ),
            torqueSpec = "Terminal Clamp Bolts: snug firm (~10–12 Nm) — do not over-crush lead post",
            diagramPoints = listOf(
                DiagramPoint(1, "Positive (+) Terminal Post", "पॉजिटिव (+) टर्मिनल", "Feeds starter B+ and main maxi-fuse", "सेल्फ व मेन फ्यूज को करंट देने वाला खूंटा", "القطب الموجب (+)", "يغذي السلف والمصهر الرئيسي"),
                DiagramPoint(2, "Negative (-) Ground Post", "नेगेटिव (-) अर्थिंग खूंटा", "Routes via isolator switch to chassis earth", "कट-ऑफ स्विच से चेसिस अर्थिंग में जाता है", "القطب السالب (-)", "يتصل بمفتاح العزل وشاسيه الآلة"),
                DiagramPoint(3, "Cell Vent Caps", "सेल वेंट कैप्स", "Allows distilled water checks and gas venting", "पानी चेक करने व गैस निकालने के ढक्कन", "أغطية الخلايا", "للكشف عن الماء المقطر وتصريف الغازات"),
                DiagramPoint(4, "Carry Handles & Hold-Down Frame", "होल्ड-डाउन क्लैंप", "Prevents vibration fracture on rough terrain", "झटकों में बैटरी को हिलने से रोकने वाला क्लैंप", "إطار التثبيت", "يمنع اهتزاز البطارية وتلف الألواح")
            ),
            manualReference = "JCB Operator & Electrical Manual Section C (Battery & Isolator)"
        ),

        // 4. TRANSMISSION & GEARBOX
        JcbPart(
            id = "part_synchroshuttle_transmission",
            partNumber = "445/03200 / JCB SS700 (Powershift on 4CX/5CX)",
            system = SystemCategory.TRANSMISSION,
            nameEn = "Transmission & Gearbox (Synchroshuttle)",
            nameHi = "ट्रांसमिशन और गियरबॉक्स (सिंक्रोशटल)",
            nameAr = "ناقل الحركة وصندوق التروس",
            imageResId = R.drawable.img_part_transmission,
            supportedModels = listOf("JCB 3CX", "JCB 4CX", "JCB 3DX", "JCB 5CX", "CAT Backhoe"),
            modelDifferences = listOf(
                Bilingual(
                    en = "3DX & basic 3CX use 4-speed Synchroshuttle; high-spec 3CX/4CX/5CX use 4- or 6-speed Powershift / Autoshift with TorqueLock.",
                    hi = "3DX में 4-स्पीड सिंक्रोशटल गियरबॉक्स होता है, जबकि 4CX/5CX में 6-स्पीड पावरशिफ्ट/ऑटोशिफ्ट ट्रांसमिशन लगता है।",
                    ar = "تستخدم 3DX ناقل Synchroshuttle بـ 4 سرعات، بينما تستخدم 4CX و5CX ناقل Powershift أوتوماتيكي بـ 6 سرعات."
                )
            ),
            location = Bilingual(
                en = "Bolted directly behind the engine flywheel housing between the main chassis rails.",
                hi = "इंजन के ठीक पीछे चेसिस के बीच में फ्लाईव्हील हाउसिंग से जुड़ा होता है।",
                ar = "مثبت مباشرة خلف غطاء الحدافة للمحرك بين قضبان الشاسيه الرئيسية."
            ),
            workingPrinciple = Bilingual(
                en = "Combines a fluid torque converter with hydraulically actuated forward/reverse multi-plate clutch packs and a 4-speed synchromesh gearbox, enabling clutchless shuttle reversals.",
                hi = "टॉर्क कनवर्टर और हाइड्रोलिक क्लच पैक की मदद से बिना क्लच पेडल दबाए आगे-पीछे (शटल) चलने की सुविधा देता है।",
                ar = "يدمج محول العزم الهيدروليكي مع مجموعات كلاتش أمامي/خلفي وصندوق تروس متزامن لتغيير الاتجاه بسلاسة دون دواسة كلاتش."
            ),
            damageSymptoms = listOf(
                Bilingual("Machine fails to pull strongly or slips in forward/reverse", "मशीन का ताकत न लगाना या गियर स्लिप होना", "انزلاق القابض وضعف سحب الآلة للأمام أو للخلف"),
                Bilingual("Grinding noise when selecting gears (worn synchro rings)", "गियर लगाते समय आवाज आना या गियर अटकना", "صوت طحن وتصادم عند تعشيق التروس"),
                Bilingual("Burnt dark transmission fluid & overheat warning buzzer", "तेल का काला पड़कर जलने की बदबू आना", "اسوداد زيت الجير ورائحة احتراق مع تحذير الحرارة")
            ),
            inspectionProcedure = listOf(
                Bilingual("Check transmission dipstick with engine idling in neutral on flat ground", "समतल जमीन पर इंजन स्टार्ट रखकर न्यूट्रल में गियर ऑयल लेवल नापें", "افحص عيار زيت الجير والمحرك يدور بوضع الحياد على أرض مستوية"),
                Bilingual("Test main clutch pack pressure at test port (verify against model spec)", "टेस्ट पोर्ट पर क्लच पैक का ऑयल प्रेशर गेज से जांचें", "قس ضغط حزمة الكلاتش من منفذ الاختبار ومطابقته للمواصفات"),
                Bilingual("Check Fwd/Rev solenoid coil resistance and clean magnetic sump strainer", "शटल सोलेनोइड कॉइल और नीचे की मैग्नेटिक जाली की जांच करें", "اختبر مقاومة ملفات الاتجاه ونظف المصفاة السفلية المغناطيسية")
            ),
            repairInstructions = listOf(
                Bilingual("Use ONLY JCB Special Transmission Fluid (10W / Torque Converter ATF) — never heavy 90W gear oil!", "केवल अनुशंसित ट्रांसमिशन ऑयल (10W) ही डालें, मोटा 90 नंबर गियर ऑयल कभी न डालें!", "استخدم زيت ناقل الحركة الموصى به (10W) فقط ولا تستخدم زيت دفرنس ثقيل أبداً!"),
                Bilingual("Pre-soak new friction clutch plates in clean transmission oil before assembly", "नई क्लच प्लेट्स लगाने से पहले साफ ट्रांसमिशन ऑयल में भिगोकर रखें", "انقع أقراص الكلاتش الجديدة في زيت نظيف قبل التجميع"),
                Bilingual("Flush transmission oil cooler lines thoroughly after any clutch failure", "क्लच रिपेयर के बाद ऑयल कूलर की पाइपें अच्छी तरह फ्लश करें", "نظف مبرد وخطوط زيت الجير بالكامل بعد أي تلف في الكلاتش")
            ),
            safetyWarning = Bilingual(
                en = "WARNING: Never shuttle between Forward and Reverse at full travel speed—brake first to avoid shock damage and rollovers.",
                hi = "सावधानी: तेज स्पीड पर अचानक फॉरवर्ड-रिवर्स न मारें, पहले ब्रेक से मशीन धीमी करें।",
                ar = "تحذير: لا تبدّل بين الأمام والخلف أثناء السرعة العالية؛ هدئ الآلة بالفرامل أولاً."
            ),
            torqueSpec = "Check OEM manual for case & torque converter bolts",
            diagramPoints = listOf(
                DiagramPoint(1, "Torque Converter", "टॉर्क कनवर्टर", "Hydraulic fluid coupling multiplying torque", "तेल के दबाव से ताकत बढ़ाने वाला ड्रम", "محول العزم (البطيخة)", "وصلة هيدروليكية تضاعف العزم"),
                DiagramPoint(2, "Fwd / Rev Clutch Packs", "फॉरवर्ड/रिवर्स क्लच पैक", "Hydraulically engaged multi-disc clutches", "आगे-पीछे करने वाली क्लच प्लेटें", "مجموعات كلاتش الأمام والخلف", "أقراص احتكاك تعمل بالضغط الهيدروليكي"),
                DiagramPoint(3, "4-Speed Synchromesh Gears", "4-स्पीड सिंक्रोमेश गियर", "Main manual gear ratios & synchro hubs", "1 से 4 गियर बदलने वाला शाफ्ट", "تروس السرعات المتزامنة", "تنقل السرعات الأربع بسلاسة"),
                DiagramPoint(4, "Shuttle Solenoid Valve", "शटल सोलेनोइड वाल्व", "Directs clutch pressure electrically", "करंट से गियर दिशा बदलने वाला वाल्व", "صمام التحكم اللولبي", "يوجه الزيت لقابض الأمام أو الخلف")
            ),
            manualReference = "JCB Drivetrain Workshop Manual Section F"
        ),

        // 5. BRAKE SYSTEM
        JcbPart(
            id = "part_brake_discs",
            partNumber = "15/905501 / 450/10224 (Oil-Immersed Wet Discs)",
            system = SystemCategory.BRAKE,
            nameEn = "Brake (Wet Oil-Immersed Rear Brake Disc Pack)",
            nameHi = "ब्रेक (वेट ऑयल-इमर्स्ड ब्रेक डिस्क)",
            nameAr = "الفرامل (أقراص الفرامل الزيتية)",
            imageResId = R.drawable.img_part_brake_disc,
            supportedModels = listOf("JCB 3CX", "JCB 4CX", "JCB 3DX", "JCB 5CX", "CAT Backhoe"),
            modelDifferences = listOf(
                Bilingual(
                    en = "Disc diameter and spline tooth count differ between JCB PD70/SD70/Banjo axles and CAT Carraro/ZF axles; ALL require MINERAL hydraulic brake fluid.",
                    hi = "JCB और CAT एक्सल के हिसाब से डिस्क का साइज व दांत अलग होते हैं, लेकिन सबमें मिनरल ब्रेक ऑयल (DOT 3/4 नहीं) पड़ता है।",
                    ar = "تختلف أقطار الأقراص وعدد الأسنان بين محاور JCB وCAT، وجميعها تتطلب زيت فرامل معدني وليس DOT 3/4."
                )
            ),
            location = Bilingual(
                en = "Sealed inside the left and right rear axle housings immersed in axle oil.",
                hi = "पिछले रियर एक्सल के दोनों सिरों (ट्रम्पेट हाउसिंग) के अंदर तेल में डूबी होती हैं।",
                ar = "مغلقة داخل طرفي المحور الخلفي ومغمورة في زيت الدفرنس."
            ),
            workingPrinciple = Bilingual(
                en = "Pressing the cabin brake pedals sends mineral oil from dual master cylinders to internal annular pistons inside the rear axle, clamping alternating friction discs and steel reaction plates in an oil bath for fade-free stopping.",
                hi = "ब्रेक पेडल दबाने पर मास्टर सिलेंडर का तेल एक्सल के पिस्टन को दबाता है, जिससे तेल में डूबी फ्रिक्शन डिस्क और स्टील प्लेट चिपककर मशीन रोक देती हैं।",
                ar = "يرسل ضغط الدواسة الزيت المعدني من الأسطوانة الرئيسية لدفع المكبس الحلقي داخل المحور وتثبيت أقراص الاحتكاك لإيقاف الآلة."
            ),
            damageSymptoms = listOf(
                Bilingual("Spongy brake pedal sinking to floorboard or uneven pull left/right", "ब्रेक पेडल का फर्श तक दब जाना या मशीन का एक तरफ खिंचना", "هبوط الدواسة للأسفل أو انحراف الآلة لجهة واحدة عند الفرملة"),
                Bilingual("Loud groaning, shuddering, or chattering noise from rear axle", "ब्रेक मारने पर पीछे एक्सल से तेज गड़गड़ाहट", "صوت صرير واهتزاز قوي من المحور الخلفي أثناء الفرملة"),
                Bilingual("Overheating rear hubs due to dragging brake pistons", "ब्रेक चिपके रहने से पिछले पहिए के हब बहुत गर्म होना", "سخونة مفرطة في صرر العجلات الخلفية")
            ),
            inspectionProcedure = listOf(
                Bilingual("Bleed brake circuit at rear axle bleed nipples and check fluid color in reservoir", "एक्सल पर ब्लीडर स्क्रू से ब्रेक पाइपों की हवा निकालें", "نزّف الهواء من مسامير التنسيم بالمحور الخلفي وافحص لون السائل"),
                Bilingual("Check disc friction thickness via axle inspection plug or during hub stripdown", "एक्सल निरीक्षण प्लग से डिस्क की मोटाई की जांच करें", "تحقق من سماكة أقراص الاحتكاك عبر فتحة الفحص"),
                Bilingual("Verify dual-pedal interlock latch and handbrake cable adjustment", "दोनों ब्रेक पेडल के लॉक पिन और हैंडब्रेक की सेटिंग जांचें", "افحص قفل ربط الدواستين وتعيير فرامل اليد")
            ),
            repairInstructions = listOf(
                Bilingual("CRITICAL: Use ONLY JCB Light Mineral Hydraulic Fluid (ISO VG 15). Automotive DOT 3/4 fluid swells & destroys all axle seals!", "अति आवश्यक: केवल मिनरल हाइड्रोलिक ब्रेक ऑयल डालें! गाड़ियों वाला DOT 3/4 ऑयल सारी सीलें गला देता है!", "تحذير حاسم: استخدم الزيت المعدني الخفيف فقط (ISO VG 15). زيت DOT 3/4 يتلف موانع التسرب المطاطية فوراً!"),
                Bilingual("Soak new friction discs in genuine axle gear oil before fitting", "नई ब्रेक प्लेट लगाने से पहले 2 घंटे एक्सल ऑयल में डुबोकर रखें", "انقع أقراص الاحتكاك الجديدة في زيت المحور قبل التركيب"),
                Bilingual("Fit new piston O-ring & D-rings cleanly without rolling or nicking seal lips", "पिस्टन की नई सील रिंग बिना मुड़े सावधानी से बैठाएं", "ركب حلقات المكبس الجديدة بعناية دون التواء")
            ),
            safetyWarning = Bilingual(
                en = "DANGER: Support machine on heavy 10-ton axle stands before removing rear wheels. Lock both brake pedals together for road travel!",
                hi = "खतरा: सड़क पर चलते समय दोनों ब्रेक पेडल हमेशा आपस में पिन से लॉक करके रखें।",
                ar = "خطر: اربط دواستي الفرامل معاً بقفل الأمان أثناء السير على الطرق العامة."
            ),
            torqueSpec = "Axle Trumpet & Caliper Bolts: verify axle family OEM torque manual",
            diagramPoints = listOf(
                DiagramPoint(1, "Annular Brake Piston", "हाइड्रोलिक पिस्टन", "Ring piston actuated by master cylinder pressure", "तेल के दबाव से प्लेट दबाने वाला गोल पिस्टन", "المكبس الحلقي", "يضغط الأقراص بفعل ضغط الزيت"),
                DiagramPoint(2, "Friction Lining Discs", "फ्रिक्शन डिस्क", "Grooved oil-cooled friction plates splined to shaft", "तेल में ठंडी होने वाली घर्षण प्लेटें", "أقراص الاحتكاك", "تدور مع عمود المحور لتوليد الفرملة"),
                DiagramPoint(3, "Steel Counterplates", "स्टील काउंटर प्लेट्स", "Stationary steel plates anchored in housing", "एक्सल बॉडी में फंसी स्थिर प्लेटें", "الألواح الفولاذية الثابتة", "تثبت داخل جسم المحور"),
                DiagramPoint(4, "Return Springs", "रिटर्न स्प्रिंग", "Retracts piston when pedal is released", "ब्रेक छोड़ने पर पिस्टन वापस खींचने वाले स्प्रिंग", "نوابض الإرجاع", "تعيد المكبس عند رفع القدم عن الدواسة")
            ),
            manualReference = "JCB Workshop Manual Section G (Brakes & Rear Axle)"
        ),

        // 6. STEERING SYSTEM
        JcbPart(
            id = "part_steering_orbitrol",
            partNumber = "35/410900 / Danfoss OSPC Orbitrol Unit",
            system = SystemCategory.STEERING,
            nameEn = "Hydraulic Steering Orbitrol Control Unit",
            nameHi = "हाइड्रोलिक स्टीयरिंग ऑर्बिट्रॉल वाल्व",
            nameAr = "وحدة التوجيه الهيدروليكية (الأوربيترول)",
            imageResId = R.drawable.img_part_steering_orbitrol,
            supportedModels = listOf("JCB 3CX", "JCB 4CX", "JCB 3DX", "JCB 5CX", "CAT Backhoe"),
            modelDifferences = listOf(
                Bilingual(
                    en = "Open-center priority-fed orbitrol on 3DX vs Load-Sensing (LS) closed-center orbitrol on 4CX/5CX All-Wheel-Steer machines.",
                    hi = "3DX में ओपन-सेंटर प्रायोरिटी ऑर्बिट्रॉल, जबकि 4CX/5CX में लोड-सेंसिंग (LS) ऑर्बिट्रॉल लगता है।",
                    ar = "تستخدم 3DX وحدة توجيه مفتوحة المركز، بينما تستخدم 4CX و5CX وحدة استشعار الحمل (LS)."
                )
            ),
            viewAngles = listOf(
                PartViewAngle(
                    Bilingual("Top Splined Column Shaft", "ऊपरी स्टीयरिंग कॉलम स्प्लाइन", "العمود المسنن العلوي"),
                    Bilingual("Couples directly beneath the cabin steering column shaft.", "कैबिन में स्टीयरिंग व्हील के निचले सिरे से जुड़ता है।", "يتصل مباشرة أسفل عمود عجلة القيادة بالمقصورة.")
                ),
                PartViewAngle(
                    Bilingual("Side P, T, L, R Hydraulic Ports", "P, T, L, R साइड पोर्ट", "منافذ P وT وL وR الجانبية"),
                    Bilingual("P=Pump Priority, T=Tank Return, L=Left Turn Ram, R=Right Turn Ram.", "P=पंप इनलेट, T=टैंक वापसी, L=बायां टर्न, R=दायां टर्न।", "P=دخل المضخة، T=راجع الخزان، L=يسار، R=يمين.")
                )
            ),
            location = Bilingual(
                en = "Mounted at the base of the steering column behind the front cabin firewall / lower console.",
                hi = "कैबिन में स्टीयरिंग व्हील कॉलम के ठीक नीचे फ्रंट डैशबोर्ड के पीछे लगा होता है।",
                ar = "مثبتة أسفل عمود المقود خلف لوحة القيادة الأمامية للمقصورة."
            ),
            workingPrinciple = Bilingual(
                en = "Hydrostatic rotary metering valve with internal gerotor pump. Turning the steering wheel shifts a rotary sleeve to meter proportional hydraulic oil to the front axle steering cylinder, while allowing emergency manual pumping if engine stalls.",
                hi = "स्टीयरिंग घुमाने पर अंदर का रोटरी वाल्व और जिरोटर तेल को नापकर फ्रंट एक्सल स्टीयरिंग सिलेंडर में भेजता है, जिससे भारी मशीन उंगली से मुड़ जाती है।",
                ar = "صمام قياس دوار يوجه الزيت الهيدروليكي بدقة نحو أسطوانة التوجيه عند لف المقود، ويسمح بالتوجيه اليدوي الطارئ عند توقف المحرك."
            ),
            damageSymptoms = listOf(
                Bilingual("Heavy or stiff steering wheel requiring extreme effort", "स्टीयरिंग का बहुत सख्त या जाम चलना", "ثقل شديد وصعوبة في لف عجلة القيادة"),
                Bilingual("Steering wheel spins continuously without turning front wheels (blown cylinder or worn gerotor)", "स्टीयरिंग घूमता रहता है पर पहिए नहीं मुड़ते", "دوران المقود باستمرار دون استجابة العجلات"),
                Bilingual("Hydraulic oil leaking down steering column onto cabin floor", "स्टीयरिंग के नीचे कैबिन में तेल टपकना", "تسرب الزيت على أرضية المقصورة أسفل عمود التوجيه")
            ),
            inspectionProcedure = listOf(
                Bilingual("Check steering priority valve pressure at P-port (typically ~140–175 bar relief)", "प्रायोरिटी वाल्व से ऑर्बिट्रॉल में आने वाला प्रेशर चेक करें", "قس ضغط التغذية الواصل إلى منفذ P من صمام الأولوية"),
                Bilingual("Cap steering cylinder hoses briefly to isolate cylinder internal leak vs orbitrol wear", "सिलेंडर पाइप ब्लॉक करके जांचें कि खराबी सिलेंडर में है या ऑर्बिट्रॉल में", "اعزل خراطيم أسطوانة التوجيه مؤقتاً لتحديد مصدر التسرب الداخلي"),
                Bilingual("Inspect priority valve spool on main pump/inlet section for sticking", "प्रायोरिटी वाल्व स्पूल में कचरा या जाम होना जांचें", "افحص بكرة صمام الأولوية للتأكد من عدم انحشارها")
            ),
            repairInstructions = listOf(
                Bilingual("Label P, T, L, R (and LS) ports carefully before removing hoses", "खोलने से पहले P, T, L, R सभी पाइपों पर निशान जरूर लगाएं", "ضع علامات واضحة على منافذ P وT وL وR قبل فك الخراطيم"),
                Bilingual("Use a genuine Danfoss/JCB dust & shaft seal kit; align gerotor drive pin timing mark exactly if stripped", "खोलते समय अंदरूनी जिरोटर टाइमिंग मार्क मिलाकर ही जोड़ें वरना स्टीयरिंग झटका मारेगा", "عند التجميع طابق علامات التوقيت الداخلية للجيروتور بدقة تامة"),
                Bilingual("Turn steering lock-to-lock slowly with axle raised to bleed trapped air", "आगे के पहिए उठाकर धीरे-धीरे दोनों तरफ पूरा काटकर हवा निकालें", "لف المقود من أقصى اليمين إلى أقصى اليسار لتفريغ الهواء بعد التركيب")
            ),
            safetyWarning = Bilingual(
                en = "DANGER: Incorrect internal gerotor timing causes sudden violent steering wheel kickback ('motoring')! Verify timing marks per manual.",
                hi = "खतरा: गलत असेंबली से स्टीयरिंग झटके से उल्टा घूम सकता है! टाइमिंग मार्क का विशेष ध्यान रखें।",
                ar = "خطر: عدم تطابق علامات التوقيت الداخلية قد يسبب دوراناً عنيفاً ومفاجئاً لعجلة القيادة!"
            ),
            torqueSpec = "Port Adapters & Column Bolts: consult OEM torque spec (~30–45 Nm)",
            diagramPoints = listOf(
                DiagramPoint(1, "Rotary Spool & Sleeve", "रोटरी स्पूल व स्लीव", "Opens fluid metering ports when wheel turns", "स्टीयरिंग घुमाने पर तेल का रास्ता खोलने वाला वाल्व", "البكرة الدوارة والكم", "تفتح ممرات الزيت عند تدوير المقود"),
                DiagramPoint(2, "Internal Gerotor Gearset", "जिरोटर मीटरिंग पंप", "Meters exact volume per wheel revolution", "स्टीयरिंग के हिसाब से तेल नापने वाला पंप", "مجموعة الجيروتور", "تقيس كمية الزيت الدقيقة لكل لفة"),
                DiagramPoint(3, "P, T, L, R Ports", "P, T, L, R पोर्ट्स", "Supply, return, left and right cylinder ports", "इनलेट, रिटर्न व दाएं-बाएं सिलेंडर पोर्ट", "منافذ الضغط والأسطوانة", "التغذية والراجع وأطراف الأسطوانة"),
                DiagramPoint(4, "Input Shaft Lip Seal", "शाफ्ट ऑयल सील", "Prevents oil leaking into cabin", "कैबिन में तेल लीक होने से रोकने वाली सील", "مانع تسرب العمود", "يمنع تسرب الزيت إلى المقصورة")
            ),
            manualReference = "JCB Workshop Manual Section G (Steering Orbitrol & Priority Valve)"
        )
    )
}
