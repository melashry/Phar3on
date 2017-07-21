package com.example.aya_moh.phar3on;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

/**
 * Created by Aya_Moh on 7/2/2017.
 */

public class DatabaseOperation {
    private SQLiteDatabase mDatabase;
    DatabaseHelper databaseHelper;
    public DatabaseOperation(DatabaseHelper databaseHelper) {

        mDatabase = databaseHelper.getWritableDatabase();
        this.databaseHelper = databaseHelper;
    }

    private ContentValues getContentValues(StatusModel statue) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.NAME, statue.getName());
        contentValues.put(DatabaseHelper.ADESCRIPTION, statue.getADscription());
        contentValues.put(DatabaseHelper.EDESCRIPTION, statue.getEDscription());
        contentValues.put(DatabaseHelper.FDESCRIPTION, statue.getFDscription());
        return contentValues;
    }


    public void insertimage_to_table2(Context mContext,String image1, String image2, String image3, String image4, String image5, String image6,String image7, String image8, String image9, String image10, String image11, String image12
    , String image13, String image14, String image15, String image16, String image17, String image18, String image19, String image20, String image21){
    Toast.makeText(mContext,image1+"\n"+image2+"\n"+image3, Toast.LENGTH_SHORT).show();
        mDatabase.execSQL("Insert into "+DatabaseHelper.TABLE_NAME2+" values (1,'Sobek Hutp','"+image10+"','"+image11+"','"+image12+"'),(2,'Ramsis statue','"+image1+"','"+image2+"','"+image3+"'),(3,'Ahmous','"+image10+"','"+image11+"','"+image12+"'),(4,'Ramsis Elsales','"+image16+"','"+image17+"','"+image18+"')");

    }
    public Cursor getStatue_image(String statueName)
    {
        Cursor cursor  =mDatabase.rawQuery("select * from "+DatabaseHelper.TABLE_NAME2+" where "+DatabaseHelper.NAME_image+" =?",new String[]{statueName.toString()});
        return cursor;
    }


    public Cursor getStatueDescription(String StatueName) {
        //String statueDescription,statueDescription1,statueDescription2,statuename = null;
        mDatabase = databaseHelper.getReadableDatabase();
        Cursor cursor = mDatabase.rawQuery("select * from "+DatabaseHelper.TABLE_NAME+" where "+DatabaseHelper.NAME+" =?",new String[]{StatueName.toString()});
        return cursor;
    }

    public Cursor getStatueData() {
        Cursor cursor = mDatabase.rawQuery("select * from "+DatabaseHelper.TABLE_NAME,null);
        return cursor;
    }


   /* public Cursor getStatueImage(String statuename) {

        Cursor cursor = mDatabase.rawQuery("select * from "+DatabaseHelper.TABLE_NAME2+" where "+DatabaseHelper.NAME_image +"=?", new String[]{statuename});

        return cursor;
    }*/

    public void insert_dataTable1() {

        String s1_1 = "Sobek Hutp";
        String s1_2 = "كان من اقوى ملوك الاسرة الثالثة عشر :وجد لوحة اثرية له فى معبد الكرنك مما يدل على ولادته فى طيبه وبلغت فترة حكم الملك سوبك حوالى عشر سنوات خلف الملك سوبك حوتب اخويه على العرش مؤسسا لاقوى قوة  فى سلالة تلك الاسرة";
        String s1_3 = "Period of government Behind Subk Hutp IV his brothers Nefert Hotep and the first Hohter on the throne established the strongest force in the dynasty of that family. He built many temples in Upper Egypt and obtained the materials needed through the campaigns he sent to Mines and quarries while many of his predecessors and successors were simply raping old installations. He also showed great attachment to the city of Hisba through his gifts and increased offerings to the god Amun And many state allocations. This pharaoh also managed to quell a revolution that had broken out in the Nuba Kingdom and despite its control of the Lasht and Manaf a new independent kingdom was formed around the Delta in Sakha";
        String s1_4 = "Derrière Sobek Hotep frères Quatrième Navarre Hotep premier trône Houhtraly fondateur Llosa la force la plus puissante dans la souche de cette famille. Il a construit de nombreux temples en Haute-Égypte et obtenait le matériel nécessaire grâce à des campagnes qui ont été envoyés Mines et carrières alors que beaucoup de ses prédécesseurs et successeurs se contentent avoir violé anciennes installations. L attachement fort a aussi montré une bonne sa ville natale par Adzal et augmentation des offrandes au legs dieu Amun La plupart des allocations de l État. Cela permet aussi le pharaon pour réprimer une révolte éclata dansle pays de Nubie et malgré son contrôle sur Licht et Menf se composait d un nouveau royaume indépendant autour du delta dans la ville deSakha";


        String s2_1 = "First apophis";
        String s2_2 = "هو احد ملوك الاسرة الخامسة عشر وذلك فى نهاية الفترة الانتقالية حيث كلنت مصر تحكمها الهكسوس وظل يحكم مصر حتى عام 1500 وبذلك امتد حكمه اكثر من ثلاثين عاما حيث شيد المعابد ونسخ المؤلفات القديمة وعمل على توثيق سلطة نموذجية صحيحة";
        String s2_3 = "His achievements Abu Feis ruled before the last kings of the fifteenth Dynasty and after the most famous kings of the Hyksos. He managed the affairs of the state during his long term reign (which lasted more than thirty years) like any other Egyptian Pharaoh. The temples were built (especially in the mountains) and he copied the ancient works and determined his authority through a model document and correct Egyptian versions to the extent that he sought to change the name of his coronation three times in order to make his reigns in a coherent intellectual pattern. However according to the legend the Abu-Vis conflict with Sakhnin-Ra it has cut off ties with the seventeenth family when it imposed a professional requirement under a metaphor. Camus weakened the position of apophis when he overthrew his Egyptian assistant Nefrosi and defeated his ally Amir Kush and then the power of Abu Feis fell in the end of his reign under the influence of the strikes of patriotic people  who overcame his successor after that called Khamoudi His achievemen";
        String s2_4 = "Abu Feis ruled before the last kings of the fifteenth Dynasty and after the most famous kings of the Hyksos. He managed the affairs of the state during his long term reign (which lasted more than thirty years) like any other Egyptian Pharaoh. The temples were built (especially in the mountains) and he copied the ancient works and determined his authority through a model document and correct Egyptian versions to the extent that he sought to change the name of his coronation three times in order to make his reigns in a coherent intellectual pattern. However according to the legend the Abu-Vis conflict with Sakhnin-Ra it has cut off ties with the seventeenth family when it imposed a professional requirement under a metaphor. Camus weakened the position of apophis when he overthrew his Egyptian assistant Nefrosi and defeated his ally Amir Kush and then the power of Abu Feis fell in the end of his reign under the influence of the strikes of patriotic people who overcame his successor after that called Khamoudi";

        String s3_1 ="Camus" ;
        String s3_2 ="كان اخر فراعنة الاسرة السابعه عشر فى مصر القديمة واستمر حكمه ثلاث سنوات تولى الحكم بعد وفاة اباه سقنن رع واياح حتب واستكمل حرب ابيه مع الهكسوس";
        String s3_3 ="Abu Feis ruled before the last kings of the fifteenth Dynasty and after the most famous kings of the Hyksos. He managed the affairs of the state during his long term reign (which lasted more than thirty years) like any other Egyptian Pharaoh. The temples were built (especially in the mountains) and he copied the ancient works and determined his authority through a model document and correct Egyptian versions to the extent that he sought to change the name of his coronation three times in order to make his reigns in a coherent intellectual pattern. However according to the legend the Abu-Vis conflict with Sakhnin-Ra it has cut off ties with the seventeenth family when it imposed a professional requirement under a metaphor. Camus weakened the position of apophis when he overthrew his Egyptian assistant Nefrosi and defeated his ally Amir Kush and then the power of Abu Feis fell in the end of his reign under the influence of the strikes of patriotic people who overcame his successor after that called Khamoudi His achievements";
        String s3_4 ="Abu Feis ruled before the last kings of the fifteenth Dynasty and after the most famous kings of the Hyksos. He managed the affairs of the state during his long term reign (which lasted more than thirty years) like any other Egyptian Pharaoh. The temples were built (especially in the mountains) and he copied the ancient works and determined his authority through a model document and correct Egyptian versions to the extent that he sought to change the name of his coronation three times in order to make his reigns in a coherent intellectual pattern. However according to the legend the Abu-Vis conflict with Sakhnin-Ra it has cut off ties with the seventeenth family when it imposed a professional requirement under a metaphor. Camus weakened the position of apophis when he overthrew his Egyptian assistant Nefrosi and defeated his ally Amir Kush and then the power of Abu Feis fell in the of his reign under the influence of the strikes of patriotic people who overcame his successor after that called Khamoudi";


        String s4_1 ="Ahmous";
        String s4_2 ="محرر مصر وطارد الهكسوس ومؤسس الاسرة الثامنة عشر والتى تعد اعظم الاسر الحاكمة فى مصر وتولى الحكم وهو فى سن صغير وبالتالى تولت امه فترة وصاية عليه، قام احمس بتطوير الجيش المصرى فادخل العجلات الحربيه وعديد من الاسلحة واستمر حكمه تقريبا ربع قرن";
        String s4_3 ="Ahmus repairs After the special country of the occupation directed his attention towards "+
                "the repair of what destroyed by the ages of the effects of his great Amun ordered the manufacture of new time to worship in Karnak most of the pure silver and stones and gluten by the most skilled manufacturers. And the opening of quarries to cut the stones needed to build the temple of Ptah Minf and Temple of Amun Taybeh and under this inscription painted six oxen dragging a large piece of stone"+
                "wisdom Since the Ahmose ascended the throne apparently a young age he has his mother Aah Hotep during the period of his reign (1539-1514 BC) a kind of guardianship" +
                "The Ahmose developed the Egyptian army was the first to enter the war wheels  which was used by the Hyksos a reason beat Hyksos Egypt was pulled by horses and developed as well as from military weapons using catapults equipped with a piece of iron on the stock and then began to fight the Hyksos starting from Upper Egypt and surrounded by people so he trained efficiently even become" +
                "warriors strong and skilled and remained fighting the Hyksos from Upper Egypt until he reached the then capital of Egypt which was brought by the Hyksos next to the current city of Zagazig and remained fights them even fled to the north of the delta which is behind Vsaina and then to Palestine and did not return Ahmose but rest assured on the borders of Egypt the Middle Of them and they " +
                "are safe after their attacks eliminated after the expulsion of the Hyksos Ahmose arrived with his army to the country of Phenicia  as the country attacked Nubia to recover back to the Egyptian kingdom which reached its borders south to the second waterfall and photographed campaigns Ahmose in two of its soldiers cemetery two"+
                "Ahmose son of our father Ahmose bin Nkib"+
                "After the end of Ahmas of his wars to expel enemies and secure the borders of Egypt drew attention to the internal affairs that were rundown during the occupation of the Hyksos reformed the tax system and reopened commercial routes and repaired water channels and irrigation system." +
                "Ahmoses rule lasted for a quarter of a century and he died at the age of 35";
        String s4_4 ="Depuis le « Ahmosis » monta sur le trône apparemment un jeune âge il a sa mère Aah Hotep »pendant la période de son règne (1539-1514 avant JC) une sorte de tutelle." +
                "Le Ahmosis a développé l armée égyptienne était le premier à entrer dans les roues de guerre » qui a été utilisé par les Hyksos une raison battre Hyksos Egypte a été tiré par des chevaux et développé ainsi que des armes militaires à l aide de catapultes équipés d un morceau de fer sur le stock puis a commencé à combattre les Hyksos à partir" +
                " de la Haute-Egypte et entouré par des personnes donc il TrainEd efficacement même devenir des guerriers forts et qualifiés et est resté la lutte contre les Hyksos de la Haute-Egypte jusqu à ce qu il atteigne alors" +
                " capitale de l Egypte qui a été apporté par les Hyksos à côté de la ville actuelle de Zagazig et est resté des combats entre eux ont même fui vers le nord du delta qui est derrière" +
                " Vsaina puis en Palestine et ne reviennent pas Ahmosis mais rassurez-vous sur les frontières de l Egypte au Moyen-" +
                " Parmi eux et ils sont sûrs après leurs attaques éliminées après l expulsion des Hyksos Ahmosis est arrivé avec son armée dans le pays de Phénicie en tant que pays attaqué Nubie de recouvrer au royaume égyptien qui a atteint ses frontières sud à la deuxième chute d eau et a photographié des campagnes Ahmosis dans deux de ses soldats cimetière deux" +
                " Ahmosis fils de notre père Ahmosis bin NKIB" +
                " Après la fin de ses guerres Ahmosis pour expulser les ennemis et sécuriser les frontières de l Egypte a attiré l attention sur les affaires intérieures qui était délabrée pendant l occupation du système fiscal Hyksos Vosaleh et rouvrez routes commerciales et fixer les canaux d eau et système d irrigation." +
                " La règle continue de Ahmosis pour un quart de siècle et il est mort à l âge de près de 35 ans";

        String s5_1 ="Ramsis statue";
        String s5_2 ="هو فرعون الاسرة التاسعه عشر حكم مصر لفترة قصيرة من الزمن وبدأ فى بناء قاعة الاساطين الكبرى";
        String s5_3 ="Ramses I Pharaoh is the nineteenth family The dates of his short reign are not fully known but are often dFated in the late 1290-1292 at the time he was" +
                "Ramses I the founder of the ninth family felt but in fact his short-lived rule was marked by a transition between" +
                "Hoor a lover of the rule of Egypt settled in the early eighteenth century and the rule of the powerful Pharaohs in this family especially his son Sti first and grandson Ramses Tani flourished the Egyptian country in the era of this family and took the lead civilizational" +
                "And military relations among its neighbors in that period excitement Ramses I began to build the Great Hall of the Pillars in Karnak which was completed by his son City I. In his short reign Ramses I was unable to leave any significant traces in Egypt. At the same time he ordered the construction of his tomb (No. 16) in the Valley of the Kings" +
                "He died before it was completed so his mother was buried in one of the front rooms of his tomb. In his tomb he found a manuscript called the Book of Doors one of the parts of the book of the dead and this manuscript is important as it gives us an idea of the ancient Egyptian beliefs. There are" +
                "few traces of King Ramesses I in Memphis and Heliopolis as well as in the temple of his son City I in Abydos";

                 String s5_4 = "Ramsès I Pharaon est la dix-neuvième famille" +
                                 "date pas complètement connue à court règle mais souvent la chronique en fin de 1290-1292 à un moment où"+
                                 "Ramsès Ier fondateur de la neuvième famille ressenti mais en réalité il a marqué son règne qui a duré une courte période de déménagement" +
                                 "Horemheb une écurie qui a gouverné l Egypte au début du dix-huitième dynastie et la domination des puissants Pharaons dans cette famille en particulier son fils et petit-fils premier Siti Ramsès Délibération a prospéré à l époque de la nation égyptienne et la famille a pris l avant-garde de la civilisation"+
                                 "Militaires et parmi ses voisins dans cette période effets"+
                                 "Ramsès Ier a commencé à construire la Grande Salle Alosatin (Colonnes de pression) à Karna que son fils a terminé la première ville Palais et son règne de Ramsès je ne pouvais pas laisser des traces importantes en Egypte. En même temps il a ordonné la construction de sa tombe (n ° 16) dans la vallée des Rois" +
                                 "Cependant il est mort avant la fin et il a été enterré Momciah dans une chambre devant sa tombe. Il a été retrouvé dans sa tombe sur le manuscrit d un livre intitulé portes d un livre des parties mortes et ce manuscrit est important où il nous donne une idée des anciennes croyances égyptiennes. Il y a quelques-uns" +
                                 "des rares monuments du roi Ramsès Ier à Memphis et Héliopolis ainsi que son fils dans le temple de Séthi I à Abydos";

        String s6_1 ="Ramsis Elsales";
        String s6_2 ="اشهر ملوك الاسرة العشرون ، مشى فى الاتجاه الذى يساعد فى مجد الاسرة وعظمة البلاد كان يجاهد من اجل سلامة الدلتا فطهر كافة المناطق الغربيه من القبائل الليبية";
        String s6_3 ="Ramses III  The Twentieth Dynasty The rule of Egypt The period 1152-1183 Known by the Greeks as Ramisinitos was followed by his father Ramses al-Tani in the most famous days" +
                "Initiate huge construction projects" +
                "His names" +
                "Ramses III has two main names appear to the left and write in Arabic as follows: Wasser-Maat-Ra-Meri-Iman Ra-Mas-S-Hakka-Uno. It means  strong with a pious beast beloved of Ammon carrying by Ra regent on " +
                "wisdom .Ramesses the Third took every diet and enthusiasm in the same direction that helped the greatness and glory of the previous family.  However" +
                "The kingdom s conditions were not in the state it had previously been entrusted to.  The Ramses II was fighting at the Ornt River while " +
                "Ramses III was struggling for the safety of the delta. He had to cleanse all the western regions of the Libyan tribes and to fight two wars with them to stop them at Marmarica " +
                "The second Libyan war is one of the heroic exploits and the courageous masters cut on us in dramatic paintings and long poems engraved on the walls of the temple of the city of Habu. " +
                "As well as another epic of battles that saved Egypt from the  peoples of the sea  such as the Palestinians Takhar and Shaklas " +
                "The Egyptian navy and land forces have lost their fleets at the entrance to one of the Nile branches. On the walls of this temple we also see pictures of the families of immigrants from Asia on horse-drawn carts and are being exterminated or captured. Ramses III managed to maintain several bases in the territory of Canaan" +
                "Ramses III " +
                "The Twentieth Dynasty The rule of Egypt The period 1152-1183 Known by the Greeks as Ramisinitos was followed by his father Ramses al-Tani in the most famous days " +
                "Initiate huge construction projects His names " +
                "Ramses III has two main names appear to the left and write in Arabic as follows: Wasser-Maat-Ra-Meri-Iman Ra-Mas-S-Hakka-Uno. It means strong with a pious beast beloved of Ammon carrying by Ra regent on " +
                "wisdom ";
        String s6_4 ="Ramesses the Third took every diet and enthusiasm in the same direction that helped the greatness and glory of the previous family.  However" +
                "The kingdom s conditions were not in the state it had previously been entrusted to.  The Ramses II was fighting at the Ornt River while" +
                "Ramses III was struggling for the safety of the delta. He had to cleanse all the western regions of the Libyan tribes and to fight two wars with them to stop them at Marmarica" +
                "The second Libyan war is one of the heroic exploits and the courageous masters cut on us in dramatic paintings and long poems engraved on the walls of the temple of the city of Habu." +
                "As well as another epic of battles that saved Egypt from the  peoples of the sea such as the Palestinians Takhar and Shaklas" +
                "The Egyptian navy and land forces have lost their fleets at the entrance to one of the Nile branches. On the walls of this temple we also see pictures of the families of immigrants from Asia on horse-drawn carts and are being exterminated or captured. Ramses III managed to maintain several bases in the territory of Canaan";

        String s7_1 ="Psosens 1";
        String s7_2 ="هو احد فراعنة الاسرة الحادية والعشرين فى مصر القديمة ابن كبير كهنة طيبة المدعو بينجم الذى قدم الى تانيس ليخلف الملك سمندس على العرش  وبنى معبدا كرسه للاله امون وتم بناء مقبرته فى تانيس";
        String s7_3 ="He is one of the Pharaohs of the twenty-first family of ancient Egypt. He is the son of a great high priest named Bingham who was brought to Tanis to succeed King Smandas on the throne.Custody"+
                "His reign is long. Pessosensis was also named  Ramses Psousennes as a successor" +
                "The twentieth family But when he proclaimed himself king and the first prophet of Amun at the same time he was considered the founder of a subordinate royal family" +
                "Of the good theology in Lower Egypt. This king set up on the sandy hills of Tanis a temple dedicated to the god Amun whose area " +
                "Four and a half hectares (4500 square meters) adorned by many magnificent engraved paintings surrounded by famous installations Burial "+
                "And the construction of the Psusens of his tomb in Tanis had cut off the connection with the ancient traditions that required the Pharaoh s last residence in" +
                "The kings of the kingdom explored the foundations of this tomb which was miraculously rescued from destruction by the French scientist Pierre Montet between 1939 and 1946. Therefore Pharaoh in 1000 BC owes his fame to his golden mask silver cloak And the huge collection of his jewelry complemented by the treasures of his minister" +
                "Undaabunded This number of tools made of precious metals indicates that the royal treasuries were in a state of apparent wealth at the same time that the Egyptian expansion ";
        String s7_4 =" Est l un des pharaons de la vingt et unième famille dans l Egypte ancienne le fils d un grand bon prêtre nommé Bandjem qui est Tanis pour réussir roi Smends sur le trône" +
                "son règne" +
                "Son règne se caractérise par le long terme. پ susns a également pris le nom de Ramsès Ramsès پ - Psousennes de successeur suit" +
                "Vingt famille mais quand il se déclara roi et le premier prophète d Amon en même temps il a été considéré comme le fondateur de la propriété familiale du sujet" +
                "Théologie thébaine en Basse-Egypte et ont établi ce roi sur les collines de sable dans le temple Tanis dédié au dieu Amon était une zone de" +
                "Quatre hectares et demi (4500 m 2) orné de nombreuses peintures magnifiques sculptés entouré de célèbres installations enterrement"+
                "Le bâtiment de les susns de sa tombe à Tanis ont coupé le lien avec les anciennes traditions qui devaient être le dernier siège du Pharaon" +
                "La Vallée des Rois et a exploré les fondements de ce cimetière qui a sauvé du pillage et de la destruction par un miracle égyptologue français Bermntah Pierre Montet dans la période entre 1939 - 1946.olzlk le Pharaon en 1000 avant JC »doit la" +
                "renommée au masque d or et le cercueil d argent précieux et la livraison en temps opportun  les énormes groupes récréations complétés par les trésors du vizir" +
                "Oundbaoondd indique la quantité d outils en métaux précieux que les armoires de propriété étaient dans un état d affluence évidemment en même temps a vu le déclin et le déclin de l expansion égyptienne";

       String sql = "INSERT INTO "+DatabaseHelper.TABLE_NAME+" VALUES (1,'"+s1_1+"','"+s1_2+"','"+s1_3+"','"+s1_4+"'), (2,'"+s2_1+"','"+s1_2+"','"+s2_3+"','"+s2_4+"'), (3,'"+s3_1+"','"+s3_2+"','"+s3_3+"','"+s3_4+"'),(4,'"+s4_1+"','"+s4_2+"','"+s4_3+"','"+s4_4+"'), (5,'"+s5_1+"','"+s5_2+"','"+s5_3+"','"+s5_4+"'), (6,'"+s6_1+"','"+s6_2+"','"+s6_3+"','"+s6_4+"'), (7,'"+s7_1+"','"+s7_2+"','"+s7_3+"','"+s7_4+"')";
        mDatabase.execSQL(sql);


      /*  String sql1 = "insert into " + DatabaseHelper.TABLE_NAME + " values (1,'Sobek Hutp ','كان من اقوى ملوك الاسرة الثالثة عشر :وجد لوحة اثرية له فى معبد الكرنك مما يدل على ولادته فى طيبه وبلغت فترة حكم الملك سوبك حوالى عشر سنوات خلف الملك سوبك حوتب اخويه على العرش مؤسسا لاقوى قوة  فى سلالة تلك الاسرة ','Period of government\n" +
                "Behind Subk Hutp IV his brothers Nefert Hotep and the first Hohter on the throne established the strongest force in the dynasty of that family. He built many temples in Upper Egypt and obtained the materials needed through the campaigns he sent to Mines and quarries, while many of his predecessors and " +
                "successors were simply raping old installations. He also showed great attachment to the city of Hisba through his gifts and increased offerings to the god Amun And many state allocations. This pharaoh also managed to quell a revolution that had broken out in the Nuba Kingdom and despite its control of the " +
                "Lasht and Manaf, a new independent kingdom was formed around the Delta in Sakha\n ','Mandat\n" +
                "Derrière Sobek Hotep frères Quatrième Navarre Hotep premier trône Houhtraly fondateur Llosa la force la plus puissante dans la souche de cette famille. Il a construit de nombreux temples en Haute-Égypte et obtenait le matériel nécessaire grâce à des campagnes qui ont été envoyés Mines et carrières, alors" +
                " que beaucoup de ses prédécesseurs et successeurs se contentent avoir violé anciennes installations. L'attachement fort a aussi montré une bonne sa ville natale par Adzal et augmentation des offrandes au legs dieu Amun La plupart des allocations de l'État. Cela permet aussi le pharaon pour réprimer une " +
                "révolte éclata dansle pays de Nubie et malgré son contrôle sur Licht et Menf se composait d'un nouveau royaume indépendant autour du delta dans la ville deSakha\n')";
        mDatabase.execSQL(sql1);
        String sql2 = "insert into " + DatabaseHelper.TABLE_NAME + " values (2,'First apophis','هو احد ملوك الاسرة الخامسة عشر وذلك فى نهاية الفترة الانتقالية حيث كلنت مصر تحكمها الهكسوس وظل يحكم مصر حتى عام 1500 وبذلك امتد حكمه اكثر من ثلاثين عاما حيث شيد المعابد ونسخ المؤلفات القديمة وعمل على توثيق سلطة نموذجية صحيحة ','His achievements\n" +
                "Abu Feis ruled before the last kings of the fifteenth Dynasty and after the most famous kings of the Hyksos. He managed the affairs of the state during his long term reign (which lasted more than thirty years) like any other Egyptian Pharaoh. The temples were built (especially in the mountains), and he" +
                " copied the ancient works and determined his authority through a model document and correct Egyptian versions, to the extent that he sought to change the name of his coronation three times in order to make his reigns in a coherent intellectual pattern.\n" +
                "However, according to the legend, 'the Abu-Vis conflict with Sakhnin-Ra, it has cut off ties with the seventeenth family when it imposed a' professional requirement 'under a metaphor. Camus weakened the position of 'apophis' when he overthrew his Egyptian assistant Nefrosi and defeated his ally Amir " +
                "Kush and then the power of Abu Feis fell in the end of his reign under the influence of the strikes of patriotic people, who overcame his successor after that called Khamoudi\n ','His achievements\n" +
                "Abu Feis ruled before the last kings of the fifteenth Dynasty and after the most famous kings of the Hyksos. He managed the affairs of the state during his long term reign (which lasted more than thirty years) like any other Egyptian Pharaoh. The temples were built (especially in the mountains), and he " +
                "copied the ancient works and determined his authority through a model document and correct Egyptian versions, to the extent that he sought to change the name of his coronation three times in order to make his reigns in a coherent intellectual pattern.\n" +
                "However, according to the legend, 'the Abu-Vis conflict with Sakhnin-Ra, it has cut off ties with the seventeenth family when it imposed a' professional requirement 'under a metaphor. Camus weakened the position of 'apophis' when he overthrew his Egyptian assistant Nefrosi and defeated his ally Amir Kush and then the power of Abu Feis" +
                " fell in the end of his reign under the influence of the strikes of patriotic people, who overcame his successor after that called Khamoudi\n')";
        mDatabase.execSQL(sql2);
        String sql3 = "insert into " + DatabaseHelper.TABLE_NAME + " values (3,'Camus','كان اخر فراعنة الاسرة السابعه عشر فى مصر القديمة واستمر حكمه ثلاث سنوات تولى الحكم بعد وفاة اباه سقنن رع واياح حتب واستكمل حرب ابيه مع الهكسوس  ','His achievements\n" +
                "Abu Feis ruled before the last kings of the fifteenth Dynasty and after the most famous kings of the Hyksos. He managed the affairs of the state during his long term reign (which lasted more than thirty years) like any other Egyptian Pharaoh. The temples were built (especially in the mountains), and he" +
                " copied the ancient works and determined his authority through a model document and correct Egyptian versions, to the extent that he sought to change the name of his coronation three times in order to make his reigns in a coherent intellectual pattern.\n" +
                "However, according to the legend, 'the Abu-Vis conflict with Sakhnin-Ra, it has cut off ties with the seventeenth family when it imposed a' professional requirement 'under a metaphor. Camus weakened the position of 'apophis' when he overthrew his Egyptian assistant Nefrosi and defeated his ally Amir " +
                "Kush and then the power of Abu Feis fell in the end of his reign under the influence of the strikes of patriotic people, who overcame his successor after that called Khamoudi\n ','His achievements\n" +
                "Abu Feis ruled before the last kings of the fifteenth Dynasty and after the most famous kings of the Hyksos. He managed the affairs of the state during his long term reign (which lasted more than thirty years) like any other Egyptian Pharaoh. The temples were built (especially in the mountains), and he " +
                "copied the ancient works and determined his authority through a model document and correct Egyptian versions, to the extent that he sought to change the name of his coronation three times in order to make his reigns in a coherent intellectual pattern.\n" +
                "However, according to the legend, 'the Abu-Vis conflict with Sakhnin-Ra, it has cut off ties with the seventeenth family when it imposed a' professional requirement 'under a metaphor. Camus weakened the position of 'apophis' when he overthrew his Egyptian assistant Nefrosi and defeated his ally Amir Kush and then the power of Abu Feis fell in the end " +
                "of his reign under the influence of the strikes of patriotic people, who overcame his successor after that called Khamoudi\n')";
        mDatabase.execSQL(sql3);
        String sql4 = "insert into " + DatabaseHelper.TABLE_NAME + " values (4,'Ahmous', 'محرر مصر وطارد الهكسوس ومؤسس الاسرة الثامنة عشر والتى تعد اعظم الاسر الحاكمة فى مصر وتولى الحكم وهو فى سن صغير وبالتالى تولت امه فترة وصاية عليه، قام احمس بتطوير الجيش المصرى فادخل العجلات الحربيه وعديد من الاسلحة واستمر حكمه تقريبا ربع قرن  ', 'Ahmus repairs After the special country of the occupation directed his attention towards " +
                "the repair of what destroyed by the ages of the effects of his great Amun ordered the manufacture of new time to worship in Karnak, most of the pure silver, and stones and gluten by the most skilled manufacturers. And the opening of quarries to cut the stones needed to build the temple of Ptah Minf and Temple of Amun Taybeh and under this inscription painted six oxen dragging a large piece of stone\n" +
                "wisdom\n" +
                "Since the 'Ahmose' ascended the throne, apparently a young age, he has his mother 'Aah Hotep' during the period of his reign (1539-1514 BC), a kind of guardianship.\n" +
                "The Ahmose developed the Egyptian army was the first to enter the war wheels ', which was used by the Hyksos, a reason beat Hyksos Egypt' was pulled by horses and developed as well as from military weapons using catapults equipped with a piece of iron on the stock and then began to fight the Hyksos starting from Upper Egypt, and surrounded by people so he trained efficiently even become" +
                " warriors strong and skilled and remained fighting the Hyksos from Upper Egypt until he reached the then capital of Egypt, which was brought by the Hyksos, next to the current city of Zagazig and remained fights them even fled to the north of the delta which is behind Vsaina and then to Palestine and did not return Ahmose but rest assured on the borders of Egypt, the Middle Of them and they " +
                "are safe after their attacks eliminated after the expulsion of the Hyksos Ahmose arrived with his army to the country of Phenicia, as the country attacked Nubia to recover back to the Egyptian kingdom, which reached its borders south to the second waterfall, and photographed campaigns Ahmose in two of its soldiers cemetery two\n" +
                "Ahmose, son of our father Ahmose bin Nkib\n" +
                "\n" +
                "After the end of Ahmas of his wars to expel enemies and secure the borders of Egypt drew attention to the internal affairs that were rundown during the occupation of the Hyksos, reformed the tax system and reopened commercial routes and repaired water channels and irrigation system.\n" +
                "Ahmose's rule lasted for a quarter of a century and he died at the age of 35\n" +
                "\n '   , 'Tout d'abord Ahmosis\n" +
                "Depuis le « Ahmosis » monta sur le trône, apparemment un jeune âge, il a sa mère Aah Hotep »pendant la période de son règne (1539-1514 avant JC), une sorte de tutelle.\n" +
                "Le Ahmosis a développé l'armée égyptienne était le premier à entrer dans les roues de guerre », qui a été utilisé par les Hyksos, une raison battre Hyksos Egypte a été tiré par des chevaux et développé ainsi que des armes militaires à l'aide de catapultes équipés d'un morceau de fer sur le stock, puis a commencé à combattre les Hyksos à partir" +
                " de la Haute-Egypte, et entouré par des personnes donc il TrainEd efficacement même devenir des guerriers forts et qualifiés et est resté la lutte contre les Hyksos de la Haute-Egypte jusqu'à ce qu'il atteigne alors" +
                " capitale de l'Egypte, qui a été apporté par les Hyksos, à côté de la ville actuelle de Zagazig et est resté des combats entre eux ont même fui vers le nord du delta qui est derrière" +
                " Vsaina, puis en Palestine et ne reviennent pas Ahmosis mais rassurez-vous sur les frontières de l'Egypte, au Moyen-" +
                " Parmi eux et ils sont sûrs après leurs attaques éliminées après l'expulsion des Hyksos Ahmosis est arrivé avec son armée dans le pays de Phénicie, en tant que pays attaqué Nubie de recouvrer au royaume égyptien, qui a atteint ses frontières sud à la deuxième chute d'eau, et a photographié des campagnes Ahmosis dans deux de ses soldats cimetière deux\n" +
                "Ahmosis, fils de notre père Ahmosis bin NKIB\n" +
                "\n" +
                "Après la fin de ses guerres Ahmosis pour expulser les ennemis et sécuriser les frontières de l'Egypte a attiré l'attention sur les affaires intérieures, qui était délabrée pendant l'occupation du système fiscal Hyksos, Vosaleh et rouvrez routes commerciales et fixer les canaux d'eau et système d'irrigation.\n" +
                "La règle continue de Ahmosis pour un quart de siècle et il est mort à l'âge de près de 35 ans\n ')";
        mDatabase.execSQL(sql4);
        String sql5 = "insert into " + DatabaseHelper.TABLE_NAME + " values (5,'Ramsis statue', ' هو فرعون الاسرة التاسعه عشر حكم مصر لفترة قصيرة من الزمن وبدأ فى بناء قاعة الاساطين الكبرى  ', 'Ramses I\n" +
                " Pharaoh is the nineteenth family\n" +
                "  The dates of his short reign are not fully known but are often dated in the late 1290-1292 at the time he was\n" +
                "  Ramses I, the founder of the ninth family, felt, but in fact his short-lived rule was marked by a transition between\n" +
                " Hoor, a lover of the rule of Egypt settled in the early eighteenth century and the rule of the powerful Pharaohs in this family, especially his son Sti first and grandson Ramses Tani flourished the Egyptian country in the era of this family and took the lead civilizational\n" +
                "And military relations among its neighbors in that period\n" +
                "excitement\n" +
                "Ramses I began to build the Great Hall of the Pillars in Karnak, which was completed by his son, City I. In his short reign, Ramses I was unable to leave any significant traces in Egypt. At the same time he ordered the construction of his tomb (No. 16) in the Valley of the Kings\n" +
                "He died before it was completed, so his mother was buried in one of the front rooms of his tomb. In his tomb he found a manuscript called the Book of Doors, one of the parts of the book of the dead, and this manuscript is important as it gives us an idea of the ancient Egyptian beliefs. There are" +
                " few traces of King Ramesses I in Memphis and Heliopolis, as well as in the temple of his son, City I, in Abydos\n '   , ' Ramsès I\n" +
                " Pharaon est la dix-neuvième famille\n" +
                "  date pas complètement connue à court règle, mais souvent la chronique en fin de 1290-1292 à un moment où\n" +
                "  Ramsès Ier, fondateur de la neuvième famille ressenti, mais en réalité, il a marqué son règne qui a duré une courte période de déménagement\n" +
                " Horemheb une écurie qui a gouverné l'Egypte au début du dix-huitième dynastie et la domination des puissants Pharaons dans cette famille, en particulier son fils et petit-fils premier Siti Ramsès Délibération a prospéré à l'époque de la nation égyptienne et la famille a pris l'avant-garde de la civilisation\n" +
                "Militaires et parmi ses voisins dans cette période\n" +
                "effets\n" +
                "Ramsès Ier a commencé à construire la Grande Salle Alosatin (Colonnes de pression) à Karnak, que son fils a terminé la première ville Palais et son règne de Ramsès, je ne pouvais pas laisser des traces importantes en Egypte. En même temps, il a ordonné la construction de sa tombe (n ° 16) dans la vallée des Rois\n" +
                "Cependant, il est mort avant la fin, et il a été enterré Momciah dans une chambre devant sa tombe. Il a été retrouvé dans sa tombe sur le manuscrit d'un livre intitulé portes d'un livre des parties mortes, et ce manuscrit est important où il nous donne une idée des anciennes croyances égyptiennes. Il y a quelques-uns " +
                "des rares monuments du roi Ramsès Ier à Memphis et Héliopolis, ainsi que son fils dans le temple de Séthi I à Abydos\n')";
        mDatabase.execSQL(sql5);
        String sql6 = "insert into " + DatabaseHelper.TABLE_NAME + " values (6,'Ramsis Elsales', ' اشهر ملوك الاسرة العشرون ، مشى فى الاتجاه الذى يساعد فى مجد الاسرة وعظمة البلاد كان يجاهد من اجل سلامة الدلتا فطهر كافة المناطق الغربيه من القبائل الليبية  ', 'Ramses III\n" +
                " The Twentieth Dynasty The rule of Egypt The period 1152-1183 Known by the Greeks as Ramisinitos was followed by his father Ramses al-Tani in the most famous days\n" +
                "Initiate huge construction projects\n" +
                "His names\n" +
                "Ramses III has two main names, appear to the left, and write in Arabic as follows: Wasser-Maat-Ra-Meri-Iman, Ra-Mas-S-Hakka-Uno. It means' strong with a pious beast, beloved of Ammon, carrying by Ra, regent on\n" +
                "wisdom\n" +
                "Ramesses the Third took every diet and enthusiasm in the same direction that helped the greatness and glory of the previous family.  However\n" +
                " The kingdom's conditions were not in the state it had previously been entrusted to.  The Ramses II was fighting at the Ornt River while\n" +
                "  Ramses III was struggling for the safety of the delta. He had to cleanse all the western regions of the Libyan tribes and to fight two wars with them to stop them at Marmarica\n" +
                " The second Libyan war is one of the heroic exploits and the courageous masters cut on us in dramatic paintings and long poems engraved on the walls of the temple of the city of Habu.\n" +
                "As well as another epic of battles that saved Egypt from the 'peoples of the sea' such as the Palestinians, Takhar and Shaklas\n" +
                "The Egyptian navy and land forces have lost their fleets at the entrance to one of the Nile branches. On the walls of this temple, we also see pictures of the families of immigrants from Asia on horse-drawn carts and are being exterminated or captured. Ramses III managed to maintain several bases in the territory of Canaan\n" +
                "\n '   , ' Ramses III\n" +
                " The Twentieth Dynasty The rule of Egypt The period 1152-1183 Known by the Greeks as Ramisinitos was followed by his father Ramses al-Tani in the most famous days\n" +
                "Initiate huge construction projects\n" +
                "His names\n" +
                "Ramses III has two main names, appear to the left, and write in Arabic as follows: Wasser-Maat-Ra-Meri-Iman, Ra-Mas-S-Hakka-Uno. It means' strong with a pious beast, beloved of Ammon, carrying by Ra, regent on\n" +
                "wisdom\n" +
                "Ramesses the Third took every diet and enthusiasm in the same direction that helped the greatness and glory of the previous family.  However\n" +
                " The kingdom's conditions were not in the state it had previously been entrusted to.  The Ramses II was fighting at the Ornt River while\n" +
                "  Ramses III was struggling for the safety of the delta. He had to cleanse all the western regions of the Libyan tribes and to fight two wars with them to stop them at Marmarica\n" +
                " The second Libyan war is one of the heroic exploits and the courageous masters cut on us in dramatic paintings and long poems engraved on the walls of the temple of the city of Habu.\n" +
                "As well as another epic of battles that saved Egypt from the 'peoples of the sea' such as the Palestinians, Takhar and Shaklas\n" +
                "The Egyptian navy and land forces have lost their fleets at the entrance to one of the Nile branches. On the walls of this temple, we also see pictures of the families of immigrants from Asia on horse-drawn carts and are being exterminated or captured. Ramses III managed to maintain several bases in the territory of Canaan\n" +
                "\n')";
        mDatabase.execSQL(sql6);
        String sql7 = "insert into " + DatabaseHelper.TABLE_NAME + " values (7,'Psosens 1', 'هو احد فراعنة الاسرة الحادية والعشرين فى مصر القديمة ابن كبير كهنة طيبة المدعو بينجم الذى قدم الى تانيس ليخلف الملك سمندس على العرش  وبنى معبدا كرسه للاله امون وتم بناء مقبرته فى تانيس   ', 'He is one of the Pharaohs of the twenty-first family of ancient Egypt. He is the son of a great high priest named Bingham, who was brought to Tanis to succeed King Smandas on the throne.\n" +
                "Custody\n" +
                "His reign is long. Pessosensis was also named 'Ramses Psousennes' as a successor\n" +
                "The twentieth family But when he proclaimed himself king, and the first prophet of Amun at the same time, he was considered the founder of a subordinate royal family\n" +
                "Of the good theology in Lower Egypt. This king set up on the sandy hills of Tanis, a temple dedicated to the god Amun whose area\n" +
                "Four and a half hectares (4500 square meters), adorned by many magnificent engraved paintings, surrounded by famous installations\n" +
                "\n" +
                "Burial\n" +
                "And the construction of the Psusens of his tomb in Tanis, had cut off the connection with the ancient traditions that required the Pharaoh's last residence in\n" +
                "The kings of the kingdom explored the foundations of this tomb, which was miraculously rescued from destruction by the French scientist Pierre Montet between 1939 and 1946. Therefore, Pharaoh in 1000 BC owes his fame to his golden mask, silver cloak, , And the huge collection of his jewelry complemented by the treasures of his minister\n" +
                "Undaabunded This number of tools made of precious metals indicates that the royal treasuries were in a state of apparent wealth, at the same time that the Egyptian expansion\n '   , ' Est l'un des pharaons de la vingt et unième famille dans l'Egypte ancienne, le fils d'un grand bon prêtre nommé Bandjem, qui est Tanis pour réussir roi Smends sur le trône\n" +
                "son règne\n" +
                "Son règne se caractérise par le long terme. پ susns a également pris le nom de Ramsès Ramsès پ - Psousennes de successeur suit\n" +
                "Vingt famille, mais quand il se déclara roi, et le premier prophète d'Amon en même temps, il a été considéré comme le fondateur de la propriété familiale du sujet\n" +
                "Théologie thébaine en Basse-Egypte, et ont établi ce roi sur les collines de sable dans le temple Tanis dédié au dieu Amon était une zone de\n" +
                "Quatre hectares et demi (4500 m 2), orné de nombreuses peintures magnifiques sculptés, entouré de célèbres installations\n" +
                "\n" +
                "enterrement\n" +
                "Le bâtiment de les susns de sa tombe à Tanis, ont coupé le lien avec les anciennes traditions qui devaient être le dernier siège du Pharaon\n" +
                "La Vallée des Rois et a exploré les fondements de ce cimetière, qui a sauvé du pillage et de la destruction par un miracle, égyptologue français Bermntah Pierre Montet dans la période entre 1939 - 1946.olzlk le Pharaon en 1000 avant JC »doit la " +
                "renommée au masque d'or et le cercueil d'argent, précieux et la livraison en temps opportun , les énormes groupes récréations complétés par les trésors du vizir\n" +
                "Oundbaoondd indique la quantité d'outils en métaux précieux que les armoires de propriété étaient dans un état d'affluence évidemment, en même temps, a vu le déclin et le déclin de l'expansion égyptienne\n')";
        mDatabase.execSQL(sql7);*/


    }

}
