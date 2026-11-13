package com.example.data

import com.example.model.*

object JcbTrainingDatabase {

    val lessons: List<TrainingLesson> = listOf(
        TrainingLesson(
            id = "train_daily_inspection",
            title = Bilingual(
                en = "Daily Walkaround Machine Inspection (10-Minute Pre-Shift)",
                hi = "दैनिक मशीन निरीक्षण (काम शुरू करने से पहले 10 मिनट की जांच)",
                ar = "الفحص اليومي الشامل قبل بدء العمل (10 دقائق)"
            ),
            category = Bilingual("Daily Routine", "दैनिक नियम", "الروتين اليومي"),
            estimatedMinutes = 10,
            level = TrainingLevel.BEGINNER_OPERATOR,
            audioScript = Bilingual(
                en = "Welcome to the JCB Daily Walkaround Pre-Shift Training. Before starting your machine each morning, walk around the machine clockwise. Check tyre pressure, inspect loader pins, inspect underneath for oil drips, check engine oil dipstick and water separator.",
                hi = "जेसीबी दैनिक वॉकअराउंड ट्रेनिंग में आपका स्वागत है। रोज सुबह काम शुरू करने से पहले मशीन के चारों तरफ घूमें। टायर की हवा, सभी पिंस, नीचे तेल का टपकना, इंजन ऑयल गेज और डीजल वाटर सेपरेटर की जांच अवश्य करें।",
                ar = "مرحباً بكم في تدريب الفحص اليومي لمعدات JCB. قبل تشغيل المعدة كل صباح، قم بجولة حولها لفحص ضغط الإطارات، ومسامير اللودر، والتأكد من عدم وجود تسريبات زيت أسفلها، وفحص مقياس زيت المحرك وفاصل الماء عن الديزل."
            ),
            toolsRequired = listOf(
                Bilingual("Clean wiping rag", "साफ सूती कपड़ा", "قطعة قماش نظيفة للمسح"),
                Bilingual("Flashlight for undercarriage inspection", "टॉर्च", "كشاف إضاءة لفحص أسفل المعدة"),
                Bilingual("Tyre pressure gauge (up to 50 psi)", "टायर प्रेशर गेज", "ساعة قياس ضغط الإطارات (حتى 50 PSI)"),
                Bilingual("Safety helmet & steel-toe boots", "सुरक्षा हेलमेट और सेफ्टी जूते", "خوذة سلامة وحذاء واقٍ بمقدمة حديدية")
            ),
            steps = listOf(
                TrainingStep(
                    stepIndex = 1,
                    title = Bilingual("Park Machine on Level Firm Ground", "समतल जमीन पर मशीन पार्क करना", "إيقاف المعدة على أرض مستوية وصلبة"),
                    description = Bilingual(
                        en = "Lower front shovel flat to the ground and rest backhoe bucket teeth in the dirt. Engage parking brake and turn off engine.",
                        hi = "लोडर और बकेट को जमीन पर टिकाएं, हैंडब्रेक लगाएं और इंजन बंद करें।",
                        ar = "أنزل الجرافة الأمامية على الأرض وثبّت أسنان قادوس الحفار الخلفي، واسحب فرامل اليد وأطفئ المحرك."
                    ),
                    keyCaution = Bilingual("Never check fluid levels on steep slopes.", "ढलान पर कभी भी ऑयल लेवल न नापें।", "لا تقس مستويات الزيوت على أرض مائلة أبداً.")
                ),
                TrainingStep(
                    stepIndex = 2,
                    title = Bilingual("Engine Oil Dipstick Check", "इंजन ऑयल गेज की जांच", "فحص عيار زيت المحرك"),
                    description = Bilingual(
                        en = "Pull engine oil dipstick, wipe completely clean with lint-free cloth, re-insert fully, and withdraw again. Oil level must be between the cross-hatched MAX and MIN marks.",
                        hi = "गेज खींचें, कपड़े से पोंछकर दोबारा पूरा अंदर डालें और निकालें। तेल का निशान MIN और MAX के बीच होना चाहिए।",
                        ar = "اسحب سيخ عيار الزيت وامسحه جيداً ثم أعد إدخاله بالكامل واسحبه؛ يجب أن يكون الزيت بين علامتي MIN و MAX."
                    ),
                    keyCaution = Bilingual("If below MIN, top up with JCB 15W-40 CI-4 engine oil.", "यदि MIN से कम हो तो 15W-40 ऑयल डालें।", "إذا كان أقل من MIN فأضف زيت محرك 15W-40 CI-4.")
                ),
                TrainingStep(
                    stepIndex = 3,
                    title = Bilingual("Drain Water Separator Bowl", "डीजल वाटर सेपरेटर से पानी निकालना", "تصريف الماء من فاصل الديزل"),
                    description = Bilingual(
                        en = "Locate transparent glass or plastic sedimenter bowl under fuel filter. Turn bottom thumbscrew drain anticlockwise until water and sludge drain out and clean diesel begins to flow.",
                        hi = "डीजल फिल्टर के नीचे लगे शीशे के कटोरे का पेंच ढीला करें और जमा पानी व कचरा बाहर निकालें।",
                        ar = "افتح مسمار التصريف أسفل الكوب الشفاف لفلتر الوقود حتى يخرج الماء والرواسب ويبدأ الديزل النقي بالتدفق."
                    ),
                    keyCaution = Bilingual("Water in diesel destroys common rail injectors quickly.", "डीजल में पानी इंजेक्टरों को तुरंत खराब कर देता है।", "وجود الماء في الديزل يدمر البخاخات سريعاً.")
                ),
                TrainingStep(
                    stepIndex = 4,
                    title = Bilingual("Inspect Hydraulic Cylinders & Hoses", "हाइड्रोलिक सिलेंडर और पाइपों की जांच", "فحص أسطوانات وخراطيم الهيدروليك"),
                    description = Bilingual(
                        en = "Inspect all 8 hydraulic cylinders for chrome scoring, pin looseness, and hose abrasion where rubber rubs against metal brackets.",
                        hi = "सभी सिलेंडरों की रॉड, पिनों का ढीलापन और पाइपों का घिसना चेक करें।",
                        ar = "افحص أعمدة الكروم في جميع الأسطوانات بحثاً عن الخدوش، وتأكد من إحكام البنوز وسلامة الخراطيم من الاحتكاك."
                    )
                ),
                TrainingStep(
                    stepIndex = 5,
                    title = Bilingual("Tyre Pressure & Wheel Nut Torque", "टायर प्रेशर और पहियों के नट की जांच", "فحص ضغط الإطارات وصواميل العجلات"),
                    description = Bilingual(
                        en = "Check front tyres (standard 35-40 psi) and rear heavy tyres (standard 28-32 psi). Look for embedded stones or cuts. Visually verify all wheel nuts are present.",
                        hi = "आगे के टायर में 35-40 psi और पीछे के टायर में 28-32 psi हवा चेक करें। पहियों के सभी नट चेक करें।",
                        ar = "افحص ضغط الإطارات الأمامية (35-40 PSI) والخلفية (28-32 PSI) وتأكد من سلامة الصواميل."
                    )
                )
            ),
            safetyChecklist = listOf(
                Bilingual("High-visibility vest and steel-toe safety footwear worn", "सुरक्षा जैकेट और सेफ्टी जूते पहने हों", "ارتداء سترة عاكسة وحذاء سلامة"),
                Bilingual("Chassis isolation key (battery isolator) turned ON", "बैटरी कट-ऑफ स्विच चालू हो", "تفعيل مفتاح عزل البطارية الرئيسي"),
                Bilingual("Rear reversing beeper and horn functional", "बैक हॉर्न और मेन हॉर्न चालू हो", "عمل صافرة الرجوع للخلف والبوري بشكل سليم")
            ),
            fluidCapacitiesOrTorque = Bilingual(
                en = "Engine Oil Sump: ~14.5 Litres | Front Wheel Nuts: 300 Nm | Rear Wheel Nuts: 560 Nm",
                hi = "इंजन ऑयल क्षमता: ~14.5 लीटर | अगले पहिए के नट: 300 Nm | पिछले पहिए के नट: 560 Nm",
                ar = "سعة زيت المحرك: ~14.5 لتر | عزم صواميل الأمام: 300 Nm | صواميل الخلف: 560 Nm"
            )
        ),
        TrainingLesson(
            id = "train_greasing_points",
            title = Bilingual(
                en = "Greasing Points & Lubrication Schedule (32 Grease Nipples)",
                hi = "ग्रीसिंग पॉइंट्स और लुब्रिकेशन गाइड (32 ग्रीस निप्पल)",
                ar = "نقاط التشحيم وجدول التزييت (32 مشحمة)"
            ),
            category = Bilingual("Lubrication Routine", "ग्रीसिंग नियम", "جدول التشحيم"),
            estimatedMinutes = 20,
            level = TrainingLevel.BEGINNER_OPERATOR,
            audioScript = Bilingual(
                en = "Proper greasing extends the life of JCB pins and bushes by years. Use heavy-duty lithium complex grease with 3% Molybdenum disulphide. Pump grease until fresh clean grease squeezes out of the bush edge, pushing old dirt out.",
                hi = "सही ग्रीसिंग से पिन और बुश की उम्र कई साल बढ़ जाती है। हमेशा लिथियम कॉम्प्लेक्स मॉलीबडेनम ग्रीस का प्रयोग करें। तब तक ग्रीस गन मारें जब तक पुराना कचरा निकलकर नया ग्रीस बाहर न दिखने लगे।",
                ar = "التشحيم الصحيح يطيل عمر البنوز والجلب لسنوات. استخدم شحم الليثيوم مع 3% موليبدينوم، واضغط بالمشحمة حتى يخرج الشحم النظيف ويطرد الأتربة القديمة."
            ),
            toolsRequired = listOf(
                Bilingual("High-pressure manual or pneumatic grease gun", "हाई प्रेशर ग्रीस गन", "مشحمة يدوية أو هوائية عالية الضغط"),
                Bilingual("JCB Special Multipurpose EP Grease (NLGI-2 with Moly)", "जेसीबी ईपी ग्रीस (NLGI-2)", "شحم JCB متعدد الأغراض NLGI-2"),
                Bilingual("Nipple cleaning wire pick and rags", "निप्पल साफ करने का तार और कपड़ा", "قطعة قماش وسلك لتنظيف حلمات التشحيم"),
                Bilingual("Spare M8 and M10 grease nipples and wrench", "अतिरिक्त ग्रीस निप्पल और 10mm चाबी", "مشاحم احتياطية M8/M10 ومفتاح 10 مم")
            ),
            steps = listOf(
                TrainingStep(
                    stepIndex = 1,
                    title = Bilingual("Clean Every Grease Nipple First", "निप्पल को पहले कपड़े से साफ करना", "تنظيف رأس كل مشحمة أولاً"),
                    description = Bilingual(
                        en = "Wipe external dirt and mud completely off nipple head before snapping grease gun coupler on; otherwise sand is pumped straight into precision bronze bushes.",
                        hi = "ग्रीस गन लगाने से पहले निप्पल के ऊपर लगी मिट्टी को अच्छी तरह पोंछें ताकि रेत अंदर न जाए।",
                        ar = "امسح الطين والغبار من رأس المشحمة قبل تركيب فوهة التشحيم لمنع دفع الرمل داخل الجلب."
                    )
                ),
                TrainingStep(
                    stepIndex = 2,
                    title = Bilingual("Front Loader Linkage Points (10 Points)", "फ्रंट लोडर लिंकेज के 10 पॉइंट्स", "نقاط ذراع المحمل الأمامي (10 نقاط)"),
                    description = Bilingual(
                        en = "Grease lower shovel pivot pins, bucket crowd ram pins, lift ram lower and upper trunnions, and self-leveling leveling link pivots (give 4-6 pumps each daily).",
                        hi = "लोडर बकेट की पिन, क्राउड सिलेंडर, लिफ्ट सिलेंडर और लेवलिंग लिंक में रोज 4-6 पम्प ग्रीस मारें।",
                        ar = "شحّم بنوز الجرافة وبساتم الرفع والتفريغ ووصلات الموازنة يومياً بمقدار 4-6 ضغطات."
                    )
                ),
                TrainingStep(
                    stepIndex = 3,
                    title = Bilingual("Backhoe Kingpost & Slew Actuators (8 Points)", "बैकहो किंगपोस्ट और स्विंग पिन (8 पॉइंट्स)", "نقاط الكينج بوست وبساتم الدوران الخلفية (8 نقاط)"),
                    description = Bilingual(
                        en = "Grease top and bottom massive Kingpost pivot pins and slew cylinder ball rod ends. These handle intense twisting leverage during trench swinging.",
                        hi = "किंगपोस्ट की ऊपर और नीचे की बड़ी पिनों तथा स्विंग सिलेंडरों में भरपूर ग्रीस दें क्योंकि इन पर सबसे ज्यादा जोर पड़ता है।",
                        ar = "شحّم بنوز الكينج بوست العلوية والسفلية وأطراف بساتم الدوران لأنها تتحمل أعلى إجهاد التوائي."
                    )
                ),
                TrainingStep(
                    stepIndex = 4,
                    title = Bilingual("Boom, Dipper & Bucket Linkage (10 Points)", "बूम, डिपर और बकेट लिंकेज (10 पॉइंट्स)", "نقاط البوم والذراع والقادوس الخلفي (10 نقاط)"),
                    description = Bilingual(
                        en = "Lubricate boom pivot pin, dipper cylinder pins, tipping link 'dog-bone' pins, and bucket pivot pins. Digging in water requires greasing twice daily.",
                        hi = "बूम पिन, डिपर पिन और बकेट डॉग-बोन लिंकेज में ग्रीस दें। पानी या कीचड़ में काम करने पर दिन में दो बार ग्रीस करें।",
                        ar = "شحّم بنوز البوم والديبر ووصلة القادوس. عند العمل في الماء أو الطين شحّم مرتين يومياً."
                    )
                ),
                TrainingStep(
                    stepIndex = 5,
                    title = Bilingual("Front 4WD Steer Axle & Prop Shafts (4 Points)", "आगे का 4WD एक्सल और प्रोपेलर शाफ्ट (4 पॉइंट्स)", "محور التوجيه الأمامي وأعمدة الكردان (4 نقاط)"),
                    description = Bilingual(
                        en = "Grease front axle centre pivot trunnion pin, left and right steer knuckle kingpins, and drive shaft universal cross-joints (every 50 hours).",
                        hi = "आगे के एक्सल की सेंटर पिन, स्टीयरिंग नकल और प्रोपेलर शाफ्ट के क्रॉस में हर 50 घंटे पर ग्रीस भरें।",
                        ar = "شحّم مسمار الارتكاز الأوسط للمحور الأمامي ومفاصل التوجيه وصليبات عمود الدوران كل 50 ساعة."
                    )
                )
            ),
            safetyChecklist = listOf(
                Bilingual("Never stand under unsupported backhoe arm while greasing", "ग्रीस करते समय बूम के नीचे कभी न खड़े हों", "لا تقف أبداً تحت ذراع حفار غير مسند أثناء التشحيم"),
                Bilingual("Always use safety strut on raised loader arm before greasing lower loader pins", "लोडर आर्म उठाकर ग्रीस करने से पहले सेफ्टी लॉक ब्रैकेट जरूर लगाएं", "ركّب دعامة الأمان قبل العمل تحت ذراع المحمل المرفوع")
            ),
            fluidCapacitiesOrTorque = Bilingual(
                en = "Recommended Grease: JCB HP Grease / Castrol Spheerol EPL2 (Lithium base)",
                hi = "अनुशंसित ग्रीस: जेसीबी एचपी ग्रीस या कैस्ट्रॉल EPL2 (लिथियम बेस)",
                ar = "الشحم الموصى به: JCB HP Grease أو شحم ليثيوم EP2 مع موليبدينوم"
            )
        ),
        TrainingLesson(
            id = "train_engine_oil_change",
            title = Bilingual(
                en = "Engine Oil & Oil Filter Replacement (500-Hour Service)",
                hi = "इंजन ऑयल और ऑयल फिल्टर बदलना (500 घंटे की सर्विस)",
                ar = "تغيير زيت المحرك والفلتر (صيانة كل 500 ساعة)"
            ),
            category = Bilingual("Preventive Maintenance", "नियमित सर्विस", "الصيانة الوقائية"),
            estimatedMinutes = 35,
            level = TrainingLevel.INTERMEDIATE_TECHNICIAN,
            audioScript = Bilingual(
                en = "Regular oil replacement every 500 hours is vital for JCB EcoMAX engines. Drain warm oil to ensure suspended soot particles drain away. Always pre-fill the new oil filter with fresh oil to prevent dry friction wear upon restarting.",
                hi = "हर 500 घंटे में इंजन ऑयल बदलना अनिवार्य है। गर्म इंजन का ही तेल निकालें ताकि सारा कचरा बाहर आ जाए। नए फिल्टर को लगाने से पहले उसमें नया तेल जरूर भरें ताकि स्टार्ट करते ही इंजन को तुरंत चिकनाई मिले।",
                ar = "تغيير زيت المحرك كل 500 ساعة ضروري لحماية محركات JCB EcoMAX. فرّغ الزيت وهو دافئ لطرد الرواسب، واملأ الفلتر الجديد بزيت نظيف قبل تركيبه لتجنب التشغيل الجاف."
            ),
            toolsRequired = listOf(
                Bilingual("24mm / 27mm drain plug box wrench", "24mm/27mm ड्रेन प्लग पाना", "مفتاح صرة الزيت 24/27 مم"),
                Bilingual("20-Litre clean oil catch drain tub", "20 लीटर का तेल निकालने वाला टब", "حوض تجميع زيت سعة 20 لتر"),
                Bilingual("Chain or strap oil filter removal wrench", "ऑयल फिल्टर खोलने वाला पट्टा पाना", "مفتاح فك فلتر الزيت"),
                Bilingual("Genuine JCB Engine Oil (15W-40 CI-4 or CJ-4) 15 Litres", "15 लीटर ओरिजिनल जेसीबी 15W-40 इंजन ऑयल", "15 لتر زيت محرك 15W-40 CI-4/CJ-4 أصلي"),
                Bilingual("Genuine JCB Spin-on Oil Filter (Part 320/04133)", "जेसीबी ऑयल फिल्टर (पार्ट 320/04133)", "فلتر زيت محرك أصلي (رقم 320/04133)")
            ),
            steps = listOf(
                TrainingStep(
                    stepIndex = 1,
                    title = Bilingual("Warm Engine to 60°C and Park Safely", "इंजन को हल्का गर्म करके पार्क करना", "تدفئة المحرك إلى 60°C وإيقافه بأمان"),
                    description = Bilingual(
                        en = "Run engine for 5 minutes so oil thins and carbon soot is stirred up into suspension for complete draining. Turn off engine and remove keys.",
                        hi = "इंजन 5 मिनट चलाएं ताकि तेल पतला हो जाए और सारा कार्बन घुल जाए। फिर इंजन बंद करें।",
                        ar = "شغّل المحرك 5 دقائق لتقليل لزوجة الزيت وتعليق الرواسب، ثم أطفئه وانزع المفتاح."
                    )
                ),
                TrainingStep(
                    stepIndex = 2,
                    title = Bilingual("Drain Engine Sump Oil", "इंजन चैंबर से पुराना तेल निकालना", "تصريف الزيت القديم من الكارتير"),
                    description = Bilingual(
                        en = "Position drain tub under engine sump. Unscrew drain plug carefully. Allow oil to drain completely for at least 15 minutes.",
                        hi = "चैंबर के नीचे टब रखें। ड्रेन प्लग खोलें और कम से कम 15 मिनट तक पूरा तेल टपकने दें।",
                        ar = "ضع حوض التجميع أسفل الكارتير وفك صرة التفريغ بحذر واترك الزيت ينزل لمدة 15 دقيقة."
                    ),
                    keyCaution = Bilingual("Oil is hot; wear heavy neoprene heat gloves.", "तेल गर्म होता है, दस्ताने पहनकर काम करें।", "الزيت ساخن؛ ارتدِ قفازات واقية من الحرارة.")
                ),
                TrainingStep(
                    stepIndex = 3,
                    title = Bilingual("Clean Magnetic Drain Plug & Refit with New Washer", "ड्रेन प्लग साफ करके नया वाशर लगाना", "تنظيف صرة التصريف المغناطيسية وتركيب وردة جديدة"),
                    description = Bilingual(
                        en = "Inspect drain plug magnet for metal chips. Clean threads, install new copper crush washer, and torque to 60 Nm.",
                        hi = "प्लग के चुंबक से लोहे के बारीक कण साफ करें। नया तांबे का वाशर लगाकर 60 Nm पर टाइट करें।",
                        ar = "نظف مغناطيس الصرة من أي برادة، ركّب وردة نحاسية جديدة واشددها بعزم 60 نيوتن.متر."
                    )
                ),
                TrainingStep(
                    stepIndex = 4,
                    title = Bilingual("Replace Spin-on Oil Filter", "नया ऑयल फिल्टर लगाना", "استبدال فلتر الزيت الجديد"),
                    description = Bilingual(
                        en = "Unscrew old oil filter with strap wrench. Clean mounting head. Fill new filter 80% full with fresh clean oil. Lubricate rubber O-ring seal with oil. Spin on by hand until seal touches, then tighten exactly 3/4 turn further by hand (do NOT use wrench to tighten).",
                        hi = "पुराना फिल्टर खोलें। नए फिल्टर में 80% नया तेल भरें। रबड़ के छल्ले पर तेल लगाएं। हाथ से चूड़ी चढ़ाएं और छूने के बाद हाथ से ही 3/4 चक्कर और टाइट करें (पाने से न कसें)।",
                        ar = "فك الفلتر القديم ونظف القاعدة، املأ الفلتر الجديد بنسبة 80% بزيت نظيف وادهن الجلدة بالزيت، ثم اربطه باليد 3/4 لفة بعد التلامس."
                    )
                ),
                TrainingStep(
                    stepIndex = 5,
                    title = Bilingual("Refill Fresh Oil & Verify Oil Pressure", "नया तेल भरना और ऑयल प्रेशर जांचना", "تعبئة الزيت الجديد وفحص ضغط الزيت"),
                    description = Bilingual(
                        en = "Pour 14 Litres of genuine JCB 15W-40 oil via valve cover filler cap. Start engine; red oil pressure light MUST extinguish within 4 seconds. Idle for 2 minutes, shut off, wait 5 minutes, and adjust level to MAX mark.",
                        hi = "ढक्कन खोलकर 14 लीटर 15W-40 तेल डालें। स्टार्ट करें; 4 सेकंड के अंदर लाल ऑयल बत्ती बुझ जानी चाहिए। 2 मिनट चलाकर बंद करें और 5 मिनट बाद गेज से नापकर पूरा करें।",
                        ar = "عبئ 14 لتراً من زيت 15W-40، شغّل المحرك وتأكد من انطفاء لمبة ضغط الزيت خلال 4 ثوانٍ، ثم أوقف وأكمل المستوى بعد 5 دقائق."
                    )
                )
            ),
            safetyChecklist = listOf(
                Bilingual("Dispose of used oil responsibly at certified recycling collection centre", "पुराना जला हुआ तेल पर्यावरण में न फेंकें", "تخلص من الزيت المستعمل في مراكز التدوير المعتمدة"),
                Bilingual("Double-check filter seal for zero leaks with engine idling", "स्टार्ट करके फिल्टर के किनारे से कोई लीकेज न हो यह जांचें", "افحص عدم وجود أي تسريب حول الفلتر أثناء دوران المحرك")
            ),
            fluidCapacitiesOrTorque = Bilingual(
                en = "Engine Oil Sump Capacity: 14.5 Litres | Drain Plug Torque: 60 Nm",
                hi = "इंजन ऑयल क्षमता: 14.5 लीटर | ड्रेन प्लग टॉर्क: 60 Nm",
                ar = "سعة كارتير المحرك: 14.5 لتر | عزم صرة التفريغ: 60 نيوتن.متر"
            )
        )
    )
}
