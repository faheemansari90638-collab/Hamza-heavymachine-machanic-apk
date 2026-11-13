package com.example.data

import com.example.model.*

object JcbFaultDatabase {

    val errorCodes: List<JcbErrorCode> = listOf(
        JcbErrorCode(
            code = "P0087",
            system = SystemCategory.FUEL,
            title = Bilingual(
                en = "Fuel Rail Pressure (FRP) Too Low",
                hi = "फ्यूल रेल प्रेशर (कॉमन रेल) अत्यधिक कम होना",
                ar = "انخفاض ضغط مسطرة الوقود (Common Rail) عن الحد المطلوب"
            ),
            severity = ErrorSeverity.CRITICAL_STOP,
            symptoms = Bilingual(
                en = "Engine cranks but fails to start; immediate engine shutdown under heavy digging load; severe lack of power; Amber engine warning light illuminated.",
                hi = "इंजन सेल्फ लेता है लेकिन स्टार्ट नहीं होता; लोड पड़ते ही मशीन बंद हो जाती है; इंजन का खिंचाव खत्म होना; डैशबोर्ड पर पीली इंजन बत्ती जलना।",
                ar = "المحرك يدور بالسلف لكنه لا يشتغل؛ توقف مفاجئ تحت الحمل الثقيل؛ ضعف حاد في العزم مع إضاءة لمبة الأعطال البرتقالية."
            ),
            probableCauses = listOf(
                Bilingual(
                    "Clogged primary fuel water-separator filter or secondary micron filter",
                    "प्राइमरी वाटर सेपरेटर या सेकेंडरी डीजल फिल्टर का चोक होना",
                    "انسداد فلتر الوقود الأولي (فاصل الماء) أو الفلتر الثانوي الدقيق"
                ),
                Bilingual(
                    "Air ingress into suction fuel lines from fuel tank to lift pump",
                    "टैंक से लिफ्ट पंप तक डीजल पाइप में हवा (एयर) घुस जाना",
                    "تسرب هواء إلى خطوط سحب الديزل بين الخزان ومضخة التحضير"
                ),
                Bilingual(
                    "Faulty Fuel Rail Pressure Limiter Valve leaking return fuel continuously to tank",
                    "कॉमन रेल का प्रेशर लिमिटर वाल्व खराब होना जिससे डीजल रिटर्न में बहना",
                    "تلف بلف تحديد الضغط في المسطرة مما يؤدي لتهريب الوقود للراجع باستمرار"
                ),
                Bilingual(
                    "High-pressure common rail fuel pump delivery pressure shortfall or SCV sticking",
                    "हाई प्रेशर डीजल पंप या सक्शन कंट्रोल वाल्व (SCV) का अटकना",
                    "ضعف مضخة الضغط العالي أو تعليق صمام التحكم بالشفط (SCV)"
                )
            ),
            stepByStepTroubleshooting = listOf(
                Bilingual(
                    "Step 1: Check fuel level in diesel tank and inspect for water contamination or rust",
                    "कदम 1: डीजल टैंक में तेल का स्तर और पानी/कचरा चेक करें",
                    "الخطوة 1: افحص مستوى الديزل في الخزان وتأكد من خلوه من الماء والصدأ"
                ),
                Bilingual(
                    "Step 2: Inspect fuel primer hand pump; pump until bulb/knob feels rock hard and bleed air at fuel head bleed screw",
                    "कदम 2: हैंड प्राइमर दबाकर चेक करें कि वह सख्त हो रहा है या नहीं, एयर स्क्रू से हवा निकालें",
                    "الخطوة 2: اضغط مضخة التحضير اليدوية حتى تصبح صلبة وأخرج الهواء من مسمار التنسيم"
                ),
                Bilingual(
                    "Step 3: Measure fuel rail pressure on Live Data scanner: Cranking pressure must reach minimum 250-300 bar for injectors to fire",
                    "कदम 3: क्रैंकिंग के समय रेल प्रेशर न्यूनतम 250 से 300 बार होना चाहिए",
                    "الخطوة 3: افحص ضغط المسطرة بجهاز الفحص؛ يجب أن يصل إلى 250-300 بار أثناء التشغيل"
                ),
                Bilingual(
                    "Step 4: Check injector back-leakage rates; excessive return indicates worn injector control valves",
                    "कदम 4: इंजेक्टरों का बैक-लीक चेक करें; अधिक रिटर्न आने पर इंजेक्टर रिपेयर कराएं",
                    "الخطوة 4: قس راجع البخاخات؛ الراجع الزائد يدل على تآكل البخاخات"
                ),
                Bilingual(
                    "Step 5: Replace fuel filters with genuine 5-micron JCB filters and prime system thoroughly",
                    "कदम 5: दोनों डीजल फिल्टर नए ओरिजिनल लगाएं और अच्छी तरह हवा निकालें",
                    "الخطوة 5: استبدل فلاتر الديزل بأخرى أصلية 5 ميكرون وقم بتنسيم الدورة جيداً"
                )
            ),
            warningLampType = "Amber Engine Malfunction Lamp + Diagnostic Buzzer",
            canOperate = false,
            officialManualNote = "Refer to JCB LiveLink & Delphi/Bosch Common Rail Diagnostics Manual (Section B-9)"
        ),
        JcbErrorCode(
            code = "P0117",
            system = SystemCategory.COOLING,
            title = Bilingual(
                en = "Engine Coolant Temperature (ECT) Sensor Circuit Low Input",
                hi = "इंजन कूलेंट तापमान (ECT) सेंसर सिग्नल वोल्टेज लो (शॉर्ट सर्किट)",
                ar = "انخفاض إشارة حساس حرارة سائل التبريد (قصر كهربائي بالدائرة)"
            ),
            severity = ErrorSeverity.WARNING_CAUTION,
            symptoms = Bilingual(
                en = "Coolant temperature gauge reads maximum red scale; radiator cooling fan runs at 100% full speed continuously; engine de-rates power by 20% to prevent seizure.",
                hi = "तापमान की सुई पूरी लाल निशान पर चली जाती है; रेडिएटर पंखा लगातार पूरी स्पीड पर चलता है; इंजन बचाव के लिए पावर 20% कम कर देता है।",
                ar = "مؤشر الحرارة يرتفع للخط الأحمر فوراً؛ مروحة التبريد تعمل بأقصى سرعة باستمرار؛ انخفاض قدرة المحرك بنسبة 20% للحماية."
            ),
            probableCauses = listOf(
                Bilingual(
                    "Wiring harness shorted to chassis ground near thermostat housing",
                    "थर्मोस्टेट के पास सेंसर का तार चेसिस से घिसकर शॉर्ट होना",
                    "تلامس سلك الحساس مع جسم المحرك (أرضي) قرب بيت البلف الحراري"
                ),
                Bilingual(
                    "ECT temperature sensor internal thermistor short circuit",
                    "कूलेंट सेंसर के अंदर शॉर्ट सर्किट होना",
                    "قصر داخلي في المقاومة الحرارية لحساس حرارة سائل التبريد"
                ),
                Bilingual(
                    "Corrosion or water ingress in the 2-pin sensor plug connector",
                    "सेंसर के प्लग में पानी या जंग का लगना",
                    "تأكسد أو دخول ماء داخل فيشة الحساس ثنائية الأطراف"
                )
            ),
            stepByStepTroubleshooting = listOf(
                Bilingual(
                    "Step 1: Disconnect sensor plug; verify if gauge drops to cold (confirms harness short vs ECU fault)",
                    "कदम 1: सेंसर का प्लग निकालें; यदि सुई नीचे गिर जाती है तो वायरिंग या सेंसर में शॉर्ट है",
                    "الخطوة 1: افصل فيشة الحساس؛ إذا هبط المؤشر فهذا يؤكد وجود قصر بالحساس أو الضفيرة"
                ),
                Bilingual(
                    "Step 2: Measure sensor resistance with digital multimeter: cold (20°C) should read ~2.5 kΩ; hot (90°C) should read ~250 Ω",
                    "कदम 2: मल्टीमीटर से सेंसर का रेसिस्टेंस नापें: ठंडा होने पर 2.5 kΩ और गर्म पर 250 Ω होना चाहिए",
                    "الخطوة 2: قس مقاومة الحساس بالملتيميتر: بارد (20°C) ~2.5kΩ، ساخن (90°C) ~250Ω"
                ),
                Bilingual(
                    "Step 3: Check 5V reference wire from ECU with ignition ON (should measure 4.9 - 5.1 Volts)",
                    "कदम 3: चाबी ऑन करके 5 वोल्ट सप्लाई चेक करें",
                    "الخطوة 3: تأكد من وجود جهد مرجعي 5 فولت قادم من وحدة التحكم ECU"
                ),
                Bilingual(
                    "Step 4: Replace sensor and torque brass hex to 20 Nm; top up coolant and purge air",
                    "कदम 4: नया सेंसर लगाएं (20 Nm टॉर्क) और कूलेंट टॉप-अप करें",
                    "الخطوة 4: استبدل الحساس وشدّه بعزم 20 نيوتن.متر وأكمل سائل التبريد"
                )
            ),
            warningLampType = "Red Engine Overheat Lamp + Warning Buzzer",
            canOperate = false,
            officialManualNote = "JCB Electrical & Engine Management Manual Section C-4"
        ),
        JcbErrorCode(
            code = "H0042",
            system = SystemCategory.HYDRAULIC,
            title = Bilingual(
                en = "Hydraulic Oil Temperature Exceeds High Limit (> 93°C)",
                hi = "हाइड्रोलिक ऑयल का तापमान सीमा से अधिक (> 93°C) होना",
                ar = "ارتفاع حرارة الزيت الهيدروليكي فوق الحد الأقصى (> 93°C)"
            ),
            severity = ErrorSeverity.CRITICAL_STOP,
            symptoms = Bilingual(
                en = "Hydraulic oil alarm buzzer sounds; hydraulic arms slow down dramatically; burning hydraulic fluid smell; oil viscosity thins out causing spool bypassing.",
                hi = "हाइड्रोलिक बजर बजना; लोडर और बूम की स्पीड बहुत धीमी पड़ जाना; तेल जलने की बदबू आना; तेल पतला होकर वॉल्व से लीक होना।",
                ar = "رنين جرس إنذار الهيدروليك؛ بطء شديد في حركة البوم واللودر؛ رائحة احتراق زيت؛ ضعف اللزوجة وتهريب داخلي بالصمامات."
            ),
            probableCauses = listOf(
                Bilingual(
                    "Hydraulic oil cooler radiator matrix choked with compacted mud, straw, or dust",
                    "हाइड्रोलिक ऑयल कूलर की जाली में मिट्टी, पुआल या धूल जमा होना",
                    "انسداد رديتر تبريد الزيت الهيدروليكي بالطين أو الغبار المتراكم"
                ),
                Bilingual(
                    "Oil cooler bypass thermal relief valve stuck open",
                    "ऑयल कूलर का बाईपास वाल्व खुला अटक जाना",
                    "تعليق صمام التمرير الجانبي لمبرد الزيت في وضع الفتح"
                ),
                Bilingual(
                    "Main relief valve (MRV) set too low or blowing oil continuously over relief",
                    "मेन रिलीफ वॉल्व (MRV) का खुला रहना जिससे तेल लगातार गर्म होना",
                    "انفتاح صمام التنفيس الرئيسي (MRV) باستمرار مما يسخّن الزيت سريعاً"
                ),
                Bilingual(
                    "Severely low hydraulic reservoir oil level causing rapid thermal build-up",
                    "हाइड्रोलिक टैंक में तेल बहुत कम होना",
                    "نقص حاد في مستوى الزيت بخزان الهيدروليك"
                )
            ),
            stepByStepTroubleshooting = listOf(
                Bilingual(
                    "Step 1: Idle engine immediately; do NOT shut down abruptly (allow fan to blow over cooler for 3 minutes)",
                    "कदम 1: इंजन तुरंत बंद न करें; आइडल पर 3 मिनट चलने दें ताकि पंखे की हवा से ठंडा हो सके",
                    "الخطوة 1: اترك المحرك يعمل على السرعة الهادئة لمدة 3 دقائق ليبرد عبر المروحة"
                ),
                Bilingual(
                    "Step 2: Inspect hydraulic oil level sight gauge at side of machine tank",
                    "कदम 2: मशीन के साइड में लगे ग्लास में हाइड्रोलिक ऑयल लेवल चेक करें",
                    "الخطوة 2: افحص مستوى زيت الهيدروليك من زجاجة البيان الجانبية"
                ),
                Bilingual(
                    "Step 3: Blow compressed air or low pressure water backwards through oil cooler fins to clear packed mud",
                    "कदम 3: ऑयल कूलर की जाली को उल्टी दिशा से प्रेशर हवा या पानी से साफ करें",
                    "الخطوة 3: نظف ريش مبرد الزيت بالهواء المضغوط عكس اتجاه سحب المروحة"
                ),
                Bilingual(
                    "Step 4: Check if any auxiliary breaker or bucket lever is slightly stuck engaging relief valve",
                    "कदम 4: चेक करें कि कोई अतिरिक्त ब्रेकर या बकेट लीवर अटका हुआ तो नहीं रह गया",
                    "الخطوة 4: تأكد من عدم تعليق دواسة الدقاق أو أي ذراع تحكم"
                ),
                Bilingual(
                    "Step 5: Test MRV system pressure with 0-400 bar gauge (must read 230-250 bar)",
                    "कदम 5: 400 बार गेज से मेन रिलीफ प्रेशर चेक करें",
                    "الخطوة 5: قس ضغط صمام التنفيس الرئيسي بساعة 400 بار (يجب أن يكون 230-250 بار)"
                )
            ),
            warningLampType = "Red Hydraulic High Temperature Indicator",
            canOperate = false,
            officialManualNote = "JCB Service Manual Section E (Hydraulic Cooling Systems)"
        ),
        JcbErrorCode(
            code = "T0105",
            system = SystemCategory.TRANSMISSION,
            title = Bilingual(
                en = "Transmission Main Line Pressure Low (< 9 bar)",
                hi = "ट्रांसमिशन मेन ऑयल प्रेशर कम होना (< 9 बार)",
                ar = "انخفاض الضغط الرئيسي لناقل الحركة (< 9 بار)"
            ),
            severity = ErrorSeverity.CRITICAL_STOP,
            symptoms = Bilingual(
                en = "Machine slips heavily when pushing dirt piles; forward or reverse engages with severe delay or shudder; transmission oil temperature rises rapidly.",
                hi = "मिट्टी धकेलते समय मशीन स्लिप होना; आगे या पीछे का गियर देर से और झटके से लगना; गियरबॉक्स का बहुत गर्म होना।",
                ar = "انزلاق المعدة وضعف الدفع؛ تأخر أو نتعة قوية عند تعشيق الأمام أو الخلف؛ سخونة سريعة بزيت الجير."
            ),
            probableCauses = listOf(
                Bilingual(
                    "Low transmission oil level or incorrect fluid grade (e.g. wrong gear oil added)",
                    "ट्रांसमिशन ऑयल का कम होना या गलत ग्रेड का तेल डला होना",
                    "نقص زيت ناقل الحركة أو استخدام لزوجة خاطئة"
                ),
                Bilingual(
                    "Clogged transmission suction screen or spin-on transmission filter",
                    "ट्रांसमिशन सक्शन जाली या स्पिन-ऑन फिल्टर का चोक होना",
                    "انسداد مصفاة الشفط أو فلتر زيت الجير"
                ),
                Bilingual(
                    "Transmission internal charging pump worn out or pressure regulator valve spring broken",
                    "ट्रांसमिशन चार्जिंग पंप का घिस जाना या प्रेशर रेगुलेटर स्प्रिंग टूटना",
                    "تآكل مضخة شحن القير الداخلية أو كسر زنبرك منظم الضغط"
                ),
                Bilingual(
                    "Torque converter oil seal failure",
                    "टॉर्क कनवर्टर की ऑयल सील कट जाना",
                    "تلف صوفة محول العزم (البطيخة)"
                )
            ),
            stepByStepTroubleshooting = listOf(
                Bilingual(
                    "Step 1: Park machine on level ground, engine idling in neutral, and check transmission dipstick level",
                    "कदम 1: समतल जमीन पर न्यूट्रल में इंजन चालू रखकर ट्रांसमिशन गेज चेक करें",
                    "الخطوة 1: أوقف الآلة على أرض مستوية والمحرك يدور بالوضع المحايد وافحص عيار زيت القير"
                ),
                Bilingual(
                    "Step 2: Screw 0-25 bar pressure gauge into transmission main pressure test port",
                    "कदम 2: 25 बार का प्रेशर गेज टेस्ट पोर्ट में कसें",
                    "الخطوة 2: ركب ساعة قياس 0-25 بار في منفذ فحص ضغط القير الرئيسي"
                ),
                Bilingual(
                    "Step 3: At 1000 RPM, pressure must read minimum 11.5 - 13.5 bar (if below 9 bar, cease driving)",
                    "कदम 3: 1000 RPM पर प्रेशर 11.5 से 13.5 बार होना चाहिए (9 बार से कम पर मशीन न चलाएं)",
                    "الخطوة 3: عند 1000 RPM يجب أن يقرأ الضغط 11.5 - 13.5 بار (أوقف السير إذا قل عن 9 بار)"
                ),
                Bilingual(
                    "Step 4: Remove bottom suction screen and clean metal strainer with clean diesel",
                    "कदम 4: नीचे की सक्शन जाली खोलकर डीजल से साफ करें और नया फिल्टर लगाएं",
                    "الخطوة 4: فك مصفاة السحب السفلية ونظفها بديزل نظيف واستبدل الفلتر"
                ),
                Bilingual(
                    "Step 5: Test forward and reverse solenoid electrical signals with 12V test probe",
                    "कदम 5: फॉरवर्ड और रिवर्स सोलेनोइड में 12 वोल्ट सप्लाई चेक करें",
                    "الخطوة 5: افحص وصول إشارة 12 فولت إلى ملفات تعشيق الأمام والخلف"
                )
            ),
            warningLampType = "Amber Transmission Pressure Warning Lamp",
            canOperate = false,
            officialManualNote = "JCB Drivetrain Workshop Manual Section F-2"
        ),
        JcbErrorCode(
            code = "E0012",
            system = SystemCategory.ELECTRICAL,
            title = Bilingual(
                en = "Battery Voltage Critical / Alternator Not Charging (< 11.8V)",
                hi = "बैटरी वोल्टेज कम / अल्टरनेटर चार्ज नहीं कर रहा (< 11.8V)",
                ar = "جهد البطارية حرج / الدينامو لا يشحن (< 11.8V)"
            ),
            severity = ErrorSeverity.WARNING_CAUTION,
            symptoms = Bilingual(
                en = "Red battery charge icon illuminates on dash; headlights dim; starter motor clicks weakly after stopping engine; electronic display resets randomly.",
                hi = "डैशबोर्ड पर लाल बैटरी बत्ती जलना; लाइटें धीमी पड़ना; बंद करने के बाद सेल्फ का केवल 'कट-कट' बोलना; डिस्प्ले का बार-बार बंद होना।",
                ar = "إضاءة لمبة البطارية الحمراء بالطبلون؛ ضعف الإنارة؛ صوت طقطقة ضعيف بالسلف عند التشغيل؛ إعادة تشغيل الشاشة تلقائياً."
            ),
            probableCauses = listOf(
                Bilingual(
                    "Loose, worn, or snapped alternator poly-V serpentine belt",
                    "अल्टरनेटर की फैन बेल्ट का ढीला होना, घिसना या टूट जाना",
                    "ارتخاء أو تآكل أو انقطاع سير المروحة والدينامو"
                ),
                Bilingual(
                    "Alternator internal diode pack or electronic voltage regulator failure",
                    "अल्टरनेटर का डायोड प्लेट या वोल्टेज रेगुलेटर खराब होना",
                    "عطل في قاعدة الدايود أو منظم الجهد (الكتاوت) داخل الدينامو"
                ),
                Bilingual(
                    "Heavily corroded, oxidized, or loose battery terminal clamps",
                    "बैटरी के खूंटों (टर्मिनलों) पर सफेद कार्बन या ढीलापन होना",
                    "تراكم الأملاح والأكسدة أو ارتخاء أصابع البطارية"
                ),
                Bilingual(
                    "Blown 60A / 80A main fusible link in chassis main fuse box",
                    "मेन फ्यूज बॉक्स में 60A/80A मेन फ्यूज का उड़ना",
                    "احتراق الفيوز الرئيسي 60A/80A بعلبة الشاسيه"
                )
            ),
            stepByStepTroubleshooting = listOf(
                Bilingual(
                    "Step 1: Check fan belt tension (deflection should be no more than 10-12 mm under thumb press)",
                    "कदम 1: बेल्ट का तनाव चेक करें (अंगूठे से दबाने पर 10-12 mm से ज्यादा नहीं दबना चाहिए)",
                    "الخطوة 1: افحص شد سير الدينامو (أقصى ارتخاء 10-12 مم عند الضغط بالإصبع)"
                ),
                Bilingual(
                    "Step 2: Clean battery posts with wire brush and hot water, re-clamp firmly and apply petroleum jelly",
                    "कदम 2: बैटरी खूंटों को गर्म पानी और ब्रश से साफ करके टाइट कसें और ग्रीस/पेट्रोलियम जेली लगाएं",
                    "الخطوة 2: نظف أقطاب البطارية بفرشاة سلك وماء ساخن وشدّها بإحكام"
                ),
                Bilingual(
                    "Step 3: Measure voltage across battery terminals with engine running at 1500 RPM (charging voltage MUST read 13.8V - 14.4V)",
                    "कदम 3: 1500 RPM पर बैटरी पर वोल्टेज नापें (13.8 से 14.4 वोल्ट चार्जिंग होनी चाहिए)",
                    "الخطوة 3: قس الجهد على البطارية عند 1500 RPM (يجب أن يكون 13.8 - 14.4 فولت)"
                ),
                Bilingual(
                    "Step 4: Check alternator D+ excitation terminal wire for 12V bulb signal",
                    "कदम 4: अल्टरनेटर के पतले तार पर इग्निशन करंट चेक करें",
                    "الخطوة 4: افحص وصول 12 فولت إلى طرف التنبيه D+ بالدينامو"
                )
            ),
            warningLampType = "Red Battery / Alternator Charge Indicator",
            canOperate = true,
            officialManualNote = "JCB Electrical Schematic Manual Section C"
        )
    )

