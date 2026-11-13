package com.example.data

import com.example.R
import com.example.model.*

internal object JcbPartsGroupB {

    val parts: List<JcbPart> = listOf(
        // 7. COOLING SYSTEM
        JcbPart(
            id = "part_radiator",
            partNumber = "30/926900 / 333/D0720 (Verify Cooling Pack)",
            system = SystemCategory.COOLING,
            nameEn = "Radiator",
            nameHi = "रेडिएटर",
            nameAr = "المُبرِّد (الرادياتير)",
            imageResId = R.drawable.img_part_radiator,
            supportedModels = listOf("JCB 3CX", "JCB 4CX", "JCB 3DX", "JCB 5CX", "CAT Backhoe"),
            modelDifferences = listOf(
                Bilingual(
                    en = "Tier 3/4 JCB 3CX & 4CX combine aluminum coolant radiator, intercooler (CAC), and hydraulic oil cooler in a stacked cooling pack; older 3DX uses separate brass/aluminum core.",
                    hi = "नए 3CX/4CX में रेडिएटर, इंटरकूलर और ऑयल कूलर एक साथ स्टैक पैक में होते हैं, जबकि पुराने 3DX में अलग रेडिएटर कोर होता है।",
                    ar = "تجمع JCB 3CX و4CX الحديثة بين الرادياتير ومبرد الهواء ومبرد الزيت الهيدروليكي في حزمة متكاملة، بينما تستخدم 3DX القديمة قلباً مستقلاً."
                )
            ),
            viewAngles = listOf(
                PartViewAngle(
                    Bilingual("Top Neck & Pressure Cap", "ऊपरी नेक व प्रेशर कैप", "الفتحة العلوية وغطاء الضغط"),
                    Bilingual("Pressurizes cooling system (~0.9–1.1 bar) to raise coolant boiling point.", "सिस्टम में दबाव बनाकर कूलेंट को उबलने से रोकता है।", "يرفع ضغط النظام لزيادة درجة غليان سائل التبريد.")
                ),
                PartViewAngle(
                    Bilingual("Core Fins & Lower Outlet", "जाली फिन्स व निचला आउटलेट", "زعانف التبريد والمخرج السفلي"),
                    Bilingual("Thin aluminum/copper fins transfer engine heat into airflow.", "पतली जालियां पानी की गर्मी को पंखे की हवा में छोड़ती हैं।", "تنقل الزعانف الرقيقة الحرارة إلى تيار هواء المروحة.")
                )
            ),
            location = Bilingual(
                en = "Mounted upright at the very front of the engine bay directly behind the front grille and cooling fan.",
                hi = "इंजन के सबसे आगे फ्रंट जाली और कूलिंग पंखे के ठीक सामने खड़ा लगा होता है।",
                ar = "مثبت في مقدمة حجرة المحرك مباشرة خلف الشبكة الأمامية ومروحة التبريد."
            ),
            workingPrinciple = Bilingual(
                en = "Heat-exchanger core circulating hot engine coolant through hundreds of thin finned tubes cooled by high-velocity airflow pulled by the engine fan, rejecting combustion heat to atmosphere.",
                hi = "इंजन से आया गर्म कूलेंट सैकड़ों पतली नलियों से गुजरता है, जहाँ पंखे की तेज हवा इसकी गर्मी को बाहर निकालकर इंजन का तापमान ~85°C पर बनाए रखती है।",
                ar = "مبادل حراري يمرر سائل التبريد الساخن عبر أنابيب وزعانف رقيقة لتبديد الحرارة عبر هواء المروحة والحفاظ على حرارة التشغيل المثالية."
            ),
            damageSymptoms = listOf(
                Bilingual("Engine coolant temperature warning light / gauge climbing into red", "इंजन ओवरहीट होना और तापमान की सुई लाल निशान पर जाना", "ارتفاع مؤشر حرارة المحرك للمنطقة الحمراء"),
                Bilingual("Green/pink coolant stains, dripping fins, or steam from front grille", "रेडिएटर जाली से कूलेंट टपकना या भाप निकलना", "آثار تسرب سائل التبريد أو تصاعد بخار من الشبكة الأمامية"),
                Bilingual("External fins choked with dust, straw, oil mist, or mud cake", "धूल, भूसे या तेल-मिट्टी से जालियों का बंद हो जाना", "انسداد الزعانف الخارجية بالأتربة والقش والطين")
            ),
            inspectionProcedure = listOf(
                Bilingual("Shine flashlight through radiator fins from engine side to inspect airflow blockage", "अंदर से टॉर्च जलाकर देखें कि जाली आर-पार साफ दिख रही है या बंद है", "سلط مصباحاً خلف الزعانف للتأكد من مرور الهواء وعدم انسدادها"),
                Bilingual("Pressure-test cold cooling system & radiator cap using hand pressure tester", "ठंडे रेडिएटर व ढक्कन का प्रेशर टेस्टर से लीकेज चेक करें", "اختبر ضغط المبرد والغطاء والنظام بارد لكشف أي تسربات"),
                Bilingual("Check fan shroud integrity and upper/lower rubber hoses for soft rot or cracks", "ऊपरी-नीचे की रबर पाइपों और फैन कवर की जांच करें", "افحص خراطيم المطاط العلوية والسفلية وغطاء المروحة")
            ),
            repairInstructions = listOf(
                Bilingual("Blow compressed air gently FROM ENGINE SIDE OUTWARDS to clear chaff/dust without bending fins", "हमेशा इंजन की तरफ से बाहर की ओर हवा मारें ताकि जालियां न मुड़ें", "انفخ الهواء المضغوط من جهة المحرك نحو الخارج برفق لتجنب ثني الزعانف"),
                Bilingual("Refill ONLY with 50/50 clean soft/distilled water + genuine OAT coolant (never plain hard tap water)", "हमेशा 50/50 डिस्टिल्ड वाटर और ओरिजिनल कूलेंट मिलाएं, खारा पानी न डालें", "عبئ دائماً خليط 50/50 من الماء المقطر وسائـل التبريد الأصلي OAT"),
                Bilingual("Bleed trapped air pocket at thermostat bleed point after refilling", "नया कूलेंट भरने के बाद सिस्टम की हवा पूरी तरह निकालें", "فرّغ الهواء المحبوس في دائرة التبريد بعد إعادة التعبئة")
            ),
            safetyWarning = Bilingual(
                en = "DANGER: NEVER open a hot radiator cap! Pressurized boiling coolant erupts violently causing severe scalding burns.",
                hi = "खतरा: गर्म इंजन में रेडिएटर का ढक्कन कभी न खोलें! उबलता पानी फव्वारे की तरह चेहरे पर आ सकता है।",
                ar = "خطر: لا تفتح غطاء المبرد والمحرك ساخن أبداً! اندفاع السائل المغلي المضغوط يسبب حروقاً بالغة."
            ),
            torqueSpec = "Mounting Cushions & Fan Bolts: snug to OEM spec | Hose Clamps: secure without cutting rubber",
            diagramPoints = listOf(
                DiagramPoint(1, "Aluminum Tube & Fin Core", "कूलिंग ट्यूब व जाली कोर", "Transfers heat from coolant to airflow", "कूलेंट की गर्मी हवा में छोड़ने वाला कोर", "قلب الأنابيب والزعانف", "ينقل الحرارة من السائل إلى الهواء"),
                DiagramPoint(2, "Pressure Filler Neck & Cap", "प्रेशर कैप व नेक", "Maintains ~1.0 bar boiling protection", "सिस्टम का दबाव बनाए रखने वाला ढक्कन", "عنق التعبئة وغطاء الضغط", "يحافظ على ضغط النظام لمنع الغليان"),
                DiagramPoint(3, "Top Hot Coolant Inlet", "ऊपरी गर्म पानी इनलेट", "Receives hot water from thermostat", "थर्मोस्टेट से गर्म पानी आने का मुंह", "مدخل السائل الساخن العلوي", "يستقبل السائل الساخن من الثيرموستات"),
                DiagramPoint(4, "Bottom Cooled Outlet", "निचला ठंडा पानी आउटलेट", "Feeds cooled coolant to water pump", "ठंडा पानी वापस वॉटर पंप को भेजता है", "مخرج السائل المبرد السفلي", "يعيد السائل المبرد إلى مضخة المياه")
            ),
            manualReference = "JCB Service Manual Section B-4 (Cooling System)"
        ),

        JcbPart(
            id = "part_water_pump",
            partNumber = "320/04542 / 02/202490 (Match Impeller & Pulley)",
            system = SystemCategory.COOLING,
            nameEn = "Water Pump",
            nameHi = "वॉटर पंप",
            nameAr = "مضخة المياه",
            imageResId = R.drawable.img_part_water_pump,
            supportedModels = listOf("JCB 3CX", "JCB 4CX", "JCB 3DX", "JCB 5CX", "CAT Backhoe"),
            modelDifferences = listOf(
                Bilingual(
                    en = "Gear-driven or external belt-driven depending on JCB 444 vs Perkins/CAT C4.4 engine serial.",
                    hi = "JCB 444, Perkins और CAT इंजन के अनुसार वॉटर पंप बेल्ट-ड्रिवेन या गियर-ड्रिवेन हो सकता है।",
                    ar = "تختلف المضخة بين الإدارة بالسير أو بالتروس حسب طراز المحرك ورقمه التسلسلي."
                )
            ),
            location = Bilingual(
                en = "Bolted directly to the front timing cover / cylinder block driven by the fan belt or timing gear.",
                hi = "इंजन ब्लॉक के सामने की ओर फैन पुली या टाइमिंग गियर के पास लगा होता है।",
                ar = "مثبتة على مقدمة كتلة المحرك أو غطاء التوقيت وتُدار بالسير أو التروس."
            ),
            workingPrinciple = Bilingual(
                en = "Centrifugal impeller spins continuously with the engine to circulate coolant from the radiator bottom tank through engine cylinder liners, head passages, and cabin heater core.",
                hi = "इंजन के साथ इसका इम्पेलर घूमकर रेडिएटर से ठंडा कूलेंट खींचता है और पूरे इंजन ब्लॉक व सिलेंडर हेड में लगातार घुमाता है।",
                ar = "تستخدم مروحة طرد مركزي لتدوير سائل التبريد باستمرار من المبرد عبر قمصان الأسطوانات ورأس المحرك."
            ),
            damageSymptoms = listOf(
                Bilingual("Coolant weeping out of bottom housing 'weep hole' (failed mechanical seal)", "वॉटर पंप के नीचे छोटे सुराख (वीप होल) से पानी टपकना", "تسرب سائل التبريد من ثقب الفحص السفلي بالمضخة"),
                Bilingual("Wobbly fan pulley or grinding bearing growl from front of engine", "पुली का हिलना या बेयरिंग से घरघराहट की आवाज", "تخلخل بكرة المروحة أو صوت احتكاك من الرولمان"),
                Bilingual("Rapid overheating caused by corroded or slipped impeller blades", "अंदर की पंखुड़ी गल जाने से इंजन का तुरंत गर्म होना", "ارتفاع الحرارة السريع بسبب تآكل ريش المروحة الداخلية")
            ),
            inspectionProcedure = listOf(
                Bilingual("With belt slackened, grasp fan pulley and check for radial bearing wobble", "बेल्ट ढीली करके पुली को हिलाकर बेयरिंग प्ले जांचें", "بعد إرخاء السير، افحص وجود أي اهتزاز أو خلوص في بكرة المضخة"),
                Bilingual("Inspect weep hole underneath pump shaft snout for dried coolant crust", "पंप के नीचे वीप होल के पास कूलेंट सूखने के सफेद/हरे निशान देखें", "افحص ثقب التصريف السفلي بحثاً عن آثار تسرب سائل التبريد"),
                Bilingual("Check coolant circulation flow at radiator neck when thermostat opens", "थर्मोस्टेट खुलने पर रेडिएटर में पानी के तेज बहाव को देखें", "راقب تدفق السائل عند فتح الثيرموستات للتأكد من كفاءة الضخ")
            ),
            repairInstructions = listOf(
                Bilingual("Drain coolant completely and scrape all old gasket material cleanly from block face", "पुराना कूलेंट निकालें और ब्लॉक की सतह से पुराना गैस्केट अच्छी तरह खुरच कर साफ करें", "أفرغ سائل التبريد ونظف سطح التثبيت تماماً من بقايا الجوان القديم"),
                Bilingual("Fit genuine gasket / O-ring seal without obstructing coolant bypass ports", "ओरिजिनल गैस्केट लगाएं और ध्यान रखें कोई सुराख बंद न हो", "ركب الجوان الأصلي بدقة دون إغلاق فتحات التمرير"),
                Bilingual("Re-tension serpentine/V-belt to OEM deflection spec and bleed cooling air", "फैन बेल्ट सही तनाव पर सेट करें और कूलेंट की हवा निकालें", "اضبط شد السير حسب المواصفات وفرّغ الهواء من دورة التبريد")
            ),
            safetyWarning = Bilingual(
                en = "WARNING: Wait until engine cools below 40°C before draining coolant. Replace corroded water pumps immediately—bearing seizure snaps the fan belt and drives fan blades into the radiator!",
                hi = "चेतावनी: खराब वॉटर पंप तुरंत बदलें वरना बेयरिंग टूटने पर पंखा रेडिएटर को फाड़ सकता है!",
                ar = "تحذير: تلف رولمان مضخة المياه قد يسبب كسر المروحة واختراقها للرادياتير!"
            ),
            torqueSpec = "Mounting Bolts M8: ~22–26 Nm (verify OEM engine chart)",
            diagramPoints = listOf(
                DiagramPoint(1, "Cast Impeller Wheel", "वॉटर इम्पेलर पंखुड़ी", "Pumps coolant through cylinder block", "इंजन में कूलेंट घुमाने वाली पंखुड़ी", "مروحة الضخ الداخلية", "تدفع السائل داخل قنوات المحرك"),
                DiagramPoint(2, "Sealed Shaft Bearing", "सील्ड शाफ्ट बेयरिंग", "Supports radial belt load", "बेल्ट का भार सहने वाली बेयरिंग", "رولمان عمود المضخة", "يتحمل شد سير المروحة"),
                DiagramPoint(3, "Mechanical Carbon Face Seal", "मैकेनिकल वॉटर सील", "Prevents coolant reaching bearing", "पानी को बेयरिंग में जाने से रोकती है", "مانع التسرب الميكانيكي", "يمنع تسرب السائل إلى الرولمان"),
                DiagramPoint(4, "Mounting Flange & Gasket", "माउंटिंग फ्लैंज व गैस्केट", "Seals pump body to engine block", "इंजन ब्लॉक पर कसने वाला फ्लैंज", "شفة التثبيت والجوان", "تُحكم إغلاق المضخة على كتلة المحرك")
            ),
            manualReference = "JCB Service Manual Section B-4 (Water Pump Replacement)"
        ),

        // 8. FUEL SYSTEM
        JcbPart(
            id = "part_fuel_filter",
            partNumber = "32/925915 (Primary Water Trap) / 320/07155 (Secondary 5µm)",
            system = SystemCategory.FUEL,
            nameEn = "Fuel Filter & Water Separator",
            nameHi = "फ्यूल फिल्टर (डीजल फिल्टर)",
            nameAr = "فلتر الوقود",
            imageResId = R.drawable.img_part_fuel_filter,
            supportedModels = listOf("JCB 3CX", "JCB 4CX", "JCB 3DX", "JCB 5CX", "CAT Backhoe"),
            modelDifferences = listOf(
                Bilingual(
                    en = "Mechanical rotary FIP engines use standard 5–10 micron filters; Tier 3/4 Common Rail (CRDI) engines strictly demand ultra-fine 2-micron high-efficiency filters.",
                    hi = "सामान्य पंप वाले इंजन में 5-10 माइक्रोन और Common Rail (CRDI) इंजन में केवल असली 2-माइक्रोन फिल्टर अनिवार्य है।",
                    ar = "تتطلب محركات الحقن الإلكتروني المشترك (Common Rail) فلاتر فائقة الدقة 2 ميكرون لحماية الحاقنات من التلف الفوري."
                )
            ),
            viewAngles = listOf(
                PartViewAngle(
                    Bilingual("Filter Spin-On Element & Base", "फिल्टर एलिमेंट व हेड", "عنصر الفلتر وقاعدة التثبيت"),
                    Bilingual("Threaded top seal connects to fuel lift/primer housing.", "ऊपर डीजल पंप और प्राइमर हेड से कसने वाली चूड़ी।", "يُربط في قاعدة الفلتر المزودة بمضخة التحضير.")
                ),
                PartViewAngle(
                    Bilingual("Bottom Water Drain Bowl", "निचला पानी निकालने का कटोरा", "صمام تصريف المياه السفلي"),
                    Bilingual("Transparent trap collects heavier water droplets for daily draining.", "नीचे पानी व गाद जमा होती है जिसे रोज सुबह खोलकर निकालते हैं।", "يجمع قطرات الماء والشوائب الثقيلة لتصريفها يومياً.")
                )
            ),
            location = Bilingual(
                en = "Mounted on the left side of the engine bay inside easy reach from ground level.",
                hi = "इंजन बे के बाईं ओर लगा होता है ताकि जमीन से आसानी से पानी निकाला व बदला जा सके।",
                ar = "مثبت على الجانب الأيسر من حجرة المحرك ليسهل الوصول إليه لتصريف المياه وتغييره."
            ),
            workingPrinciple = Bilingual(
                en = "Two-stage diesel purification: primary water separator coalesces water droplets and coarse rust out of tank fuel, while the pleated secondary filter traps microscopic abrasives before fuel enters precision injection pumps.",
                hi = "दो चरणों में डीजल साफ करता है: पहले पानी व कचरा अलग करता है, फिर बारीक कागज से सूक्ष्म धूल छानकर पंप और इंजेक्टर को खराब होने से बचाता है।",
                ar = "ينقي الديزل على مرحلتين: يفصل الماء والصدأ أولاً ثم يحجز الشوائب الدقيقة قبل وصول الوقود إلى مضخة الحقن عالية الضغط."
            ),
            damageSymptoms = listOf(
                Bilingual("Engine loses power or stalls under heavy throttle/digging load (fuel starvation)", "लोड पड़ते ही इंजन का दम टूटना या बंद पड़ जाना", "ضعف عزم المحرك أو توقفه عند زيادة الحمل"),
                Bilingual("Error code P0087 (Low Fuel Rail Pressure) or hard morning starting", "फॉल्ट कोड P0087 आना या सुबह स्टार्ट होने में देरी", "ظهور كود العطل P0087 أو صعوبة التشغيل صباحاً"),
                Bilingual("Water-in-fuel dashboard warning light illuminated", "डैशबोर्ड पर डीजल में पानी (Water in Fuel) बत्ती जलना", "إضاءة لمبة تحذير وجود ماء في الوقود")
            ),
            inspectionProcedure = listOf(
                Bilingual("Open bottom thumb drain screw daily until clean diesel runs free of water", "रोज सुबह नीचे का स्क्रू खोलकर जमा पानी व कचरा बाहर निकालें", "افتح صمام التصريف السفلي يومياً حتى يخرج الديزل صافياً خالياً من الماء"),
                Bilingual("Inspect filter head O-ring seals and hand primer pump for air leaks", "फिल्टर हेड की रबर सील और हैंड प्राइमर में हवा खींचने की जांच करें", "افحص حلقات الإحكام ومضخة التحضير اليدوية للتأكد من عدم دخول هواء"),
                Bilingual("Check service hours (replace every 250–500 hours depending on diesel quality)", "इंजन घंटे चेक करें (डीजल की गुणवत्ता अनुसार हर 250-500 घंटे पर बदलें)", "راجع ساعات العمل (استبدله كل 250-500 ساعة أو حسب نقاء الديزل)")
            ),
            repairInstructions = listOf(
                Bilingual("CRITICAL: NEVER pre-fill a Common Rail secondary filter from the center hole—unfiltered dirt destroys injectors!", "सावधानी: नए CRDI डीजल फिल्टर में ऊपर बीच के सुराख से कभी कच्चा डीजल न भरें! हमेशा प्राइमर पंप से ही भरें।", "تحذير حاسم: لا تملأ الفلتر الثانوي من الثقب الأوسط أبداً قبل التركيب؛ استخدم مضخة التحضير اليدوية لتمرير الوقود عبر الورق المرشح!"),
                Bilingual("Lubricate rubber seal lightly with clean diesel and tighten by hand only (usually 3/4 turn past contact)", "रबर सील पर साफ डीजल लगाकर हाथ से ही टाइट करें", "ادهن الحلقة المطاطية بديزل نظيف واربط الفلتر باليد فقط 3/4 لفة بعد التلامس"),
                Bilingual("Bleed air thoroughly using hand primer and bleed screw until firm before cranking", "स्टार्ट करने से पहले प्राइमर से हवा पूरी तरह निकालें", "نزّف الهواء بالكامل بمضخة التحضير حتى تصبح صلبة قبل التشغيل")
            ),
            safetyWarning = Bilingual(
                en = "WARNING: Clean spilled diesel immediately—fire hazard near hot exhaust and slip hazard on steps.",
                hi = "चेतावनी: गिरा हुआ डीजल तुरंत पोंछें; गर्म साइलेंसर पर आग लगने और सीढ़ियों पर फिसलने का खतरा होता है।",
                ar = "تحذير: نظف الديزل المنسكب فوراً لتجنب خطر الحريق أو الانزلاق."
            ),
            torqueSpec = "Hand-tighten 3/4 turn after gasket contact (do NOT over-torque with strap wrench)",
            diagramPoints = listOf(
                DiagramPoint(1, "Threaded Mounting Head", "माउंटिंग हेड व सील", "Seals against filter manifold base", "फिल्टर हेड से जुड़ने वाला सिरा", "رأس التثبيت والمانع", "يثبت على قاعدة الوقود بإحكام"),
                DiagramPoint(2, "2–5 Micron Pleated Media", "माइक्रोन फिल्टर पेपर", "Traps rust, wax, and abrasive dust", "बारीक धूल व जंग रोकने वाला कागज", "وسيط الترشيح الدقيق", "يحجز أدق الشوائب لحماية الحاقنات"),
                DiagramPoint(3, "Water Coalescing Chamber", "वाटर सेपरेटर कटोरा", "Separates water droplets from diesel", "डीजल से पानी अलग करने का हिस्सा", "غرفة فصل المياه", "تفصل قطرات الماء الأثقل إلى الأسفل"),
                DiagramPoint(4, "Bottom Water Drain Valve", "ड्रेन वॉल्व स्क्रू", "Allows daily water/sludge purging", "रोजाना पानी निकालने का स्क्रू", "صمام تصريف المياه", "لتفريغ المياه المتجمعة يومياً")
            ),
            manualReference = "JCB Service Manual Section B-3 (Fuel System Maintenance)"
        ),

        // 9. FRONT LOADER
        JcbPart(
            id = "part_loader_bucket",
            partNumber = "531/03205 (Teeth) / GP Shovel 1.0–1.3 m³",
            system = SystemCategory.FRONT_LOADER,
            nameEn = "Front Loader Shovel Bucket & Teeth",
            nameHi = "फ्रंट लोडर बकेट व दांत (शॉवेल)",
            nameAr = "دلو المحمل الأمامي وأسنانه",
            imageResId = R.drawable.img_part_loader_bucket,
            supportedModels = listOf("JCB 3CX", "JCB 4CX", "JCB 3DX", "JCB 5CX", "CAT Backhoe"),
            modelDifferences = listOf(
                Bilingual(
                    en = "Standard 1.0 m³ GP bucket on 3DX vs 1.1–1.3 m³ 6-in-1 clamshell shovel on 3CX/4CX/5CX.",
                    hi = "3DX में सामान्य 1.0 m³ लोडर बकेट होती है, जबकि 3CX/4CX/5CX में 1.1–1.3 m³ 6-इन-1 क्लैमशेल शॉवेल भी आती है।",
                    ar = "تستخدم 3DX دلواً قياسياً 1.0 م³ بينما تتوفر دلاء 6-في-1 متعددة الأغراض بسعة تصل إلى 1.3 م³ في 4CX و5CX."
                )
            ),
            location = Bilingual(
                en = "Pinned to the front loader lift arms and bucket crowd tipping linkage at the front of the machine.",
                hi = "मशीन के सबसे अगले हिस्से में फ्रंट लोडर आर्म्स की निचली पिनों पर लगा होता है।",
                ar = "مثبت في مقدمة الآلة على أذرع الرفع الأمامية وموصلات الإمالة."
            ),
            workingPrinciple = Bilingual(
                en = "Heavy welded abrasion-resistant steel scoop fitted with replaceable hardened cutting edge and bolt-on teeth for loading soil, gravel, grading, and site cleanup.",
                hi = "मजबूत स्टील का बकेट जिसके आगे बदलने योग्य तेज धार वाली ब्लेड और कठोर दांत लगे होते हैं, जो मिट्टी, गिट्टी और मलबे को आसानी से भरकर ट्रकों में लोड करता है।",
                ar = "دلو فولاذي مقوى مزود بشفرة قطع وأسنان قابلة للاستبدال لتحميل الأتربة والحصى وتسوية الموقع."
            ),
            damageSymptoms = listOf(
                Bilingual("Worn or broken tooth tips causing high fuel consumption and weak penetration", "दांत घिसने या टूटने से मिट्टी भरने में जोर और ज्यादा डीजल खपत", "تآكل أو كسر الأسنان مما يقلل الاختراق ويزيد استهلاك الوقود"),
                Bilingual("Elongated oval pin bosses causing loud clunking when dumping", "पिन के सुराख (बुश) अंडाकार घिसने से खड़खड़ाहट", "تآكل فتحات البنوز وصدور صوت طرق عند التفريغ"),
                Bilingual("Cracks along side-cutter wear plates or base edge welds", "साइड प्लेट और निचली ब्लेड के पास वेल्डिंग चटकना", "شروخ في الصفائح الجانبية أو لحامات الشفرة السفلية")
            ),
            inspectionProcedure = listOf(
                Bilingual("Measure cutting edge wear before wear reaches the welded base bucket plate", "निचली ब्लेड की घिसावट देखें ताकि मुख्य बकेट प्लेट न घिस जाए", "راقب تآكل الشفرة القابلة للاستبدال قبل وصول التآكل لجسم الدلو"),
                Bilingual("Inspect all bolt-on plow bolts and teeth nuts for tightness", "सभी दांतों के प्लॉ-बोल्ट का ढीलापन जांचें", "افحص رباط جميع مسامير الأسنان والشفرة"),
                Bilingual("Check loader pivot pin & bush play and lubricate daily", "पिन-बुश का प्ले देखें और रोज ग्रीस मारें", "افحص خلوص بنوز المفصلات وشحمها يومياً")
            ),
            repairInstructions = listOf(
                Bilingual("Support bucket flat on wooden blocks when replacing bolt-on teeth or reversible edge", "दांत या ब्लेड बदलते समय बकेट को लकड़ी के गुटकों पर सुरक्षित टिकाएं", "اسند الدلو على عوارض خشبية متينة عند استبدال الأسنان أو الشفرة"),
                Bilingual("Use hardened plow bolts and new locknuts; never reuse stretched bolts", "हमेशा नए हार्ड प्लॉ-बोल्ट व लॉक नट लगाएं", "استخدم مسامير محراث صلبة وصواميل قفل جديدة دائماً"),
                Bilingual("Pre-heat structural steel and use low-hydrogen electrodes (E7018) for crack repairs", "बकेट वेल्डिंग के लिए लो-हाइड्रोजन (7018) रॉड प्रयोग करें", "استخدم أسلاك لحام منخفضة الهيدروجين (E7018) عند إصلاح شروخ الدلو")
            ),
            safetyWarning = Bilingual(
                en = "DANGER: NEVER work under a raised loader bucket without engaging the physical steel loader safety strut on the lift cylinder!",
                hi = "खतरा: उठे हुए लोडर आर्म के नीचे कभी भी सेफ्टी लॉक ब्रैकेट लगाए बिना न जाएं!",
                ar = "خطر: لا تقف أو تعمل أبداً أسفل دلو محمل مرفوع دون تثبيت دعامة الأمان الفولاذية على ذراع الرفع!"
            ),
            torqueSpec = "Plow Bolts (M16/M20): check tooth hardware grade (~250–380 Nm)",
            diagramPoints = listOf(
                DiagramPoint(1, "Pin Bosses & Grease Bushings", "पिवट पिन बॉस", "Attaches bucket to loader arms", "लोडर आर्म व सिलेंडर जुड़ने वाले सुराख", "مفصلات البنوز والبطانات", "تربط الدلو بأذرع المحمل"),
                DiagramPoint(2, "Side-Cutter Wear Strips", "साइड कटर प्लेट", "Protects bucket side edges from abrasion", "साइड किनारों को घिसने से बचाती है", "صفائح الحماية الجانبية", "تحمي جوانب الدلو من التآكل"),
                DiagramPoint(3, "Replaceable Cutting Edge", "बदलने योग्य कटिंग ब्लेड", "Reversible hardened steel bottom lip", "निचली मजबूत स्टील ब्लेड", "شفرة القطع القابلة للتبديل", "حافة فولاذية مقساة لحماية قاعدة الدلو"),
                DiagramPoint(4, "Bolt-on Digging Teeth", "बकेट के दांत", "Penetrates compacted dirt & rock", "कठोर मिट्टी व पत्थर उखाड़ने वाले दांत", "أسنان الحفر المثبتة بمسامير", "تسهل اختراق التربة الصلبة والصخور")
            ),
            manualReference = "JCB Attachments & Loader Maintenance Manual"
        ),

        // 10. BACKHOE ASSEMBLY
        JcbPart(
            id = "part_backhoe_dipper",
            partNumber = "332/G6400 (Standard / Extradig Extending Dipper)",
            system = SystemCategory.BACKHOE_DIPPER,
            nameEn = "Backhoe Dipper Stick Arm",
            nameHi = "बैकहो डिपर आर्म (स्टिक)",
            nameAr = "ذراع الحفار الخلفي (الديبر)",
            imageResId = R.drawable.img_part_backhoe_dipper,
            supportedModels = listOf("JCB 3CX", "JCB 4CX", "JCB 3DX", "JCB 5CX", "CAT Backhoe"),
            modelDifferences = listOf(
                Bilingual(
                    en = "Fixed length dipper on standard 3DX vs Hydraulic Extradig telescopic dipper with wear pads on 3CX/4CX/5CX.",
                    hi = "सामान्य 3DX में फिक्स डिपर आर्म होती है, जबकि 3CX/4CX/5CX में हाइड्रोलिक बाहर निकलने वाली (Extradig) डिपर होती है।",
                    ar = "ذراع ثابت في 3DX القياسية مقابل ذراع تلسكوبي ممتد (Extradig) في 3CX و4CX و5CX."
                )
            ),
            location = Bilingual(
                en = "Pivots at the outer top end of the curved backhoe boom, supporting the bucket cylinder and tipping linkage.",
                hi = "बैकहो के मुख्य बूम के ऊपरी सिरे से जुड़ा होता है और आगे बकेट को थामता है।",
                ar = "متصل بالطرف العلوي لذراع الرفع الرئيسي ويحمل أسطوانة الجرافة ووصلة الإمالة."
            ),
            workingPrinciple = Bilingual(
                en = "High-tensile fabricated box-section arm converting dipper ram stroke into sweeping trenching reach and crowd force toward the machine.",
                hi = "मजबूत बॉक्स-सेक्शन स्टील आर्म जो डिपर सिलेंडर की ताकत से बकेट को जमीन के अंदर गहरी खुदाई करने में मदद करता है।",
                ar = "ذراع فولاذي صندوقي المقطع يحول حركة أسطوانة الديبر إلى مدى حفر عميق وقوة جرف نحو الآلة."
            ),
            damageSymptoms = listOf(
                Bilingual("Loose wobbling bucket linkage due to ovalized bush bores", "पिन और बुश कटने से बकेट का ज्यादा हिलना", "اهتزاز وارتخاء الجرافة بسبب تآكل البطانات والبنوز"),
                Bilingual("Hairline fatigue cracks around dipper pivot boss welds", "पिन के पास बॉक्स वेल्डिंग में दरारें आना", "تشققات إجهاد في لحامات مفاصل البنوز"),
                Bilingual("Worn nylon wear pads causing inner Extradig beam to rattle", "एक्स्ट्राडिग वाले मॉडल में अंदरूनी स्लाइड पैड घिसकर आवाज आना", "تآكل وسادات الانزلاق في الذراع التلسكوبي")
            ),
            inspectionProcedure = listOf(
                Bilingual("Wash dipper arm clean weekly and check all weld seams around bosses for cracks", "साप्ताहिक सफाई करके सभी वेल्ड जोड़ों में दरारें जांचें", "نظف الذراع أسبوعياً وافحص جميع اللحامات بحثاً عن تشققات"),
                Bilingual("Measure clearance on bucket tipping link 'dog-bone' pins and replace worn hardened bushes", "डॉग-बोन लिंकेज व बकेट पिन का प्ले चेक करें", "افحص خلوص وصلة الجرافة واستبدل البطانات المتآكلة"),
                Bilingual("On Extradig models, verify nylon slider pad thickness and adjust shims", "एक्स्ट्राडिग मॉडल में साइड स्लाइड पैड का गैप चेक करें", "في الذراع التلسكوبي، افحص سماكة وسادات الانزلاق")
            ),
            repairInstructions = listOf(
                Bilingual("Grease all dipper, dog-bone, and bucket pivot nipples every 10 hours (twice daily in water/mud)", "हर 10 घंटे (कीचड़ में दिन में दो बार) ग्रीस भरें", "شحّم جميع نقاط المفصلات كل 10 ساعات عمل (ومرتين يومياً في الطين والماء)"),
                Bilingual("Press out worn steel/bronze bushes using hydraulic puller and freeze new bushes slightly before pressing in", "खराब बुश को हाइड्रोलिक पुलर से निकालकर नए बुश सावधानी से ठोकें/प्रेस करें", "استخرج البطانات المتآكلة بمكبس هيدروليكي وركب الجديدة بمحاذاة دقيقة"),
                Bilingual("Never operate breaker hammer using dipper side-twisting leverage", "ब्रेकर चलाते समय कभी डिपर को तिरछा करके चट्टान न तोड़ें", "لا تستخدم الذراع بشكل جانبي للعتلة أثناء عمل الجاك همر")
            ),
            safetyWarning = Bilingual(
                en = "DANGER: Disconnect battery and keep feet/hands clear when driving hardened steel pivot pins—wear safety goggles against flying steel splinters!",
                hi = "खतरा: हार्ड स्टील पिन ठोकते समय चश्मा जरूर पहनें, लोहे की चिटकन आंख में लग सकती है!",
                ar = "خطر: ارتدِ نظارات واقية دائماً عند طرق البنوز الفولاذية المقساة لتفادي تطاير الشظايا المعدنية!"
            ),
            torqueSpec = "Pin Retainer Lock Bolts: M12/M16 (~80–120 Nm) with Loctite",
            diagramPoints = listOf(
                DiagramPoint(1, "Boom-to-Dipper Pivot Boss", "बूम-डिपर पिवट जोड़", "Main hinge carrying bending load", "मुख्य बूम से जुड़ने वाला मजबूत जोड़", "مفصل الذراع الرئيسي", "يربط الديبر بذراع البوم"),
                DiagramPoint(2, "Bucket Ram Anchor Bracket", "बकेट सिलेंडर ब्रैकेट", "Supports bucket hydraulic cylinder", "बकेट सिलेंडर का निचला सिरा जुड़ता है", "قاعدة أسطوانة الجرافة", "تحمل قاعدة أسطوانة الجرافة"),
                DiagramPoint(3, "Tipping Link 'Dog-Bone' Boss", "डॉग-बोन लिंकेज पिन", "Multiplies bucket curling leverage", "बकेट को घुमाने वाला लिंकेज पॉइंट", "نقطة وصلة الجرافة", "تضاعف زاوية وقوة إمالة الجرافة"),
                DiagramPoint(4, "Box-Section Fabricated Beam", "बॉक्स स्टील बॉडी", "High-tensile torsion-resistant arm", "मजबूत खोखला बॉक्स ढांचा", "جسم الذراع الصندوقي", "هيكل فولاذي مقاوم للالتواء")
            ),
            manualReference = "JCB Service Manual Section A & J (Backhoe Structures & Pins)"
        ),

        // 11. CABIN & DASHBOARD
        JcbPart(
            id = "part_dashboard_cluster",
            partNumber = "704/50226 / Side Instrument Panel Display",
            system = SystemCategory.CABIN_DASHBOARD,
            nameEn = "Instrument Dashboard Gauge Cluster",
            nameHi = "डैशबोर्ड मीटर व चेतावनी क्लस्टर",
            nameAr = "لوحة العدادات ومؤشرات القيادة",
            imageResId = R.drawable.img_part_dashboard_cluster,
            supportedModels = listOf("JCB 3CX", "JCB 4CX", "JCB 3DX", "JCB 5CX", "CAT Backhoe"),
            modelDifferences = listOf(
                Bilingual(
                    en = "Analog + warning lamp cluster on 3DX vs CAN-bus LCD hour-meter & digital fault code display on EcoMAX 3CX/4CX/5CX.",
                    hi = "3DX में एनालॉग गेज और चेतावनी लाइटें होती हैं, जबकि EcoMAX 3CX/4CX/5CX में CAN-bus डिजिटल स्क्रीन पर एरर कोड भी दिखते हैं।",
                    ar = "تستخدم 3DX عدادات قياسية ولمبات تحذير، بينما تضم 3CX/4CX الحديثة شاشة CAN-bus لعرض أكواد الأعطال."
                )
            ),
            location = Bilingual(
                en = "Mounted on the right-hand side console (or front steering pod) inside the operator cabin.",
                hi = "ऑपरेटर कैबिन के अंदर दाईं ओर साइड कंसोल पर (या स्टीयरिंग के सामने) लगा होता है।",
                ar = "مثبتة على اللوحة الجانبية اليمنى (أو أمام المقود) داخل مقصورة المشغل."
            ),
            workingPrinciple = Bilingual(
                en = "Monitors engine RPM (from alternator W or crank sensor), coolant temperature, fuel tank level, battery charging, engine oil pressure, transmission temperature, and air-filter vacuum via switched 12V & CAN signals.",
                hi = "अल्टरनेटर व सेंसरों से सिग्नल लेकर इंजन की रेस (RPM), तापमान, डीजल स्तर, ऑयल प्रेशर और चेतावनी बत्ती व अलार्म ऑपरेटर को दिखाता है।",
                ar = "تستقبل إشارات الحساسات والدينامو لعرض سرعة المحرك RPM وحرارة التبريد ومستوى الوقود وضغط الزيت وتنبيه المشغل عند الخطر."
            ),
            damageSymptoms = listOf(
                Bilingual("All gauges dead or LCD backlight flickering (blown ignition fuse or loose earth)", "मीटर पूरी तरह बंद या लाइट टिमटिमाना (फ्यूज या अर्थिंग ढीला होना)", "توقف جميع العدادات أو وميض الشاشة بسبب مصهر أو تأريض ضعيف"),
                Bilingual("Warning buzzer sounding continuously with red oil/overheat lamp", "लगातार बीप अलार्म बजना और लाल बत्ती जलना", "انطلاق جرس الإنذار المستمر مع إضاءة لمبة الخطر الحمراء"),
                Bilingual("Erratic fuel/temperature needle jumps caused by corroded rear plug pins", "सुई का झटके मारना या गलत रीडिंग दिखाना", "تذبذب إبر الوقود أو الحرارة بسبب تأكسد أطراف الفيش الخلفي")
            ),
            inspectionProcedure = listOf(
                Bilingual("Turn ignition ON (key pos 1): verify ALL warning lamps & buzzer run self-test for 2 seconds", "चाबी ON करने पर चेक करें कि सभी चेतावनी लाइटें और बजर 2 सेकंड के लिए जलते हैं", "أدر المفتاح لوضع التشغيل وتأكد من إضاءة جميع اللمبات وجرس الفحص الذاتي لمدة ثانيتين"),
                Bilingual("Check main cabin instrument fuse and ignition +12V / ground pins at rear multi-plug", "कैबिन फ्यूज और क्लस्टर के पीछे 12V व अर्थिंग पिन चेक करें", "افحص مصهر الطبلون ووصلة الكهرباء والأرضي في الفيش الخلفي"),
                Bilingual("Ground sensor signal wire briefly (only on analog gauge senders) to verify needle sweeps full scale", "सेंसर तार से मीटर की सुई का काम करना सत्यापित करें", "اختبر حركة الإبرة بتحقق إشارة الحساس والتوصيلات")
            ),
            repairInstructions = listOf(
                Bilingual("Disconnect battery isolator before unplugging cluster multi-pin connectors", "मीटर का प्लग निकालने से पहले बैटरी स्विच बंद करें", "افصل عازل البطارية قبل فصل فيش لوحة العدادات"),
                Bilingual("Clean oxidized connector pins gently with electrical contact cleaner spray—never water", "प्लग साफ करने के लिए केवल इलेक्ट्रॉनिक कॉन्टैक्ट क्लीनर स्प्रे प्रयोग करें", "نظف أطراف الفيش بمنظف نقاط تلامس كهربائي فقط دون ماء"),
                Bilingual("Do NOT pressure-wash directly inside cabin dashboard console!", "कैबिन धोते समय कभी भी डैशबोर्ड पर सीधा पानी का प्रेशर न मारें!", "لا توجه غسيل الماء المضغوط أبداً مباشرة نحو لوحة القيادة داخل المقصورة!")
            ),
            safetyWarning = Bilingual(
                en = "CRITICAL: NEVER tape over or disconnect the warning buzzer—ignoring red oil pressure or transmission overheat alarms destroys major assemblies in minutes!",
                hi = "चेतावनी: डैशबोर्ड के बजर तार को कभी न काटें! लाल बत्ती व अलार्म अनदेखा करने पर इंजन तुरंत सीज हो सकता है।",
                ar = "تحذير حاسم: لا تفصل جرس الإنذار أو تتجاهل لمبات التحذير الحمراء، فإهمالها يدمر المحرك أو الجير في دقائق!"
            ),
            torqueSpec = "Panel Mounting Screws: hand-snug plastic trim (~2 Nm)",
            diagramPoints = listOf(
                DiagramPoint(1, "RPM Tachometer & Hourmeter", "आरपीएम व घंटा मीटर", "Shows engine speed and total service hours", "इंजन स्पीड और कुल चलने के घंटे दिखाता है", "عداد RPM وساعات العمل", "يعرض سرعة المحرك وساعات التشغيل"),
                DiagramPoint(2, "Fuel & Coolant Temp Gauges", "डीजल व तापमान गेज", "Monitors fuel level and coolant heat", "डीजल व इंजन गर्मी दिखाने वाले मीटर", "مؤشرات الوقود والحرارة", "يراقبان مستوى الديزل وحرارة المحرك"),
                DiagramPoint(3, "Red Stop Warning Bank", "लाल चेतावनी लाइटें", "Oil pressure, alternator, overheat alerts", "ऑयल प्रेशर, बैटरी और ओवरहीट अलर्ट", "مجموعة لمبات الخطر الحمراء", "تحذيرات ضغط الزيت والشحن والحرارة"),
                DiagramPoint(4, "Amber Caution Indicators", "पीली सावधानी लाइटें", "Air filter, water-in-fuel, transmission temp", "एयर फिल्टर चोक, पानी व सर्विस इंडिकेटर", "مؤشرات التنبيه الصفراء", "انسداد الفلتر وماء الوقود والحرارة")
            ),
            manualReference = "JCB Operator & Electrical Manual Section C (Instrumentation)"
        ),

        // 12. WHEELS & AXLES
        JcbPart(
            id = "part_axle_hub",
            partNumber = "450/10200 / 458/20352 (Planetary Carrier & Hub)",
            system = SystemCategory.AXLES_WHEELS,
            nameEn = "Rear Planetary Drive Axle Hub",
            nameHi = "रियर एक्सल प्लेनेटरी हब और पहिया असेंबली",
            nameAr = "محور العجلة الخلفي والمجموعة الكوكبية",
            imageResId = R.drawable.img_part_axle_hub,
            supportedModels = listOf("JCB 3CX", "JCB 4CX", "JCB 3DX", "JCB 5CX", "CAT Backhoe"),
            modelDifferences = listOf(
                Bilingual(
                    en = "Stud count (8-stud vs 10-stud) and planetary reduction gear ratio differ between 2WD/4WD 3DX, 4CX equal-wheel, and CAT axles.",
                    hi = "3DX, 4CX (चारों बराबर टायर) और CAT मशीनों में हब स्टड संख्या (8 vs 10) और गियर अनुपात अलग-अलग होते हैं।",
                    ar = "يختلف عدد مسامير العجل (8 أو 10) ونسبة التخفيض الكوكبية بين JCB 3DX و4CX وCAT."
                )
            ),
            location = Bilingual(
                en = "Mounted at the outer ends of the front 4WD steer axle and heavy rear drive axle where road wheels bolt on.",
                hi = "अगले 4WD एक्सल और पिछले मुख्य ड्राइव एक्सल के बाहरी दोनों सिरों पर जहां टायर के रिम कसे जाते हैं।",
                ar = "في الأطراف الخارجية للمحور الأمامي 4WD والمحور الخلفي حيث تُثبت العجلات."
            ),
            workingPrinciple = Bilingual(
                en = "Epicyclic (planetary) final reduction hub featuring a central sun gear on the half-shaft driving three planet gears inside a stationary outer ring gear, multiplying torque right at the wheel while reducing stress on axle shafts.",
                hi = "बीच का सन गियर तीन छोटे प्लेनेट गियरों को रिंग गियर के अंदर घुमाता है, जिससे पहिए के पास पहुंचकर ताकत कई गुना बढ़ जाती है और एक्सल शाफ्ट नहीं टूटते।",
                ar = "مجموعة تروس كوكبية نهائية تضاعف العزم عند العجلة مباشرة وتخفف الإجهاد عن أعمدة المحور الداخلية."
            ),
            damageSymptoms = listOf(
                Bilingual("Oil leak dripping down inside of rear/front tyre rim (failed hub seal)", "टायर रिम के अंदर की तरफ से गियर ऑयल टपकना (हब सील कटना)", "تسرب زيت على الحافة الداخلية للإطار بسبب تلف صوفة الصرة"),
                Bilingual("Crunching, clicking noise from wheel hub when turning or reversing", "मोड़ने या रिवर्स लेने पर पहिए के हब से खड़खड़ाहट", "صوت طقطقة وتكسير من صرة العجل عند الدوران أو الرجوع"),
                Bilingual("Loose wheel lug nuts shearing wheel studs", "पहिए के नट ढीले होकर स्टड कटना", "ارتخاء صواميل العجل وانقطاع المسامير")
            ),
            inspectionProcedure = listOf(
                Bilingual("Rotate wheel so hub oil level plug sits horizontally at 9 or 3 o'clock and verify 85W-90 oil level", "पहिए को घुमाकर हब प्लग को बीच (3 या 9 बजे) लाएं और तेल लेवल जांचें", "أدر العجلة حتى يكون سداد الفحص أفقياً (الساعة 3 أو 9) وتأكد من مستوى الزيت"),
                Bilingual("Check hub oil for sparkling silver metal chips from planet needle bearings", "हब का तेल निकालकर चमकदार लोहे का बुरादा चेक करें", "افحص الزيت بحثاً عن برادة معدنية من رولمان التروس الكوكبية"),
                Bilingual("Jack axle clear and rock wheel top-to-bottom to check tapered wheel bearing play", "जैक से पहिया उठाकर हब बेयरिंग का प्ले चेक करें", "ارفع العجلة وافحص خلوص رولمان العجلة بالهز العمودي")
            ),
            repairInstructions = listOf(
                Bilingual("Drain hub oil at 6 o'clock position every 1,000 hours; refill with EP 85W-90 / JCB HD90 Gear Oil", "हर 1000 घंटे पर प्लग नीचे (6 बजे) करके तेल निकालें और 85W-90 तेल भरें", "غيّر زيت الصرة كل 1000 ساعة بتصريفه عند الساعة 6 وتعبئته بزيت تروس 85W-90"),
                Bilingual("Replace both hub oil seal and planet carrier O-ring whenever servicing hub bearings", "हब खोलने पर हमेशा मुख्य हब ऑयल सील और कैरियर ओ-रिंग नई डालें", "استبدل صوفة الصرة وحلقة الغطاء عند أي فك للمجموعة الكوكبية"),
                Bilingual("Torque road wheel lug nuts in criss-cross star pattern and re-check after 10 hours work", "पहिए के नट स्टार क्रम में कसें और 10 घंटे चलाने के बाद दोबारा चेक करें", "اربط صواميل العجل بنمط نجمي متقاطع وأعد الفحص بعد 10 ساعات عمل")
            ),
            safetyWarning = Bilingual(
                en = "DANGER: Support axle on heavy blocks before removing road wheels. A filled JCB rear tyre weighs over 180 kg!",
                hi = "खतरा: पहिया खोलने से पहले एक्सल के नीचे मजबूत जैक घोड़ी लगाएं। जेसीबी का भरा हुआ पिछला टायर 180 किलो से ज्यादा भारी होता है!",
                ar = "خطر: ادعم المحور بركائز متينة قبل فك العجل؛ الإطار الخلفي المملوء يزن أكثر من 180 كجم!"
            ),
            torqueSpec = "Rear Wheel Nuts: ~500–600 Nm | Front Wheel Nuts: ~300 Nm (verify model manual)",
            diagramPoints = listOf(
                DiagramPoint(1, "Wheel Mounting Flange & Studs", "व्हील फ्लैंज व स्टड", "Secures wheel rim cleanly under load", "टायर का रिम कसने वाले मजबूत बोल्ट", "شفة ومسامير تثبيت العجل", "تثبت جنط الإطار بإحكام"),
                DiagramPoint(2, "Planetary Gear Carrier (3x Planets)", "प्लेनेटरी गियर कैरियर", "Provides final wheel torque multiplication", "ताकत बढ़ाने वाले 3 प्लेनेट गियर", "حامل التروس الكوكبية", "يوفر التخفيض النهائي ومضاعفة العزم"),
                DiagramPoint(3, "Tapered Roller Wheel Bearings", "टेपर रोलर बेयरिंग", "Supports full machine axle weight", "मशीन का पूरा वजन उठाने वाली बेयरिंग", "رولمان العجلة المخروطي", "يتحمل وزن الآلة الكامل"),
                DiagramPoint(4, "Duo-Cone / Cassette Hub Oil Seal", "हब ऑयल सील", "Keeps gear oil in & mud/water out", "तेल बाहर गिरने व कीचड़ अंदर जाने से रोकती है", "صوفة الصرة المانعة للتسرب", "تحفظ الزيت بالداخل وتمنع دخول الطين والماء")
            ),
            manualReference = "JCB Workshop Manual Section F & G (Axles & Hubs)"
        ),

        // 13. SENSORS & SWITCHES
        JcbPart(
            id = "part_pressure_sensor",
            partNumber = "701/80294 (Oil Switch) / 320/04145 (Fuel/Boost Sensor)",
            system = SystemCategory.SENSORS_SWITCHES,
            nameEn = "Engine Oil Pressure Sensor / Switch",
            nameHi = "इंजन ऑयल प्रेशर सेंसर व स्विच",
            nameAr = "حساس ضغط زيت المحرك",
            imageResId = R.drawable.img_part_pressure_sensor,
            supportedModels = listOf("JCB 3CX", "JCB 4CX", "JCB 3DX", "JCB 5CX", "CAT Backhoe"),
            modelDifferences = listOf(
                Bilingual(
                    en = "Mechanical 3DX engines use a 1-pin/2-pin NC pressure switch; EcoMAX Tier 3/4/CAT engines use 3-pin 5V piezo-resistive pressure transducers reporting exact bar values to ECU.",
                    hi = "पुराने 3DX में 1-पिन प्रेशर स्विच होता है, जबकि EcoMAX और CAT इंजन में 3-पिन 5V डिजिटल प्रेशर सेंसर लगा होता है।",
                    ar = "تستخدم 3DX القديمة مفتاح ضغط بسيط (طرف أو طرفين)، بينما تستخدم EcoMAX وCAT حساساً إلكترونياً بـ 3 أطراف بجهد 5 فولت."
                )
            ),
            location = Bilingual(
                en = "Threaded directly into the main pressurized oil gallery beside the engine oil filter housing.",
                hi = "इंजन ब्लॉक पर ऑयल फिल्टर हाउसिंग के पास मुख्य ऑयल गैलरी में कसा होता है।",
                ar = "مثبت بسن لولبي على مجرى الزيت الرئيسي بجانب قاعدة فلتر الزيت."
            ),
            workingPrinciple = Bilingual(
                en = "Senses engine lubrication gallery pressure; on 1-pin switches it opens contacts above ~0.5–0.8 bar to turn off the red warning lamp, while 3-pin transducers output a 0.5V–4.5V analog signal proportional to actual pressure to the ECU.",
                hi = "ऑयल प्रेशर नापता है: सामान्य स्विच प्रेशर बनने पर अर्थिंग काटकर लाल बत्ती बुझाता है, जबकि 3-पिन सेंसर 0.5V से 4.5V का सटीक सिग्नल ईसीयू को भेजता है।",
                ar = "يقيس ضغط تزييت المحرك؛ فيفصل المفتاح البسيط لمبة الخطر عند ارتفاع الضغط، بينما يرسل الحساس الإلكتروني إشارة 0.5-4.5 فولت إلى وحدة التحكم."
            ),
            damageSymptoms = listOf(
                Bilingual("Red oil pressure lamp flashing or glowing despite healthy mechanical pressure", "इंजन में सही ऑयल प्रेशर होने पर भी लाल बत्ती जलते रहना", "استمرار إضاءة لمبة الزيت رغم سلامة ضغط الزيت الميكانيكي"),
                Bilingual("Engine oil seeping out through cracked plastic electrical connector plug", "सेंसर के प्लास्टिक प्लग के अंदर से इंजन ऑयल बाहर लीक होना", "تسرب الزيت من داخل الفيش البلاستيكي للحساس"),
                Bilingual("ECU fault code indicating sensor circuit open or short to 5V/ground", "ईसीयू में सेंसर ओपन या शॉर्ट सर्किट का एरर कोड आना", "تسجيل كود عطل كهربائي لدائرة الحساس في وحدة التحكم")
            ),
            inspectionProcedure = listOf(
                Bilingual("ALWAYS verify actual mechanical oil pressure with a manual gauge FIRST before blaming sensor!", "सेंसर बदलने से पहले हमेशा मैकेनिकल प्रेशर गेज लगाकर असली ऑयल प्रेशर जांचें!", "تحقق دائماً من ضغط الزيت الفعلي بساعة فحص ميكانيكية أولاً قبل تغيير الحساس!"),
                Bilingual("Check 3-pin plug with key ON: Pin A = 5.0V supply, Pin B = 0V Sensor Ground, Pin C = Signal", "चाबी ON पर 3-पिन प्लग में 5V सप्लाई व अर्थिंग चेक करें", "افحص الفيش الثلاثي: تغذية 5 فولت، أرضي 0 فولت، وسلك الإشارة"),
                Bilingual("Inspect wire harness near filter head for chafing or oil saturation", "फिल्टर के पास सेंसर तार में कट या तेल भरना चेक करें", "افحص الضفيرة قرب قاعدة الفلتر بحثاً عن تآكل أو تلوث بالزيت")
            ),
            repairInstructions = listOf(
                Bilingual("Use deep hex socket (do NOT grip plastic connector body with pliers!)", "खोलने-कसने के लिए हमेशा डीप पाना इस्तेमाल करें, प्लास्टिक पर प्लास न लगाएं", "استخدم حبة مفك عميقة على السداسي المعدني ولا تمسك الجزء البلاستيكي بالكماشة"),
                Bilingual("Do NOT wrap heavy PTFE Teflon tape over tip threads if sensor grounds through body", "सिंगल-पिन बॉडी अर्थिंग वाले सेंसर पर ज्यादा टेफ्लॉन टेप न लपेटें वरना अर्थिंग कट जाएगी", "تجنب لف شريط تفلون كثيف على القلاووظ في الحساسات التي تعتمد على تأريض الجسم"),
                Bilingual("Verify thread pitch (e.g. 1/8\" NPT vs M10x1 vs M14x1.5) before installation", "लगाने से पहले चूड़ी का साइज जरूर मिला लें", "تأكد من مطابقة مقاس السن اللولبي قبل التركيب")
            ),
            safetyWarning = Bilingual(
                en = "CRITICAL: If the red oil pressure warning stays ON after starting, SHUT DOWN IMMEDIATELY until mechanical pressure is confirmed with a test gauge!",
                hi = "खतरा: स्टार्ट करने पर लाल ऑयल बत्ती बंद न हो तो तुरंत इंजन बंद करें और मैकेनिकल गेज से प्रेशर चेक करें!",
                ar = "تحذير حاسم: إذا ظلت لمبة ضغط الزيت الحمراء مضاءة بعد التشغيل، أطفئ المحرك فوراً حتى تتأكد من الضغط الفعلي!"
            ),
            torqueSpec = "Brass Hex Housing: ~18–25 Nm (avoid over-torquing tapered threads)",
            diagramPoints = listOf(
                DiagramPoint(1, "Threaded Pressure Port", "थ्रेडेड ऑयल पोर्ट", "Receives pressurized oil from gallery", "इंजन गैलरी से ऑयल प्रेशर लेने वाला मुंह", "منفذ الضغط الملولب", "يستقبل ضغط الزيت من مجرى المحرك"),
                DiagramPoint(2, "Brass Hex Body", "पीतल की हेक्स बॉडी", "Machined housing for socket wrench", "पाने से कसने वाला मजबूत पीतल का हिस्सा", "الجسم النحاسي السداسي", "مخصص لمفتاح الربط والتركيب"),
                DiagramPoint(3, "Internal Diaphragm / Piezo Cell", "अंदरूनी प्रेशर डायाफ्राम", "Converts bar pressure to electrical output", "दबाव को बिजली सिग्नल में बदलने वाला भाग", "الحجاب الحاجز الداخلي", "يحول الضغط الهيدروليكي إلى إشارة كهربائية"),
                DiagramPoint(4, "Sealed 3-Pin Connector", "सील्ड 3-पिन प्लग", "Weatherproof 5V / Ground / Signal pins", "पानी-धूल रोधी 3-पिन कनेक्टर", "الموصل الثلاثي المعزول", "يحتوي على أطراف 5 فولت والأرضي والإشارة")
            ),
            manualReference = "JCB Electrical & Sensor Diagnostics Manual Section C-4"
        ),

        // 14. FUSE, RELAY & WIRING
        JcbPart(
            id = "part_iso_relay",
            partNumber = "716/30255 / Standard 12V 40A 5-Pin ISO Cube Relay",
            system = SystemCategory.FUSE_RELAY_WIRING,
            nameEn = "12V 40A 5-Pin ISO Relay",
            nameHi = "12V आईएसओ रिले (40A 5-पिन)",
            nameAr = "مرحل كهربائي 12 فولت (ريليه 5 أطراف)",
            imageResId = R.drawable.img_part_iso_relay,
            supportedModels = listOf("JCB 3CX", "JCB 4CX", "JCB 3DX", "JCB 5CX", "CAT Backhoe"),
            modelDifferences = listOf(
                Bilingual(
                    en = "Standard ISO micro/mini 4-pin or 5-pin cube relays are used across 3CX/3DX/4CX/CAT fuse boards for starter interlock, work lights, fuel shutoff, and horn; check coil suppression resistor/diode type.",
                    hi = "3CX, 3DX, 4CX और CAT सभी के फ्यूज बॉक्स में स्टार्टर, लाइट, फ्यूल कटऑफ और हॉर्न के लिए 4/5-पिन रिले लगते हैं; डायोड/रेसिस्टर प्रोटेक्शन अवश्य जांचें।",
                    ar = "تُستخدم المرحلات القياسية ذات 4 أو 5 أطراف في صناديق المصهرات لجميع موديلات JCB وCAT لتشغيل السلف والأضواء وصمام الوقود؛ تأكد من نوع الحماية (مقاومة/دايود)."
                )
            ),
            location = Bilingual(
                en = "Plugged into labeled sockets inside the cabin side fuse/relay console and engine-bay relay box.",
                hi = "कैबिन के साइड फ्यूज बॉक्स और इंजन बे के रिले बॉक्स में कतार से लगे होते हैं।",
                ar = "مثبتة داخل لوحة المصهرات والمرحلات الجانبية بالمقصورة وصندوق حجرة المحرك."
            ),
            workingPrinciple = Bilingual(
                en = "Electromagnetic switch allowing a low-current cabin switch or ECU wire (Pins 85–86 coil) to safely switch high-current loads up to 40A (Pins 30 to 87) without melting dashboard switches.",
                hi = "कैबिन स्विच के हल्के करंट (पिन 85-86) से चुंबक बनाकर भारी करंट (पिन 30 से 87) को सेल्फ या हेडलाइट्स तक भेजता है ताकि स्विच न जलें।",
                ar = "مفتاح كهرومغناطيسي يستخدم تياراً ضعيفاً من مفتاح القيادة (الأطراف 85-86) لإغلاق دائرة تيار عالٍ حتى 40 أمبير (الأطراف 30-87) لحماية المفاتيح."
            ),
            damageSymptoms = listOf(
                Bilingual("Headlights, work lights, starter solenoid, or wiper completely dead despite good fuse", "फ्यूज सही होने पर भी लाइट, वाइपर या सेल्फ न चलना", "توقف الأضواء أو السلف أو المساحات رغم سلامة المصهر"),
                Bilingual("Intermittent circuit failure when machine vibrates or warms up", "मशीन के झटकों में लाइट का बंद-चालू होना", "تقطع عمل الدائرة الكهربائية مع الاهتزاز أو الحرارة"),
                Bilingual("Melted relay socket plastic or pitted burned contacts inside cap", "रिले की जली हुई बदबू या पिघला हुआ प्लास्टिक सॉकेट", "ذوبان قاعدة المرحل البلاستيكية أو احتراق نقاط التلامس")
            ),
            inspectionProcedure = listOf(
                Bilingual("Measure coil resistance across Pins 85 and 86 using multimeter (~70–95 Ohms normal)", "पिन 85 और 86 के बीच रेसिस्टेंस नापें (~70 से 95 ओम होना चाहिए)", "قس مقاومة الملف بين الطرفين 85 و86 بالملتيميتر (الطبيعي 70-95 أوم)"),
                Bilingual("Apply 12V to Pins 85–86 and verify crisp audible CLICK + 0.0 Ohms continuity between Pin 30 and Pin 87", "पिन 85-86 पर 12V देकर 30 और 87 के बीच कंटिन्यूटी चेक करें", "وصل 12 فولت بالطرفين 85 و86 وتأكد من سماع طقة وتوصيل 0 أوم بين 30 و87"),
                Bilingual("Check socket pin tension for loose female terminals causing heat", "रिले बॉक्स के अंदर के पिन ढीले तो नहीं हैं यह भी जांचें", "افحص ضيق أطراف القاعدة في صندوق المصهرات لمنع الحرارة الزائدة")
            ),
            repairInstructions = listOf(
                Bilingual("Swap only with matching pinout and suppression diode/resistor rating (avoid forcing reversed diode relay!)", "हमेशा समान पिनआउट और सही एम्पीयर (40A) का ही नया रिले लगाएं", "استبدله بمرحل مطابق للأطراف وحماية الملف لتجنب تلف وحدة التحكم"),
                Bilingual("Never replace a blowing fuse feeding Pin 30 with a higher amp rating—find the load short first", "पिन 30 का फ्यूज उड़ने पर कभी ज्यादा एम्पीयर का फ्यूज न लगाएं, शॉर्ट सर्किट खोजें", "لا ترفع أبداً أمبير المصهر المغذي للطرف 30؛ عالج القصر الكهربائي أولاً"),
                Bilingual("Apply dielectric grease lightly to exposed engine-bay relay pins to stop corrosion", "इंजन बे के रिले पिंस पर हल्की डाइइलेक्ट्रिक ग्रीस लगाएं", "ضع طبقة خفيفة من شحم العزل الكهربائي على أطراف المرحلات الخارجية لمنع التآكل")
            ),
            safetyWarning = Bilingual(
                en = "WARNING: Never jumper Pin 30 to Pin 87 permanently on safety-interlock circuits (neutral start relay) — bypass allows machine to start in gear!",
                hi = "चेतावनी: न्यूट्रल सेफ्टी रिले के पिन 30 और 87 को कभी तार से डायरेक्ट शॉर्ट न करें!",
                ar = "تحذير: لا تقم أبداً بتوصيل الطرف 30 بالطرف 87 بشكل دائم في دوائر الأمان (مثل مرحل الوضع المحايد للسلف)!"
            ),
            torqueSpec = "Push-fit ISO socket terminal (ensure firm seating)",
            diagramPoints = listOf(
                DiagramPoint(1, "Pin 85 & 86 (Control Coil)", "पिन 85 और 86 (कॉइल)", "Low-current electromagnetic trigger coil", "चुंबक बनाने वाली हल्के करंट की कॉइल", "أطراف الملف 85 و86", "تُفعّل المجال المغناطيسي بتيار منخفض"),
                DiagramPoint(2, "Pin 30 (Common High Feed)", "पिन 30 (मेन 12V इनपुट)", "Fused battery feed entering relay", "फ्यूज से आने वाला भारी 12V करंट", "الطرف 30 (المدخل المشترك)", "تغذية البطارية الرئيسية عبر المصهر"),
                DiagramPoint(3, "Pin 87 (Normally Open Out)", "पिन 87 (आउटपुट लोड)", "Sends 12V to starter/lights when energized", "रिले ऑन होने पर लाइट/मोटर को करंट भेजता है", "الطرف 87 (المخرج المفتوح عادةً)", "يوصل التيار للحمل عند تنشيط المرحل"),
                DiagramPoint(4, "Pin 87a (Normally Closed)", "पिन 87a (बंद स्थिति संपर्क)", "Used for changeover / cutout circuits", "ऑफ स्थिति में जुड़ा रहने वाला पिन", "الطرف 87a (المغلق عادةً)", "يُستخدم في دوائر التحويل أو الفصل")
            ),
            manualReference = "JCB Electrical Wiring & Relay Box Guide Section C"
        ),

        // 15. FILTERS, HOSES, SEALS & CONNECTORS
        JcbPart(
            id = "part_air_filter",
            partNumber = "32/915802 (Outer Primary) + 32/915801 (Inner Safety)",
            system = SystemCategory.FILTERS_HOSES_SEALS,
            nameEn = "Air Filter (Dual-Stage Dry Element)",
            nameHi = "एयर फिल्टर (प्राइमरी व सेफ्टी एलिमेंट)",
            nameAr = "فلتر الهواء",
            imageResId = R.drawable.img_part_air_filter,
            supportedModels = listOf("JCB 3CX", "JCB 4CX", "JCB 3DX", "JCB 5CX", "CAT Backhoe"),
            modelDifferences = listOf(
                Bilingual(
                    en = "PowerCore / RadialSeal housings on EcoMAX 3CX/4CX vs cylindrical dual-cartridge canisters on 3DX and CAT backhoes.",
                    hi = "नए 3CX/4CX में रेडियल-सील / पावरकोर एयर फिल्टर और 3DX/CAT में गोल डबल एलिमेंट फिल्टर लगता है।",
                    ar = "تستخدم 3CX و4CX الحديثة فلاتر RadialSeal أو PowerCore، بينما تستخدم 3DX وCAT حاويات مزدوجة أسطوانية."
                )
            ),
            viewAngles = listOf(
                PartViewAngle(
                    Bilingual("Pleated Paper Media Outer", "बाहरी प्लीटेड फिल्टर जाली", "الشبكة الخارجية والورق المطوي"),
                    Bilingual("Captures heavy quarry & construction site silica dust.", "खदान व साइट की मोटी धूल को बाहर ही रोकता है।", "تحجز الأتربة والغبار الكثيف في مواقع العمل.")
                ),
                PartViewAngle(
                    Bilingual("Inner Radial Rubber Seal Lip", "अंदरूनी रबर सील लिप", "حافة الإحكام المطاطية الداخلية"),
                    Bilingual("Must seal tightly onto intake pipe so dust cannot bypass filter.", "हाउसिंग पाइप पर मजबूती से चिपककर कच्ची हवा को अंदर जाने से रोकती है।", "تُحكم الإغلاق على أنبوب السحب لمنع دخول أي غبار غير مرشح.")
                )
            ),
            location = Bilingual(
                en = "Inside the black cylindrical air cleaner canister located on top-left or front of engine bay.",
                hi = "इंजन बे में ऊपर की तरफ काले गोल एयर क्लीनर डिब्बे के अंदर लगा होता है (बाहरी बड़ा + अंदरूनी छोटा सुरक्षा फिल्टर)।",
                ar = "داخل علبة منقي الهواء السوداء الأسطوانية في أعلى يسار أو مقدمة حجرة المحرك."
            ),
            workingPrinciple = Bilingual(
                en = "Pre-cleaner dust evacuator spins out coarse sand first; the outer primary pleated cellulose filter then traps fine dust while the inner safety element protects the turbo and piston rings if the outer filter is damaged.",
                hi = "साइक्लोन प्री-क्लीनर मोटी रेत झाड़ देता है, बाहरी फिल्टर बारीक धूल छानता है और अंदर का सेफ्टी फिल्टर टर्बो व पिस्टन रिंग को अंतिम सुरक्षा देता है।",
                ar = "يفصل الغبار الخشن أولاً عبر الإعصار، ثم يحجز الفلتر الخارجي الغبار الناعم، بينما يحمي الفلتر الداخلي التيربو والمحرك كصمام أمان."
            ),
            damageSymptoms = listOf(
                Bilingual("Red air-filter restriction indicator light glowing on dashboard", "डैशबोर्ड पर एयर फिल्टर चोक होने की लाल/पीली बत्ती जलना", "إضاءة لمبة تحذير انسداد فلتر الهواء على لوحة القيادة"),
                Bilingual("Heavy black exhaust smoke, sluggish pickup, and high diesel consumption", "काला धुआं आना, इंजन का दबना और डीजल ज्यादा पीना", "دخان أسود كثيف وضعف العزم وزيادة استهلاك الديزل"),
                Bilingual("Dust coating inside turbo intake hose (torn seal or missing inner element)", "टर्बो की इनटेक नली के अंदर धूल जमना (इंजन सीज होने का खतरा)", "وجود أتربة داخل خرطوم سحب التيربو مما يهدد بتلف المحرك")
            ),
            inspectionProcedure = listOf(
                Bilingual("Squeeze rubber dust-unloader valve ('duckbill') daily to dump trapped dry dust", "रोज सुबह एयर क्लीनर के नीचे लगा रबर वाल्व दबाकर धूल झाड़ें", "اضغط على صمام تفريغ الغبار المطاطي يومياً لإخراج الأتربة المتراكمة"),
                Bilingual("Inspect inner filter visually: if dusty, replace BOTH outer & inner immediately", "अगर अंदर का छोटा फिल्टर गंदा दिखे तो दोनों फिल्टर तुरंत बदलें", "افحص الفلتر الداخلي بصرياً؛ وإذا كان متسخاً فاستبدل الفلترين فوراً"),
                Bilingual("Inspect clean-side intake hose clamps for splits before turbocharger", "टर्बो तक जाने वाली हवा की पाइप व क्लैंप में दरार चेक करें", "افحص خراطيم السحب النظيفة ومشابكها قبل التيربو")
            ),
            repairInstructions = listOf(
                Bilingual("NEVER clean the inner safety filter—always replace it new; never tap outer filter on hard tyres (bends seal lip)", "अंदर के सेफ्टी फिल्टर को कभी हवा से साफ न करें और न ही बाहरी फिल्टर को टायर पर पटकें!", "لا تنظف الفلتر الداخلي أبداً (استبدله فقط)، ولا تضرب الفلتر الخارجي لتنظيفه حتى لا يتلف"),
                Bilingual("If gently blowing outer element from INSIDE OUTWARDS, keep air nozzle < 2 bar and 50 mm away (replace after max 3 cleanings or tears)", "बाहरी फिल्टर में हल्की हवा (< 2 बार) अंदर से बाहर की ओर मारें; टॉर्च से छेद न दिखे तभी लगाएं", "إذا نُظف الخارجي بالهواء فيكون بضغط منخفض (< 2 بار) من الداخل للخارج، وافحصه بمصباح"),
                Bilingual("Wipe canister housing interior clean with damp cloth before inserting new elements", "नया फिल्टर डालने से पहले डिब्बे के अंदर की धूल गीले कपड़े से पोंछें", "امسح داخل علبة الفلتر بقطعة قماش مبللة قبل تركيب الفلتر الجديد")
            ),
            safetyWarning = Bilingual(
                en = "CRITICAL: Even a tablespoon of unfiltered fine silica dust ingested by a turbo engine grinds piston rings and cylinder liners out in hours!",
                hi = "सावधानी: बिना छनी हुई थोड़ी सी भी धूल इंजन के अंदर जाने पर कुछ ही घंटों में पिस्टन और रिंग खत्म हो जाते हैं!",
                ar = "تحذير حاسم: دخول كمية بسيطة من الغبار غير المرشح يتلف ريش التيربو وشنابر المكابس خلال ساعات!"
            ),
            torqueSpec = "Canister End Latches: hand-latch flush (verify radial seal seated fully)",
            diagramPoints = listOf(
                DiagramPoint(1, "Outer Primary Pleated Filter", "बाहरी मुख्य फिल्टर", "First stage high-dust capacity element", "मुख्य धूल रोकने वाला बाहरी फिल्टर", "عنصر الفلتر الخارجي الرئيسي", "المرحلة الأولى عالية السعة لحجز الغبار"),
                DiagramPoint(2, "Inner Safety Element", "अंदरूनी सेफ्टी फिल्टर", "Emergency backup protection for engine", "इंजन व टर्बो की अंतिम सुरक्षा परत", "عنصر الأمان الداخلي", "حماية احتياطية للتيربو والمحرك"),
                DiagramPoint(3, "Radial Molded Rubber Seal", "रेडियल रबर सील", "Airtight seal against clean intake tube", "इनटेक पाइप पर एयरटाइट सील", "الحافة المطاطية العازلة", "تُحكم الإغلاق على أنبوب السحب النظيف"),
                DiagramPoint(4, "Perforated Metal Guard", "स्टील जाली सुरक्षा", "Prevents paper collapse under vacuum", "तेज हवा खिंचाव में कागज को फटने से रोकती है", "الشبكة المعدنية الواقية", "تمنع انهيار الورق تحت ضغط الشفط")
            ),
            manualReference = "JCB Operator & Service Manual Section B-2 (Air Intake)"
        ),

        JcbPart(
            id = "part_hydraulic_hose",
            partNumber = "612/10200 Series (SAE 100R2AT / EN 857 2SC Wire-Braided)",
            system = SystemCategory.FILTERS_HOSES_SEALS,
            nameEn = "High-Pressure Hydraulic Hose Assembly",
            nameHi = "हाई-प्रेशर हाइड्रोलिक होज (पाइप)",
            nameAr = "خرطوم هيدروليكي عالي الضغط",
            imageResId = R.drawable.img_part_hydraulic_hose,
            supportedModels = listOf("JCB 3CX", "JCB 4CX", "JCB 3DX", "JCB 5CX", "CAT Backhoe"),
            modelDifferences = listOf(
                Bilingual(
                    en = "JCB uses predominantly BSPP 60° cone swivel fittings (some JIS/JIC on CAT & excavators); ALWAYS match pressure rating (2SC/4SP) and fitting seat angle!",
                    hi = "JCB में मुख्यतः BSPP 60° कोन फिटिंग होती है जबकि CAT में JIC/ORFS हो सकती है; हमेशा सही प्रेशर ग्रेड और थ्रेड मिलाएं।",
                    ar = "تستخدم JCB غالباً وصلات BSPP بزاوية 60 درجة بينما تستخدم CAT وصلات JIC أو ORFS؛ طابق زاوية الجلوس والضغط دائماً."
                )
            ),
            viewAngles = listOf(
                PartViewAngle(
                    Bilingual("Wire-Braided Cover", "स्टील वायर-ब्रेडेड कवर", "الغلاف المقوى بضفائر الفولاذ"),
                    Bilingual("2-wire (2SC) or 4-wire spiral (4SP) steel reinforcement rated > 275–400 bar.", "अंदर 2 या 4 परत स्टील जाली जो 275-400 बार दबाव झेलती है।", "تسليح بضفيرتين أو 4 طبقات فولاذية يتحمل ضغوطاً تتجاوز 275-400 بار.")
                ),
                PartViewAngle(
                    Bilingual("Crimped Swivel End Fitting", "क्रिम्प्ड स्विवेल नट व कोन", "الوصلة المكبوسة الدوارة"),
                    Bilingual("Steel hex swivel nut seats cleanly onto male 60° cone or ORFS O-ring face.", "सही कोन या ओ-रिंग सीट पर कसकर लीकेज रोकता है।", "صامولة سداسية دوارة تحكم الإغلاق على مخروط التوصيل أو حلقة الأورينج.")
                )
            ),
            location = Bilingual(
                en = "Routed along the front loader arms, inside the kingpost, along the backhoe boom/dipper, and between main pump and valve bank.",
                hi = "लोडर आर्म्स, किंगपोस्ट के अंदर, बूम-डिपर पर और पंप से कंट्रोल वॉल्व के बीच बिछे होते हैं।",
                ar = "ممددة على طول أذرع المحمل الأمامي وداخل نقطة الارتكاز وعلى ذراع الحفار الخلفي ومن المضخة للموزع."
            ),
            workingPrinciple = Bilingual(
                en = "Flexible multi-layer steel-wire reinforced conduit transmitting pressurized hydraulic oil at ~230–350 bar across articulating joints without bursting.",
                hi = "लचीली स्टील-तार वाली नली जो मुड़ने वाले जोड़ों पर भी 250-350 बार के भारी तेल के दबाव को बिना फटे आगे पहुंचाती है।",
                ar = "قناة مرنة مسلحة بأسلاك الفولاذ لنقل الزيت الهيدروليكي عالي الضغط عبر المفاصل المتحركة دون انفجار."
            ),
            damageSymptoms = listOf(
                Bilingual("Blistered outer rubber cover, exposed rusted steel braid, or weeping at crimp ferrule", "रबर कटकर अंदर की लोहे की जाली दिखना या क्रिम्प जोड़ से तेल रिसना", "تشقق الغلاف الخارجي وظهور الأسلاك الصدئة أو تنديع الزيت عند الكبس"),
                Bilingual("Sudden catastrophic hose burst spraying hydraulic mist across machine", "अचानक पाइप फटना और सारा हाइड्रोलिक तेल बह जाना", "انفجار مفاجئ للخرطوم وفقدان الزيت الهيدروليكي"),
                Bilingual("Kinked or crushed suction hose causing pump cavitation whine", "मुड़े या पिचके पाइप से पंप में आवाज आना", "انثناء خرطوم السحب مما يسبب تجويفاً وصفيراً في المضخة")
            ),
            inspectionProcedure = listOf(
                Bilingual("Inspect outer sheath along clamp brackets and kingpost pivot weekly for chafing", "किंगपोस्ट और क्लैंप के पास पाइपों का रगड़ खाकर कटना जांचें", "افحص الخراطيم أسبوعياً عند نقاط الاحتكاك والمشابك"),
                Bilingual("Inspect crimped steel ferrules with clean paper card (NEVER bare hand!)", "क्रिम्प किए हुए सिरे को कागज के टुकड़े से चेक करें (हाथ से नहीं!)", "استخدم قطعة ورق مقوى للكشف عن التسربات الدقيقة ولا تستخدم اليد أبداً!"),
                Bilingual("Verify protective nylon burst sleeves around hoses near cabin operator area", "कैबिन के पास वाले पाइपों पर सुरक्षा नायलॉन स्लीव लगी हो यह जांचें", "تأكد من وجود أكمام الحماية القماشية على الخراطيم القريبة من المشغل")
            ),
            repairInstructions = listOf(
                Bilingual("ALWAYS drop boom & shovel to ground and relieve pressure before loosening any hydraulic hose", "कोई भी पाइप खोलने से पहले बूम व लोडर जमीन पर रखकर प्रेशर खत्म करें", "أنزل الجرافة والحفار للأرض وفرّغ الضغط بالكامل قبل فك أي خرطوم"),
                Bilingual("Cap open steel ports immediately with plastic plugs to keep sand out of valve bank", "खुले हुए पाइप और पोर्ट पर तुरंत साफ प्लग लगाएं ताकि रेत अंदर न जाए", "سد الفتحات المكشوفة فوراً بأغطية نظيفة لمنع دخول الأتربة للنظام"),
                Bilingual("Route replacement hose without twist (alignment layline straight) and re-fit spiral abrasion guards", "नया पाइप बिना ऐंठे सीधा बैठाएं और स्प्रिंग/नायलॉन कवर दोबारा लगाएं", "ركب الخرطوم الجديد دون التواء مع إعادة تركيب أغطية الحماية والكلبسات")
            ),
            safetyWarning = Bilingual(
                en = "FATAL HAZARD: A pinhole leak at 250 bar injects toxic oil deep under human skin—requires emergency surgery within hours! ALWAYS use cardboard/wood to locate leaks.",
                hi = "जानलेवा खतरा: 250 बार का बारीक तेल का फव्वारा चमड़ी के अंदर घुसकर जहर फैला देता है! लीकेज देखने के लिए हमेशा गत्ते का टुकड़ा प्रयोग करें।",
                ar = "خطر مميت: تسرب إبرة بضغط 250 بار يخترق الجلد فوراً ويسبب تسمماً وبتر الأنسجة! استخدم الكرتون أو الخشب فقط لفحص التسربات."
            ),
            torqueSpec = "Tighten swivel fitting snug plus 1/6 to 1/4 turn with dual counter-wrenches",
            diagramPoints = listOf(
                DiagramPoint(1, "Synthetic Oil-Resistant Inner Tube", "अंदरूनी तेल-रोधी रबर ट्यूब", "Carries hot VG46/68 hydraulic fluid", "गर्म हाइड्रोलिक तेल ले जाने वाली अंदरूनी नली", "الأنبوب الداخلي المقاوم للزيت", "ينقل الزيت الهيدروليكي الساخن"),
                DiagramPoint(2, "High-Tensile Steel Wire Braid", "स्टील तार की जाली (2SC/4SP)", "Handles 250–350+ bar burst pressure", "भारी दबाव झेलने वाली स्टील जाली", "ضفيرة الأسلاك الفولاذية", "تتحمل الضغوط التشغيلية والانفجارية العالية"),
                DiagramPoint(3, "Abrasion-Resistant Outer Cover", "बाहरी सुरक्षा रबर परत", "Shields braid from weather and rock scrapes", "पत्थर व धूप से बचाने वाली बाहरी परत", "الغلاف الخارجي المقاوم للتآكل", "يحمي الضفيرة من الصدمات والاحتكاك"),
                DiagramPoint(4, "Swaged Steel JIC/BSPP Swivel", "क्रिम्प्ड स्विवेल फिटिंग", "Leak-free threaded connector end", "लीकेज-रहित पक्की क्रिम्प फिटिंग", "الوصلة السداسية المكبوسة", "نهاية التوصيل المحكمة على الموزع أو الأسطوانة")
            ),
            manualReference = "JCB Hydraulic Hose Routing & Pressure Spec Section E"
        ),

        JcbPart(
            id = "part_seal_kit",
            partNumber = "991/00100 – 991/20030 Series (Match Rod x Bore Size)",
            system = SystemCategory.FILTERS_HOSES_SEALS,
            nameEn = "Hydraulic Cylinder Seal Kit",
            nameHi = "हाइड्रोलिक सिलेंडर सील किट",
            nameAr = "طقم موانع تسرب هيدروليكي (كت بستم)",
            imageResId = R.drawable.img_part_seal_kit,
            supportedModels = listOf("JCB 3CX", "JCB 4CX", "JCB 3DX", "JCB 5CX", "CAT Backhoe"),
            modelDifferences = listOf(
                Bilingual(
                    en = "Every ram (Lift, Crowd, Boom, Dipper, Bucket, Slew, Stabilizer, Steer) has a distinct Rod × Bore mm seal kit; verify machine serial & ram stamp before ordering.",
                    hi = "लोडर, बूम, डिपर, बकेट और स्टीयरिंग के हर सिलेंडर का रॉड और बोर साइज अलग होता है; ऑर्डर से पहले मशीन सीरियल व रॉड साइज जरूर नापें।",
                    ar = "كل أسطوانة لها مقاس ذراع × قطر داخلي خاص بها؛ تأكد من الرقم التسلسلي ومقاس البستم بالملم قبل الطلب."
                )
            ),
            location = Bilingual(
                en = "Installed inside hydraulic cylinder gland head and piston grooves.",
                hi = "हाइड्रोलिक सिलेंडर के ग्लैंड नट और अंदरूनी पिस्टन खांचों में फिट होते हैं।",
                ar = "تُركب داخل رأس السد الخارجي وأخاديد المكبس الداخلي للأسطوانة الهيدروليكية."
            ),
            workingPrinciple = Bilingual(
                en = "Precision elastomeric & PTFE sealing system: polyurethane U-cup rod seals hold high pressure around the moving chrome rod, metal-clad wiper scrapes external mud off, bronze wear rings prevent steel-to-steel piston scoring, and bidirectional piston seal holds load.",
                hi = "पॉलीयूरेथेन सील उच्च दबाव को बाहर निकलने से रोकती है, वाइपर सील बाहर से मिट्टी को अंदर जाने से रोकती है और वियर रिंग लोहे को लोहे से रगड़ने से बचाती है।",
                ar = "مجموعة إحكام متكاملة: سداد الذراع يمنع تسرب الضغط للخارج، الكاشطة تمنع دخول الطين، حلقات التوجيه تمنع احتكاك المعدن، وسداد المكبس يمنع الهبوط."
            ),
            damageSymptoms = listOf(
                Bilingual("Oil film or steady dripping running down chrome cylinder rod", "क्रोम रॉड से तेल बहकर नीचे गिरना", "تسرب وتقطير الزيت على الذراع الكرومي"),
                Bilingual("Cylinder drifting down overnight or under suspended bucket load", "लोड उठाकर रखने पर बूम या लोडर का धीरे-धीरे नीचे गिरना", "هبوط الذراع أو الدلو تلقائياً تحت الحمل"),
                Bilingual("Extruded blue polyurethane shreds pushing out around gland wiper", "ग्लैंड नट के पास नीली या काली सील के टुकड़े बाहर दिखना", "خروج أجزاء ممزقة من السدادات حول غطاء الذراع")
            ),
            inspectionProcedure = listOf(
                Bilingual("Confirm rod diameter & barrel bore diameter with vernier caliper before opening kit", "वर्नियर कैलिपर से रॉड की मोटाई नापकर सही किट मिलाएं", "قس قطر الذراع والأسطوانة بالقدمة ذات الورنية لمطابقة الطقم"),
                Bilingual("Inspect seal grooves on piston and gland for burrs or metal embedment", "पिस्टन और ग्लैंड नट के खांचों में लोहे की खुरदरी धार जांचें", "افحص مجاري السدادات في المكبس والغطاء بحثاً عن شوائب أو نتوءات"),
                Bilingual("Inspect chrome rod for sharp stone chips that will slice a new seal instantly", "रॉड पर गहरी खरोंच देखें क्योंकि तेज धार नई सील को तुरंत काट देती है", "تأكد من خلو الذراع من الخدوش الحادة التي تمزق السداد الجديد فوراً")
            ),
            repairInstructions = listOf(
                Bilingual("Verify U-cup seal lip direction! Pressure lip MUST face inward toward hydraulic oil pressure", "सील का मुंह (लिप) हमेशा अंदर प्रेशर की तरफ रखें; उल्टी सील लगाने पर तुरंत लीक होगी!", "تأكد من اتجاه شفة السداد! يجب أن تتجه شفة الضغط نحو داخل غرفة الزيت دائماً"),
                Bilingual("Soften stiff PTFE piston rings in warm hydraulic oil (~50°C) before stretching over piston, then size back down with ring compressor", "सख्त टेफ्लॉन रिंग को हल्के गर्म तेल में नरम करके पिस्टन पर चढ़ाएं", "ليّن حلقة PTFE الدائرية في زيت دافئ (~50 م°) لسهولة تركيبها دون كسر"),
                Bilingual("Use clean hydraulic oil—never heavy grease—on dynamic gland & piston seals during assembly", "सील लगाते समय केवल साफ हाइड्रोलिक तेल लगाएं", "شحّم السدادات بزيت هيدروليكي نظيف عند التجميع")
            ),
            safetyWarning = Bilingual(
                en = "WARNING: Sharp gland threads slice new rod seals easily! Always tape over threads or use a plastic seal bullet protector when sliding gland onto rod.",
                hi = "चेतावनी: सिलेंडर रॉड की चूड़ियों पर टेप लगाकर ही ग्लैंड नट चढ़ाएं वरना नई सील कट जाएगी!",
                ar = "تحذير: غطِّ أسنان القلاووظ بشريط واقٍ أثناء إدخال الغطاء حتى لا تقطع السدادات الجديدة!"
            ),
            torqueSpec = "Follow OEM cylinder bore manual for piston & gland nut torques",
            diagramPoints = listOf(
                DiagramPoint(1, "Polyurethane U-Cup Rod Seal", "यू-कप रॉड सील", "Holds high pressure at gland neck", "ग्लैंड नट में प्रेशर रोकने वाली मुख्य सील", "سداد الذراع البولي يوريثان", "يحجز الضغط العالي عند عنق الغطاء"),
                DiagramPoint(2, "Double-Lip Dust Wiper", "डस्ट वाइपर सील", "Scrapes sand & mud off retracting rod", "अंदर जाती रॉड से धूल-मिट्टी पोंछती है", "حلقة الكاشطة المزدوجة", "تنظف الذراع من الطين والأتربة"),
                DiagramPoint(3, "Wear Guide Rings (PTFE/Bronze)", "वियर गाइड रिंग", "Centers piston & prevents cylinder scoring", "लोहे को लोहे से रगड़ने से बचाती है", "حلقات التوجيه والاهتراء", "تمنع احتكاك المكبس المعدني بجدار الأسطوانة"),
                DiagramPoint(4, "Static O-Rings & Backup Rings", "ओ-रिंग व बैकअप रिंग", "Seals stationary gland barrel threads", "ग्लैंड बॉडी के किनारों से लीकेज रोकती है", "حلقات الأورينج والظهر", "تمنع التسرب حول جسم الغطاء الخارجي")
            ),
            manualReference = "JCB Hydraulic Cylinder Overhaul Manual Section E-4"
        )
    )
}
