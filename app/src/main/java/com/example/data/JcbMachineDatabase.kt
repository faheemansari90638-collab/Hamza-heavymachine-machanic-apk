package com.example.data

import com.example.model.*

object JcbMachineDatabase {

    val machines: List<JcbMachineModel> = listOf(
        JcbMachineModel(
            id = "jcb_3cx",
            name = "JCB 3CX Eco / Plus",
            series = "World #1 Backhoe Loader Series",
            category = "Backhoe Loader",
            tagHindi = "विश्व का सबसे लोकप्रिय बैकहो लोडर",
            tagArabic = "الحفار اللودر الأكثر انتشاراً عالمياً",
            engineSpec = Bilingual(
                en = "JCB EcoMAX 4.4L 4-Cylinder Turbocharged Diesel, 55kW (74hp) to 81kW (109hp)",
                hi = "जेसीबी इकोमैक्स 4.4 लीटर 4-सिलेंडर टर्बोचार्ज्ड डीजल इंजन, 55kW (74hp) से 81kW (109hp)",
                ar = "محرك ديزل تيربو JCB EcoMAX سعة 4.4 لتر 4 أسطوانات، قدرة 55kW (74 حصان) إلى 81kW (109 حصان)"
            ),
            powerHp = "74 - 109 HP",
            operatingWeight = "8,135 kg (approx)",
            hydraulicPressureBar = "251 bar (3640 psi)",
            transmissionType = Bilingual(
                en = "JCB Powershift / Syncroshuttle 4-speed 4WD",
                hi = "जेसीबी पावरशिफ्ट / सिंक्रोशटल 4-स्पीड 4-व्हील ड्राइव",
                ar = "ناقل حركة JCB Powershift / Syncroshuttle أربع سرعات دفع رباعي 4WD"
            ),
            keyFeatures = listOf(
                Bilingual(
                    "TorqueLock system reducing fuel consumption by up to 25%",
                    "टॉर्कलॉक प्रणाली जो ईंधन की 25% तक बचत करती है",
                    "نظام TorqueLock لقفل محول العزم وتوفير الوقود بنسبة تصل إلى 25%"
                ),
                Bilingual(
                    "SmoothRide System (SRS) for loader arm suspension",
                    "स्मूथराइड सिस्टम (SRS) जो लोडर आर्म को झटकों से बचाता है",
                    "نظام امتصاص الصدمات (SRS) لذراع المحمل الأمامي أثناء السير"
                ),
                Bilingual(
                    "Extradig telescopic dipper extending dig depth to 5.46m",
                    "एक्स्ट्राडिग टेलीस्कोपिक डिपर जो 5.46 मीटर गहराई तक खुदाई करता है",
                    "ذراع حفر تلسكوبي Extradig يزيد عمق الحفر حتى 5.46 متر"
                )
            ),
            commonApplications = Bilingual(
                en = "Trenching, road construction, urban civil infrastructure, agricultural excavation",
                hi = "नाली खुदाई, सड़क निर्माण, शहरी सिविल कार्य, कृषि एवं पाइपलाइन खुदाई",
                ar = "حفر الخنادق، إنشاء الطرق، البنية التحتية، والأعمال الزراعية ومد الأنابيب"
            ),
            maintenanceIntervalHours = "Engine oil: 500 hrs | Hydraulic oil: 2000 hrs | Greasing: 10/50 hrs",
            manualReference = "JCB Service Manual 9803/3290 Section B (Engine) & E (Hydraulics)"
        ),
        JcbMachineModel(
            id = "jcb_3dx",
            name = "JCB 3DX Super / Xtra",
            series = "India & Global Heavy Duty Series",
            category = "Backhoe Loader",
            tagHindi = "भारत और एशिया में सबसे ज्यादा बिकने वाला मॉडल",
            tagArabic = "سلسلة الخدمة الشاقة الأكثر مبيعاً في آسيا والشرق الأوسط",
            engineSpec = Bilingual(
                en = "JCB 448 naturally aspirated / turbocharged diesel, 36kW (49hp) to 55kW (74hp)",
                hi = "जेसीबी 448 नैचुरली एस्पिरेटेड / टर्बोचार्ज्ड डीजल, 36kW से 55kW (74 एचपी)",
                ar = "محرك ديزل JCB 448 سحب طبيعي أو تيربو، قدرة 36kW (49 حصان) إلى 55kW (74 حصان)"
            ),
            powerHp = "49 - 74 HP (CEV Stage IV compliant)",
            operatingWeight = "7,460 - 7,800 kg",
            hydraulicPressureBar = "225 - 250 bar",
            transmissionType = Bilingual(
                en = "JCB Synchroshuttle transmission with torque converter",
                hi = "जेसीबी सिंक्रोशटल ट्रांसमिशन विथ टॉर्क कनवर्टर",
                ar = "ناقل حركة JCB Synchroshuttle مع محول عزم (بطيخة)"
            ),
            keyFeatures = listOf(
                Bilingual(
                    "IntelliControl telematics and multi-mode economy settings",
                    "इंटेलीकंट्रोल टेलीमैटिक्स और इकोनॉमी वर्किंग मोड",
                    "نظام IntelliControl مع أوضاع تشغيل اقتصادية متعددة"
                ),
                Bilingual(
                    "Heavy duty Banjo rear axle with internal wet disc brakes",
                    "हैवी ड्यूटी बैंजो रियर एक्सल विथ वेट डिस्क ब्रेक्स",
                    "محور خلفي للخدمة الشاقة مع فرامل أقراص مغمورة بالزيت"
                ),
                Bilingual(
                    "High breakout forces: Shovel 6500 kgf, Bucket 5700 kgf",
                    "मजबूत ब्रेकआउट फ़ोर्स: बकेट 5700 kgf, लोडर 6500 kgf",
                    "قوة اقتلاع عالية: الجرافة 6500 كجم، قادوس الحفار 5700 كجم"
                )
            ),
            commonApplications = Bilingual(
                en = "Brick kilns, quarry handling, general civil contracting, earthmoving",
                hi = "ईंट भट्ठे, पत्थर खदान, सामान्य सिविल ठेकेदारी, मिट्टी भराई व खुदाई",
                ar = "المقاولات العامة، المحاجر، أعمال الردم والتسوية وحفر الأساسات"
            ),
            maintenanceIntervalHours = "Engine oil: 500 hrs | Transmission oil: 1000 hrs | Hydraulic: 2000 hrs",
            manualReference = "JCB 3DX Operator & Workshop Manual 9813/4100"
        ),
        JcbMachineModel(
            id = "jcb_4cx",
            name = "JCB 4CX Wastemaster / Super",
            series = "All-Wheel Steer Heavy Duty Backhoe",
            category = "Backhoe Loader",
            tagHindi = "4-व्हील स्टीयर और चारों पहिए समान आकार के",
            tagArabic = "حفار لودر رباعي التوجيه بأربع عجلات متساوية الحجم",
            engineSpec = Bilingual(
                en = "JCB EcoMAX 81kW (109hp) Turbocharged with variable geometry turbo",
                hi = "जेसीबी इकोमैक्स 81kW (109 एचपी) टर्बोचार्ज्ड वेरिएबल ज्योमेट्री टर्बो",
                ar = "محرك JCB EcoMAX قدرة 81kW (109 حصان) مع تيربو متغير الهندسة"
            ),
            powerHp = "109 HP",
            operatingWeight = "8,800 kg",
            hydraulicPressureBar = "251 bar with variable displacement piston pump",
            transmissionType = Bilingual(
                en = "6-speed Autoshift with automatic lock-up torque converter",
                hi = "6-स्पीड ऑटोशिफ्ट ट्रांसमिशन विथ ऑटोमैटिक लॉकअप टॉर्क कनवर्टर",
                ar = "ناقل حركة أوتوماتيكي Autoshift بـ 6 سرعات مع قفل محول العزم"
            ),
            keyFeatures = listOf(
                Bilingual(
                    "4 equal sized wheels offering maximum ground clearance and flotation",
                    "चारों बराबर आकार के टायर जो दलदली जमीन पर अधिक ग्रिप देते हैं",
                    "أربع عجلات متساوية الحجم لتوفير أقصى خلوص أرضي وثبات في الأوحال"
                ),
                Bilingual(
                    "3 steering modes: 2WS, 4WS (tight turn) and Crab steer",
                    "3 स्टीयरिंग मोड: 2-व्हील, 4-व्हील (कम जगह में मुड़ना) और क्रैब स्टीयर",
                    "3 أنماط توجيه: ثنائي العجلات، رباعي للالتفاف الضيق، وتوجيه سلطعوني (Crab)"
                ),
                Bilingual(
                    "High flow auxiliary hydraulics (165 L/min)",
                    "हाई फ्लो ऑक्जिलरी हाइड्रोलिक्स (165 लीटर/मिनट)",
                    "تدفق هيدروليكي عالي الأداء (165 لتر/دقيقة)"
                )
            ),
            commonApplications = Bilingual(
                en = "Forestry, waste recycling, mining support, snow clearance, heavy excavation",
                hi = "वन विभाग, कचरा निस्तारण, खनन कार्य, बर्फ हटाना, भारी खुदाई",
                ar = "التعدين، إعادة التدوير، شق الطرق الوعرة، وأعمال الحفر الثقيلة"
            ),
            maintenanceIntervalHours = "Engine oil: 500 hrs | Axle oil: 1000 hrs | Hydraulic filters: 500 hrs",
            manualReference = "JCB Service Manual Publication 9803/3280"
        ),
        JcbMachineModel(
            id = "jcb_5cx",
            name = "JCB 5CX Wastemaster Pro",
            series = "Flagship Maximum Performance Series",
            category = "Backhoe Loader",
            tagHindi = "जेसीबी का सबसे शक्तिशाली और सबसे बड़ा बैकहो मॉडल",
            tagArabic = "أقوى وأكبر حفار لودر في فئة JCB للأعمال الشاقة",
            engineSpec = Bilingual(
                en = "JCB EcoMAX Tier 4 Final, 87kW (118hp) High Output Diesel",
                hi = "जेसीबी इकोमैक्स टियर 4 फाइनल, 87kW (118 एचपी) हाई आउटपुट डीजल",
                ar = "محرك ديزل عالي الأداء JCB EcoMAX Tier 4 بقدرة 87kW (118 حصان)"
            ),
            powerHp = "118 HP",
            operatingWeight = "9,810 kg",
            hydraulicPressureBar = "255 bar with 165 L/min Axial Piston Pump",
            transmissionType = Bilingual(
                en = "JCB 6-speed Automatic with TorqueLock in top gears",
                hi = "जेसीबी 6-स्पीड ऑटोमैटिक ट्रांसमिशन विथ टॉप गियर टॉर्कलॉक",
                ar = "ناقل حركة JCB أوتوماتيكي بـ 6 سرعات مع TorqueLock"
            ),
            keyFeatures = listOf(
                Bilingual(
                    "Massive 1.3 m³ front shovel bucket capacity",
                    "विशाल 1.3 क्यूबिक मीटर फ्रंट लोडर बकेट क्षमता",
                    "سعة جرافة أمامية ضخمة تصل إلى 1.3 متر مكعب"
                ),
                Bilingual(
                    "Extended reach backhoe with 6.51m reach from slew center",
                    "स्लीव सेंटर से 6.51 मीटर तक लंबी पहुंच वाला बैकहो बूम",
                    "مدى وصول حفار خلفي ممتد إلى 6.51 متر"
                ),
                Bilingual(
                    "Heavy duty reinforced D-box subframe and structural booms",
                    "अत्यधिक मजबूत डी-बॉक्स सबफ्रेम और रिइन्फोर्स्ड बूम आर्म",
                    "شاسيه صندوقي مقوى وأذرع حفر معززة للخدمة القاسية"
                )
            ),
            commonApplications = Bilingual(
                en = "Heavy bulk material handling, quarrying, scrap recycling, demolition",
                hi = "भारी माल ढुलाई, खदान कार्य, स्क्रैप रिसाइकिलिंग, डिमोलिशन कार्य",
                ar = "مناولة المواد السائبة، المحاجر، الهدم، وإعادة تدوير الخردة"
            ),
            maintenanceIntervalHours = "Engine oil: 500 hrs | Transmission: 1000 hrs | Slew ring grease: 250 hrs",
            manualReference = "JCB 5CX Technical Service Manual 9813/1800"
        ),
        JcbMachineModel(
            id = "jcb_2dx",
            name = "JCB 2DX / 2CX Compact",
            series = "Compact Maneuverable Backhoe Loader",
            category = "Compact Backhoe",
            tagHindi = "तंग गलियों और छोटे प्रोजेक्ट्स के लिए कॉम्पैक्ट मॉडल",
            tagArabic = "حفار لودر مدمج للممرات الضيقة والمشاريع الحضرية",
            engineSpec = Bilingual(
                en = "Kirloskar / Perkins 4-cylinder water cooled diesel, 36.4kW (49.5hp)",
                hi = "किरलोस्कर / पर्किन्स 4-सिलेंडर वाटर कूल्ड डीजल इंजन, 36.4kW (49.5 एचपी)",
                ar = "محرك ديزل 4 أسطوانات مبرد بالماء (Perkins/Kirloskar) بقدرة 36.4kW (49.5 حصان)"
            ),
            powerHp = "49.5 HP",
            operatingWeight = "5,450 kg",
            hydraulicPressureBar = "210 bar",
            transmissionType = Bilingual(
                en = "Synchromesh 4-speed shuttle transmission",
                hi = "सिंक्रोमेश 4-स्पीड शटल ट्रांसमिशन",
                ar = "ناقل حركة مكوكي 4 سرعات متزامن"
            ),
            keyFeatures = listOf(
                Bilingual(
                    "Ultra-compact footprint under 2 meters width for narrow alleys",
                    "2 मीटर से कम चौड़ाई, संकरी गलियों और शहरों के लिए उपयुक्त",
                    "عرض مدمج أقل من مترين للمناورة داخل الأزقة الضيقة"
                ),
                Bilingual(
                    "Low operational fuel consumption (3.5 - 4.5 L/hr)",
                    "बेहद कम डीजल खपत (3.5 से 4.5 लीटर प्रति घंटा)",
                    "استهلاك وقود منخفض جداً (3.5 - 4.5 لتر/ساعة)"
                ),
                Bilingual(
                    "Standard side-shift backhoe carriage for digging against walls",
                    "दीवार के बिल्कुल करीब खुदाई हेतु साइड-शिफ्ट कैरिज",
                    "عربة حفار بانزلاق جانبي للحفر بمحاذاة الجدران"
                )
            ),
            commonApplications = Bilingual(
                en = "City municipality drain cleaning, cable laying, small farm operations",
                hi = "नगर पालिका नाला सफाई, केबल बिछाना, छोटे कृषि कार्य, बेसमेंट खुदाई",
                ar = "أعمال البلديات، تمديد الكابلات، حفر الأقبية، والمزارع الصغيرة"
            ),
            maintenanceIntervalHours = "Engine oil: 250/500 hrs | Fuel filter: 250 hrs | Hydraulic: 1500 hrs",
            manualReference = "JCB 2DX/2CX Workshop Manual 9803/6120"
        ),
        JcbMachineModel(
            id = "jcb_nxt",
            name = "JCB NXT Series (NXT 215 / 225)",
            series = "Heavy Tracked Excavator Series",
            category = "Tracked Excavator",
            tagHindi = "नेक्स्ट जेनरेशन हैवी ट्रैक एक्सकेवेटर",
            tagArabic = "حفار مجنزر ثقيل من الجيل الجديد",
            engineSpec = Bilingual(
                en = "Cummins 6BT 5.9L / JCB EcoMAX 4.8L Common Rail Diesel, 104kW to 130kW",
                hi = "कमिंस 6BT 5.9 लीटर / जेसीबी इकोमैक्स 4.8L कॉमन रेल डीजल, 140 से 175 एचपी",
                ar = "محرك ديزل كمنز 6BT 5.9L أو JCB EcoMAX 4.8L كومن ريل (140 - 175 حصان)"
            ),
            powerHp = "140 - 175 HP",
            operatingWeight = "21,500 - 22,500 kg",
            hydraulicPressureBar = "343 bar (373 bar with Power Boost)",
            transmissionType = Bilingual(
                en = "2-speed axial piston track drive motors with planetary reduction",
                hi = "2-स्पीड एक्सियल पिस्टन ट्रैक ड्राइव मोटर विथ प्लेनेटरी रिडक्शन",
                ar = "مواتير دفع جنزير مكبسية بسرعتين مع تروس كوكبية"
            ),
            keyFeatures = listOf(
                Bilingual(
                    "Kawasaki dual variable displacement pumps delivering 2x 228 L/min",
                    "कावासाकी डुअल वेरिएबल पंप जो 2x 228 लीटर/मिनट फ्लो देते हैं",
                    "طرمبة كاواساكي مزدوجة متغيرة الإزاحة بتدفق 2x 228 لتر/دقيقة"
                ),
                Bilingual(
                    "X-frame undercarriage with reinforced track rollers and idlers",
                    "हैवी ड्यूटी एक्स-फ्रेम अंडरकैरिज विथ मजबूत ट्रैक रोलर्स",
                    "هيكل سفلي بشكل X مع بكرات وجنازير مقواة للخدمة الصخرية"
                ),
                Bilingual(
                    "8 working modes: Power+, Power, Eco, Hammer, Attachment modes",
                    "8 वर्किंग मोड्स: पावर+, पावर, इको, ब्रेकर और अटैचमेंट मोड्स",
                    "8 أوضاع تشغيل تشمل القوة الفائقة، الاقتصادي، والدقاق (Hammer)"
                )
            ),
            commonApplications = Bilingual(
                en = "Canal digging, highway stone cutting, deep rock excavation, mining quarrying",
                hi = "नहर खुदाई, हाईवे पत्थर कटाई, गहरी चट्टान खुदाई, खदान व क्रशर लोडिंग",
                ar = "حفر القنوات، تكسير الصخور، شق الطرق السريعة، والمناجم"
            ),
            maintenanceIntervalHours = "Engine oil: 500 hrs | Hydraulic oil: 5000 hrs | Swing gearbox: 1000 hrs",
            manualReference = "JCB NXT Crawler Excavator Service Manual 9813/6400"
        ),
        JcbMachineModel(
            id = "jcb_wheel_loader",
            name = "JCB 432ZX / 437ZX Wheel Loader",
            series = "Front Wheel Loader Loading Master",
            category = "Wheel Loader",
            tagHindi = "हैवी फ्रंट व्हील लोडर क्रशर और स्टोन लोडिंग मास्टर",
            tagArabic = "شيول تحميل أمامي ثقيل للكسارات والمواد السائبة",
            engineSpec = Bilingual(
                en = "Cummins 6-cylinder 6.7L Turbocharged Diesel, 112kW (150hp) to 136kW",
                hi = "कमिंस 6-सिलेंडर 6.7 लीटर टर्बोचार्ज्ड डीजल इंजन, 150 से 183 एचपी",
                ar = "محرك ديزل كمنز 6 أسطوانات سعة 6.7 لتر تيربو (150 - 183 حصان)"
            ),
            powerHp = "150 - 183 HP",
            operatingWeight = "11,800 - 15,200 kg",
            hydraulicPressureBar = "250 bar Load-sensing Variable Displacement",
            transmissionType = Bilingual(
                en = "ZF 4-speed automatic powershift transmission with kick-down",
                hi = "ZF 4-स्पीड ऑटोमैटिक पावरशिफ्ट ट्रांसमिशन विथ किक-डाउन",
                ar = "ناقل حركة ZF أوتوماتيكي Powershift بأربع سرعات"
            ),
            keyFeatures = listOf(
                Bilingual(
                    "Z-bar loader linkage delivering unmatched breakout crowd force",
                    "जेड-बार लोडर लिंकेज जो पत्थरों में सबसे तेज ब्रेकआउट देता है",
                    "ذراع تحميل بنظام Z-bar يعطي أقصى قوة اقتلاع وتعبئة"
                ),
                Bilingual(
                    "Heavy duty ZF axles with Limited Slip Differentials (LSD)",
                    "ZF हैवी ड्यूटी एक्सल विथ लिमिटेड स्लिप डिफरेंशियल",
                    "محاور ZF للخدمة الشاقة مع دفرنس محدود الانزلاق (LSD)"
                ),
                Bilingual(
                    "Bucket capacity range from 2.1 m³ to 2.7 m³ high-fill",
                    "2.1 से 2.7 क्यूबिक मीटर हाई-कैपेसिटी लोडर बकेट",
                    "سعة القادوس من 2.1 إلى 2.7 متر مكعب"
                )
            ),
            commonApplications = Bilingual(
                en = "Crusher hopper loading, aggregate loading, cement plant bulk stockpiling",
                hi = "क्रशर हॉपर फीडिंग, गिट्टी लोडिंग, सीमेंट प्लांट, रेत व बजरी डंपिंग",
                ar = "تغذية الكسارات، تحميل الحصى والرمل، ومصانع الإسمنت"
            ),
            maintenanceIntervalHours = "Engine oil: 500 hrs | Axles & hubs: 1000 hrs | Transmission: 1000 hrs",
            manualReference = "JCB Wheeled Loader Service Manual 9803/4200"
        ),
        JcbMachineModel(
            id = "jcb_skid_steer",
            name = "JCB 135 / 155 / 190 Robot Skid Steer",
            series = "PowerBoom Single-Arm Skid Steer",
            category = "Skid Steer Loader",
            tagHindi = "सिंगल पावरबूम और साइड डोर एंट्री वाला रोबोट लोडर",
            tagArabic = "بوبكات (Skid Steer) بذراع PowerBoom أحادي وباب جانبي آمن",
            engineSpec = Bilingual(
                en = "Perkins / Kohler 4-cylinder naturally aspirated or turbo diesel, 36kW (48hp)",
                hi = "पर्किन्स / कोहलर 4-सिलेंडर डीजल इंजन, 36kW (48 एचपी)",
                ar = "محرك ديزل Perkins / Kohler أربع أسطوانات، قدرة 36kW (48-60 حصان)"
            ),
            powerHp = "48 - 60 HP",
            operatingWeight = "2,790 - 3,120 kg",
            hydraulicPressureBar = "230 bar (Aux flow 70-100 L/min)",
            transmissionType = Bilingual(
                en = "Hydrostatic dual variable displacement piston pumps with hydraulic motors",
                hi = "हाइड्रोस्टैटिक डुअल वेरिएबल पिस्टन पंप विथ डायरेक्ट ड्राइव मोटर",
                ar = "مضخات هيدروستاتيكية مزدوجة مع محركات دفع هيدروليكية مباشرة"
            ),
            keyFeatures = listOf(
                Bilingual(
                    "Unique single JCB PowerBoom allowing safe side-door cabin entry",
                    "अनोखा सिंगल पावरबूम जिससे साइड का सुरक्षित दरवाजा मिलता है",
                    "ذراع أحادي PowerBoom يتيح دخولاً جانبياً آمناً للمقصورة"
                ),
                Bilingual(
                    "Zero turning radius: turns 360 degrees on its own axis",
                    "जीरो टर्निंग रेडियस: अपनी ही जगह पर 360 डिग्री घूम जाता है",
                    "نصف قطر دوران صفر: يدور 360 درجة في مكانه"
                ),
                Bilingual(
                    "Over 30 quick-hitch attachments: auger, trencher, sweeper, breaker",
                    "30 से ज्यादा अटैचमेंट्स: बोरिंग ऑगर, स्वीपर, कंक्रीट ब्रेकर",
                    "يدعم أكثر من 30 ملحقاً مثل الحفارة والمقشة والجاك همر"
                )
            ),
            commonApplications = Bilingual(
                en = "Road asphalt patching, factory indoor material handling, landscaping, barn cleaning",
                hi = "सड़क डामरीकरण पैचवर्क, फैक्ट्री के अंदर सामान लोडिंग, गार्डन व पशु शेड सफाई",
                ar = "صيانة الأسفلت، المناولة داخل المصانع، تنسيق الحدائق، وتنظيف المستودعات"
            ),
            maintenanceIntervalHours = "Engine oil: 250 hrs | Chain drive oil: 1000 hrs | Hydraulic filter: 500 hrs",
            manualReference = "JCB Robot Skid Steer Workshop Publication 9803/8500"
        )
    )
}