    val diagnosticGuides: List<DiagnosticGuide> = listOf(
        DiagnosticGuide(
            id = "diag_starting",
            category = "Engine Starting Problems",
            title = Bilingual(
                en = "Engine Cranks But Will Not Start / Hard Starting",
                hi = "इंजन सेल्फ लेता है पर स्टार्ट नहीं होता / स्टार्टिंग में परेशानी",
                ar = "المحرك يدور بالسلف ولا يشتغل / صعوبة التشغيل"
            ),
            overview = Bilingual(
                en = "Systematic diagnosis for common diesel starting failures in JCB 3DX, 3CX, and Excavator models. Covers electrical cranking, fuel delivery, air lock, and immobilizer issues.",
                hi = "जेसीबी मशीनों में स्टार्ट न होने के कारणों का स्टेप-बाय-स्टेप गाइड। इसमें बैटरी, फ्यूल एयर लॉक, सोलेनोइड और सेंसर जांच शामिल हैं।",
                ar = "تشخيص منهجي لمشاكل تشغيل محركات الديزل في موديلات JCB، يشمل البطارية وسرعة السلف وهواء الديزل وصمام الإيقاف."
            ),
            symptomChecks = listOf(
                DiagnosticStep(
                    stepNumber = 1,
                    title = Bilingual("Verify Cranking Speed & Battery Health", "क्रैंकिंग स्पीड और बैटरी की जांच", "فحص سرعة دوران السلف وحالة البطارية"),
                    procedure = Bilingual(
                        en = "Observe starter motor cranking RPM. Diesel compression ignition requires minimum 180-200 RPM cranking speed to generate necessary heat of compression.",
                        hi = "सेल्फ घुमाने की रफ्तार देखें। डीजल इंजन चालू होने के लिए कम से कम 180-200 RPM की तेज क्रैंकिंग जरूरी होती है।",
                        ar = "لاحظ سرعة دوران السلف؛ يحتاج محرك الديزل إلى 180-200 دورة/دقيقة على الأقل لتوليد حرارة الانضغاط اللازمة للاشتعال."
                    ),
                    expectedOutcome = Bilingual("Brisk, strong cranking sound with battery maintaining > 10.2V during crank", "तेज सेल्फ की आवाज और क्रैंकिंग के समय वोल्टेज 10.2V से ऊपर रहना", "دوران قوي وسريع مع بقاء جهد البطارية أعلى من 10.2 فولت"),
                    remedyIfFailed = Bilingual("Recharge/replace 12V 130Ah battery, clean battery earth cable bolted to chassis frame", "बैटरी चार्ज करें, चेसिस पर कसे अर्थिंग तार को खोलकर साफ करें", "اشحن أو استبدل البطارية ونظف كابل التأريض المربوط بالشاسيه")
                ),
                DiagnosticStep(
                    stepNumber = 2,
                    title = Bilingual("Check Fuel Shut-Off Solenoid (FSO)", "फ्यूल कट-ऑफ सोलेनोइड की जांच", "فحص صمام إغلاق الوقود الكهربائي (FSO)"),
                    procedure = Bilingual(
                        en = "Turn ignition key to ON position (do not crank). Listen near the fuel injection pump for a distinct metallic 'CLICK' sound.",
                        hi = "चाबी ON करें (सेल्फ न मारें)। डीजल पंप के पास 'कट' की आवाज सुनें।",
                        ar = "أدر مفتاح التشغيل إلى ON دون تشغيل السلف واستمع لصوت طقة واضحة عند طرمبة الديزل."
                    ),
                    expectedOutcome = Bilingual("FSO solenoid clicks energized, lifting internal plunger to open diesel path", "सोलेनोइड एक्टिव होकर डीजल की लाइन खोल देता है", "يصدر الصمام صوت طقة ويفتح مسار الديزل"),
                    remedyIfFailed = Bilingual("Check FSO fuse and 12V feed. If 12V present but no click, replace FSO solenoid", "फ्यूज चेक करें। 12 वोल्ट आने पर भी आवाज न आए तो सोलेनोइड बदलें", "افحص المصهر ووصول 12 فولت؛ استبدل الصمام إذا كان الجهد واصلاً دون حركة")
                ),
                DiagnosticStep(
                    stepNumber = 3,
                    title = Bilingual("Bleed Air From Fuel System (Air Lock Removal)", "डीजल लाइन की हवा (एयर) निकालना", "تنسيم الهواء من دورة الوقود"),
                    procedure = Bilingual(
                        en = "Open fuel filter bleed screw. Pump the hand primer pump vigorously until pure diesel without white froth or air bubbles flows out continuously, then tighten screw while pumping.",
                        hi = "फिल्टर का एयर स्क्रू खोलें। हैंड प्राइमर को तब तक दबाएं जब तक बिना झाग का साफ डीजल न निकलने लगे, फिर दबाते हुए स्क्रू कसें।",
                        ar = "افتح مسمار التنسيم واضغط مضخة التحضير اليدوية حتى يخرج ديزل صافٍ بدون فقاعات، ثم أغلق المسمار أثناء الضغط."
                    ),
                    expectedOutcome = Bilingual("Hand primer becomes firm and resistant; clear bubble-free fuel discharge", "हैंड प्राइमर सख्त हो जाता है और बिना बुलबुले का डीजल निकलता है", "تصبح المضخة اليدوية قاسية ويخرج الوقود صافياً تماماً"),
                    remedyIfFailed = Bilingual("Inspect fuel pick-up pipe in fuel tank and suction rubber hoses for micro-cracks sucking air", "डीजल टैंक की सक्शन पाइप और रबर होज में बारीक क्रैक चेक करें जहां से हवा खींच रही हो", "افحص أنبوب السحب في الخزان والخراطيم بحثاً عن شقوق تسحب الهواء")
                ),
                DiagnosticStep(
                    stepNumber = 4,
                    title = Bilingual("Cracking Injector Pipe Nuts (High Pressure Check)", "इंजेक्टर पाइप नट खोलकर डीजल प्रेशर चेक करना", "فحص ضغط الوقود عند مواسير البخاخات"),
                    procedure = Bilingual(
                        en = "Loosen #1 and #4 high-pressure steel injector pipes at the cylinder head by half a turn. Crank engine for 5 seconds.",
                        hi = "1 और 4 नंबर इंजेक्टर के ऊपर का 17mm नट आधा चूड़ी ढीला करें और 5 सेकंड सेल्फ मारें।",
                        ar = "ارخِ صواميل مواسير البخاخ رقم 1 و 4 نصف لفة ثم أدر المحرك بالسلف لمدة 5 ثوانٍ."
                    ),
                    expectedOutcome = Bilingual("Vigorous pulsing spurts of diesel jetting from cracked flare nuts", "तेज फव्वारे के साथ डीजल की फुहार निकलना", "اندفاع قوي ومتقطع للديزل من الصواميل"),
                    remedyIfFailed = Bilingual("Fuel injection pump (FIP) or Common Rail pump internal drive failure; service fuel pump", "डीजल पंप में खराबी है; FIP पंप की सर्विस कराएं", "عطل في مضخة الحقن أو عمود الدوران الداخلي؛ يتطلب صيانة المضخة")
                )
            ),
            commonMistakes = Bilingual(
                en = "NEVER use ether starting spray (aerostart) heavily on turbo diesel engines; it cracks piston crowns and shatters piston rings.",
                hi = "गलती: स्टार्टर स्प्रे (ईथर) का अधिक छिड़काव कभी न करें; इससे पिस्टन और रिंग टूट जाते हैं।",
                ar = "تحذير: لا تستخدم بخاخ الإيثر بكثرة لتشغيل محركات التيربو ديزل لأنه يسبب كسر رأس المكبس والشنابر."
            ),
            manualRef = "JCB 3DX Operator & Maintenance Manual Chapter 6 (Troubleshooting)"
        ),
        DiagnosticGuide(
            id = "diag_hydraulic_slow",
            category = "Hydraulic Sluggishness",
            title = Bilingual(
                en = "Hydraulics Slow, Jerky, or Loss of Digging Power",
                hi = "हाइड्रोलिक धीमा होना, झटके लेना या खुदाई में ताकत न लगाना",
                ar = "بطء الهيدروليك أو تقطيعه أو فقدان قوة الحفر"
            ),
            overview = Bilingual(
                en = "Step-by-step diagnostic tree for backhoe loader and excavator hydraulic pressure drop, cavitation, overheating, and slow cycle times.",
                hi = "हाइड्रोलिक पंप, मेन रिलीफ वॉल्व, फिल्टर चोकिंग और सिलेंडर लीकेज को पकड़ने का सही तरीका।",
                ar = "شجرة تشخيص متدرجة لاكتشاف هبوط ضغط الهيدروليك، تكهف المضخة، السخونة، وضعف أذرع الحفر."
            ),
            symptomChecks = listOf(
                DiagnosticStep(
                    stepNumber = 1,
                    title = Bilingual("Inspect Hydraulic Oil Level & Oil Quality", "हाइड्रोलिक ऑयल लेवल और तेल की गुणवत्ता", "فحص مستوى ونقاء زيت الهيدروليك"),
                    procedure = Bilingual(
                        en = "Retract all loader and backhoe cylinders to park position on level ground. Check sight glass on hydraulic tank.",
                        hi = "सारे सिलेंडर अंदर करके समतल जगह पर मशीन खड़ी करें और टैंक का कांच वाला गेज देखें।",
                        ar = "اسحب جميع البساتم لوضع الوقوف على أرض مستوية وافحص زجاجة بيان مستوى الزيت."
                    ),
                    expectedOutcome = Bilingual("Oil level visible in upper green half; clear amber color without milky contamination", "तेल हरे निशान में दिखे; बिना दूधिया रंग (पानी) का साफ पीला तेल हो", "الزيت في النصف الأخضر العلوي وبـلون عنبري صافٍ دون تعكر حليبي"),
                    remedyIfFailed = Bilingual("Top up with ISO VG 46/68. If milky white, drain completely; water has contaminated oil", "VG 46/68 तेल डालें। दूधिया होने पर पूरा तेल बदलें क्योंकि पानी मिल चुका है", "أكمل الزيت بنوع ISO VG 46/68، وإذا كان حليبياً ففرّغه بالكامل لوجود ماء")
                ),
                DiagnosticStep(
                    stepNumber = 2,
                    title = Bilingual("Check Suction Strainer & Air Ingress", "सक्शन जाली और हवा खींचने की जांच", "فحص مصفاة الشفط وتسرب الهواء للمضخة"),
                    procedure = Bilingual(
                        en = "Listen to main pump while moving boom. A loud grinding marble-like sound indicates pump cavitation caused by a choked suction strainer.",
                        hi = "बूम चलाते समय पंप की आवाज सुनें। कंकड़ जैसी खड़खड़ाहट का मतलब है सक्शन जाली चोक है।",
                        ar = "استمع لصوت المضخة عند رفع البوم؛ صوت الحصى أو الطحن يدل على تكهف المضخة بسبب انسداد المصفاة."
                    ),
                    expectedOutcome = Bilingual("Smooth hydraulic hum; no aeration or foam forming in hydraulic reservoir", "शांत आवाज; टैंक में कोई झाग या बुलबुले न बनना", "صوت هيدروليكي ناعم بدون رغوة أو فقاعات في الخزان"),
                    remedyIfFailed = Bilingual("Remove and wash stainless suction strainer inside hydraulic tank with clean diesel", "टैंक के अंदर की सक्शन जाली निकालकर डीजल से धोएं", "فك مصفاة الشفط المعدنية داخل الخزان واغسلها بديزل نظيف")
                ),
                DiagnosticStep(
                    stepNumber = 3,
                    title = Bilingual("Main Relief Valve (MRV) Pressure Gauge Test", "मेन रिलीफ वॉल्व (MRV) प्रेशर गेज टेस्ट", "فحص ضغط صمام التنفيس الرئيسي بالساعة"),
                    procedure = Bilingual(
                        en = "Connect 0-400 bar gauge to pump delivery test point. Stall bucket crowd lever at full 1500 RPM.",
                        hi = "पंप के टेस्ट पोर्ट पर 400 बार का गेज लगाएं। 1500 RPM पर बकेट लीवर को पूरा खींचकर रोकें।",
                        ar = "وصّل ساعة 0-400 بار بمنفذ فحص المضخة وأمسك ذراع البوكت لنهاية الشوط عند 1500 RPM."
                    ),
                    expectedOutcome = Bilingual("Pressure needle snaps instantly to 230 - 250 bar specification", "गेज की सुई तुरंत 230 से 250 बार पर जानी चाहिए", "يرتفع المؤشر فوراً إلى 230 - 250 بار حسب الطراز"),
                    remedyIfFailed = Bilingual("Adjust MRV screw or remove cartridge to clean debris from relief seat; if pressure stays low, replace pump", "MRV वाल्व साफ व सेट करें; यदि दबाव फिर भी कम रहे तो पंप बदलें", "نظف واضبط صمام التنفيس MRV؛ إذا بقي الضغط منخفضاً فالمضخة تالفة")
                )
            ),
            commonMistakes = Bilingual(
                en = "Never over-tighten MRV adjusting screw above 260 bar in an attempt to get more digging force; this ruptures hydraulic hoses and cracks cylinder barrels.",
                hi = "ज्यादा ताकत के लालच में MRV स्क्रू को 260 बार से ऊपर कभी न कसें; इससे पाइप फट जाते हैं और सिलेंडर फट सकता है।",
                ar = "تحذير: لا ترفع ضغط صمام التنفيس فوق 260 بار لزيادة القوة؛ فذلك يفجّر الخراطيم ويُتلف أسطوانات البساتم."
            ),
            manualRef = "JCB Service Manual Section E (Hydraulic Pressure Setting)"
        ),
        DiagnosticGuide(
            id = "diag_engine_overheating",
            category = "Cooling System Faults",
            title = Bilingual(
                en = "Engine Overheating Under Heavy Working Load",
                hi = "भारी काम में इंजन का अत्यधिक गर्म होना (ओवरहीटिंग)",
                ar = "ارتفاع حرارة المحرك أثناء العمل الشاق"
            ),
            overview = Bilingual(
                en = "Covers radiator core clogging, fan belt slippage, thermostat sticking, water pump impeller wear, and head gasket blow-by checks.",
                hi = "रेडिएटर जाली बंद होना, फैन बेल्ट ढीली होना, थर्मोस्टेट जाम होना और हेड गैस्केट लीकेज की पूरी जांच।",
                ar = "يغطي فحص انسداد الرديتر، ارتخاء السير، تعليق الثرموستات، تآكل طرمبة الماء، ووجه الرأس."
            ),
            symptomChecks = listOf(
                DiagnosticStep(
                    stepNumber = 1,
                    title = Bilingual("Inspect Radiator Fins with Flashlight", "टॉर्च से रेडिएटर की जालियां देखना", "فحص زعانف الرديتر بالكشاف"),
                    procedure = Bilingual(
                        en = "Shine strong flashlight from behind the radiator core. Verify light passes cleanly through both oil cooler and water radiator fins.",
                        hi = "रेडिएटर के पीछे टॉर्च जलाकर देखें कि रोशनी दूसरी तरफ साफ निकल रही है या धूल-मिट्टी जमी है।",
                        ar = "سلّط كشافاً قوياً خلف قلب الرديتر وتأكد من مرور الضوء بوضوح عبر المبرد والرديتر."
                    ),
                    expectedOutcome = Bilingual("Fins 100% open and clear of straw, dust, grass, and mud cake", "जाली पूरी खुली हो; पुआल, घास या मिट्टी न फंसी हो", "الممرات مفتوحة تماماً وخالية من القش والغبار والطين"),
                    remedyIfFailed = Bilingual("Blow out dry dust with compressed air first, then wash gently from engine side outwards", "पहले सूखी हवा से धूल उड़ाएं, फिर इंजन की तरफ से बाहर की ओर पानी से धोएं", "انفخ الغبار الجاف بالهواء أولاً ثم اغسل بلطف من جهة المحرك للخارج")
                ),
                DiagnosticStep(
                    stepNumber = 2,
                    title = Bilingual("Thermostat Valve & Upper/Lower Hose Temperature", "थर्मोस्टेट और ऊपर-नीचे की पाइप का तापमान", "فحص البلف الحراري (الثرموستات) وخراطيم الرديتر"),
                    procedure = Bilingual(
                        en = "Warm engine to 80°C. Feel top radiator hose and bottom return hose with gloves or laser thermometer.",
                        hi = "इंजन गर्म होने पर ऊपर और नीचे वाली मोटी रबर पाइप को छूकर तापमान देखें।",
                        ar = "سخّن المحرك إلى 80°C وقس حرارة الخرطوم العلوي والسفلي بالترمومتر أو باليد مع قفازات."
                    ),
                    expectedOutcome = Bilingual("Both top and bottom hoses become uniformly hot (indicates thermostat opened ~82°C)", "दोनों पाइप लगभग बराबर गर्म होनी चाहिए (थर्मोस्टेट 82°C पर खुल चुका हो)", "يسخن الخرطومان بدرجة متقاربة مما يدل على فتح الثرموستات عند 82°C"),
                    remedyIfFailed = Bilingual("If top hose is boiling hot but bottom hose remains lukewarm, thermostat is stuck shut; replace thermostat", "ऊपर की पाइप उबल रही हो और नीचे की ठंडी रहे तो थर्मोस्टेट जाम है; नया थर्मोस्टेट लगाएं", "إذا كان العلوي يغلي والسفلي بارداً فالثرموستات عالق مغلق؛ يجب استبداله")
                ),
                DiagnosticStep(
                    stepNumber = 3,
                    title = Bilingual("Combustion Gas Test (Head Gasket Check)", "हेड गैस्केट लीकेज और बुलबुले की जांच", "فحص تسريب غازات الاحتراق (وجه رأس الأسطوانة)"),
                    procedure = Bilingual(
                        en = "Remove radiator cap when cold. Start engine and accelerate to 1500 RPM while observing coolant neck.",
                        hi = "ठंडे इंजन में रेडिएटर का ढक्कन खोलें। इंजन स्टार्ट करके रेस दें और मुंह में देखें।",
                        ar = "افتح غطاء الرديتر والمحرك بارد، شغّل وارفع الدوران إلى 1500 RPM وراقب عنق التعبئة."
                    ),
                    expectedOutcome = Bilingual("Gentle fluid circulation without violent bubbling or erupting coolant spray", "शांत बहाव; कोई तेज बुलबुले या फव्वारा न फूटना", "دوران هادئ للسائل بدون فوران أو فقاعات مستمرة"),
                    remedyIfFailed = Bilingual("Violent continuous gas bubbles indicate cylinder head gasket blown or cracked head", "लगातार तेज बुलबुले आने पर हेड गैस्केट जल चुका है; हेड खोलना पड़ेगा", "الفقاعات العنيفة المستمرة تدل على تلف وجه رأس المحرك أو وجود شرخ")
                )
            ),
            commonMistakes = Bilingual(
                en = "NEVER pour cold tap water directly into an overheated engine radiator; thermal shock cracks the cast iron cylinder block instantly.",
                hi = "गर्म उबलते इंजन में कभी अचानक ठंडा पानी न डालें; इससे लोहे का इंजन ब्लॉक तुरंत चटक जाता है।",
                ar = "تحذير: لا تصب الماء البارد أبداً في رديتر محرك ساخن جداً لأن الصدمة الحرارية تشق كتلة المحرك فوراً."
            ),
            manualRef = "JCB EcoMAX Cooling Maintenance Guide Section B-4"
        )
    )
}
