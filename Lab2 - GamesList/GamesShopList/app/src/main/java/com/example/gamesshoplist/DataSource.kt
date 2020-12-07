package com.example.gamesshoplist

import com.example.gamesshoplist.models.Game


class DataSource {

    companion object{

        fun createDataSet(): ArrayList<Game>{
            val list = ArrayList<Game>()
            list.add(
                Game(
                    1,
                    "Farming Simulator 19",
                    "Symulatory",
                    "PS4",
                    "https://kopsnijgre.pl/images/gry-box/0497069-PS4.jpg",
                    "https://kopsnijgre.pl/images/obrazki_gry/obrazek_big/0497069.jpg",
                    "https://kopsnijgre.pl/images/obrazki_gry/obrazek_1/0497069.jpg",
                    "https://kopsnijgre.pl/images/obrazki_gry/obrazek_2/0497069.jpg",
                    "Farming Simulator 19 jest kolejną odsłoną znanego cyklu symulatorów, w których wcielamy się w rolnika. Gra oferuje dwie duże, otwarte i pełne różnego rodzaju zadań lokacje oraz setki maszyn i pojazdów, które możemy wykorzystać przy pracy. Za stworzenie omawianej produkcji odpowiada niezmiennie studio GIANTS Software i podobnie jak poprzednia odsłona serii, zadebiutowała ona równocześnie na komputerach i konsolach.\n" +
                            "\n" +
                            "Mechanika gry:\n" +
                            "Farming Simulator 19 stanowi ewolucję koncepcji znanych z poprzednich części cyklu. Gra oferuje dwie rozległe, otwarte lokacje i sporo nowej zawartości – upraw (nowe to bawełna i owies), narzędzi, zwierząt (w grze pojawiają się konie oraz psy) czy pojazdów (mamy do dyspozycji setki modeli, więcej niż kiedykolwiek w historii serii; debiut zaliczyły maszyny firmy John Deere).\n" +
                            "Poza prostymi zajęciami, takimi jak noszenie drewna, przygotowywanie upraw i jeżdżenie pojazdami i maszynami rolniczymi, mamy możliwość m.in. kupowania ziemi i sprzedawania swoich plonów. Tym razem jednak, w odróżnieniu od poprzednich odsłon, wraz z działkami w nasze ręce trafia także teren wokół parceli, który możemy zająć, wznosząc różnorodne budynki gospodarcze.\n" +
                            "Farming Simulator 19 oferuje nam także opcję dostosowania wyglądu swojego farmera. Wprowadzony został także mechanizm zmęczenia naszej postaci, który wymusza na nas sen w trakcie nocy.",
                    "PlayStation 4",
                    "PlayStation 5",
                    "91,99",
                    false
                )
            )
            list.add(
                Game(
                    2,
                    "FIFA 20",
                    "Sportowe",
                    "PC",
                    "https://kopsnijgre.pl/images/gry/0497033.jpg",
                    "https://kopsnijgre.pl/images/obrazki_gry/obrazek_big/0497033.jpg",
                    "https://kopsnijgre.pl/images/obrazki_gry/obrazek_1/0497033.jpg",
                    "https://kopsnijgre.pl/images/obrazki_gry/obrazek_2/0497033.jpg",
                    "Kolejna odsłona serii gier piłkarskich od studia EA Sports. W FIFA 20 kierujemy wiernie odwzorowanymi prawdziwymi drużynami oraz zawodnikami, grając przeciwko sztucznej inteligencji lub innym graczom. Główną nowością jest tryb VOLTA Football.",
                    "System operacyjny: Windows 7/8.1/10 (64-bitowy)\n" +
                            "Procesor: AMD Phenom II X4 965, Intel Core i3-2100 lub równoważny\n" +
                            "Pamięć RAM: 8 GB\n" +
                            "Karta graficzna: AMD Radeon HD 7850 2GB, NVIDIA GTX 660 2GB lub równoważna\n" +
                            "Miejsce na dysku: co najmniej 50 GB wolnego miejsca\n" +
                            "Wymagania dot. połączenia z Internetem: łącze o przepustowości minimum 512 kb/s. Połączenie z Internetem jest niezbędne do zainstalowania i uruchomienia gry.",
                    "System operacyjny: Windows 10 (64-bitowy)\n" +
                            "Procesor: AMD FX 8150, Intel i5-3550 lub równoważny\n" +
                            "Pamięć RAM: 8 GB\n" +
                            "Karta graficzna: AMD Radeon R9 270X, NVIDIA GeForce GTX 670 lub równoważna\n" +
                            "Miejsce na dysku: co najmniej 50 GB wolnego miejsca\n" +
                            "Wymagania dot. połączenia z Internetem: zalecane łącze szerokopasmowe. Połączenie z Internetem jest niezbędne do zainstalowania i uruchomienia gry.",
                    "62,73",
                    false
                )
            )

            list.add(
                Game(
                    3,
                    "CyberPunk 2077",
                    "RPG",
                    "PS4",
                    "https://www.gry-online.pl/galeria/gry13/388753281.jpg",
                    "https://cdn.mos.cms.futurecdn.net/Uv5o88bSABsNKcv4V7utaV-1200-80.jpg",
                    "https://images.gram.pl/news/zusv20201207091514607fenc.jpg",
                    "https://ocdn.eu/pulscms-transforms/1/nlkk9kuTURBXy80MGU0MWUyYy02OWVlLTQ2YjctOGM2Yi1jNTg5MmViMWY3ZTIuanBlZ5GVAs0DBwDDw4GhMAE",
                    "IMPONUJĄCE MEGAMIASTO\n" +
                            "Złap za broń i poznaj podziemie Night City – supernowoczesnego miasta, w którym interesy wielkich korporacji mieszają się z ambicjami ulicznych gangów. Otwarty świat Cyberpunk 2077 możesz przemierzać pieszo lub przy pomocy futurystycznych pojazdów, a każda decyzja podjęta w grze wpływa na kierunek fabuły.\n" +
                            "UNIKALNA POSTAĆ\n" +
                            "Stwórz bohatera, którego historia i unikalne umiejętności ułatwią wykonywanie kolejnych misji. W Cyberpunk 2077 masz pełną dowolność – możesz grać jako kobieta lub mężczyzna, dostosowując wygląd najemnika do własnych preferencji. Jednocześnie w trakcie gry zyskasz dostęp do potężnej broni przyszłości.\n" +
                            "CYBERNETYCZNE IMPLANTY\n" +
                            "Zwiększona siła ognia, przyspieszone hakowanie, skanowanie wrogów czy ostrzał z odbijaniem kul to tylko garść ulepszeń, które możesz zdobyć, instalując w swoim ciele specjalne implanty znane jako cyberwear. Niektóre z nich przydadzą się do cichego eliminowania zagrożeń – przy użyciu elementów otoczenia lub dronów bojowych.",
                    "PlayStation 4",
                    "PlaySation 5",
                    "268,29",
                    false
                )
            )
            list.add(
                Game(
                    4,
                    "Just Dance 2021",
                    "Rozrywkowe",
                    "Xone",
                    "https://kopsnijgre.pl/images/gry-box/0497078-XONE.jpg",
                    "https://kopsnijgre.pl/images/obrazki_gry/obrazek_big/0497078.png",
                    "https://kopsnijgre.pl/images/obrazki_gry/obrazek_1/0497078.png",
                    "https://kopsnijgre.pl/images/obrazki_gry/obrazek_2/0497078.png",
                    "Sweat Mode\n" +
                            "Ćwiczenia jeszcze nigdy nie były tak przyjemne. Dbaj o zdrowe nawyki ze Sweat Mode i ciesz się nieskończoną motywacją dzięki śledzeniu kalorii spalanych podczas tańca!\n" +
                            "\n" +
                            "Tryb kooperacji\n" +
                            "Baw się z przyjaciółmi w trybie kooperacji. Pracujcie razem na najwyższy wynik!\n" +
                            "Nowe przyjazne dzieciom piosenki\n" +
                            "Sprawdź osiem nowych piosenek i choreografii dla dzieci i spędź miło czas z rodziną.\n" +
                            "\n" +
                            "Aplikacji Just Dance Controller\n" +
                            "Skorzystaj z aplikacji Just Dance Controller na smartfona, aby śledzić swoje ruchy – nie potrzebujesz żadnych innych urządzeń! W ten sposób razem może grać nawet do 6 graczy!\n" +
                            "\n" +
                            "Miesiąc Just Dance Unlimited za darmo\n" +
                            "Dzięki tej usłudze możesz tańczyć do ponad 600 piosenek!",
                    "Xbox One",
                    "Xbox Series X",
                    "164,49",
                    false
                )
            )
            list.add(
                Game(
                    5,
                    "Need for Speed Rivals",
                    "Wyścigi",
                    "PS4",
                    "https://kopsnijgre.pl/images/gry-box/0481-PS4.jpg",
                    "https://img.ppe.pl/upload/editor/images/nfs1(2).jpg",
                    "https://s.cdaction.pl/obrazki/need-for-speed-rivals-20.08.13_07_175vg.jpg",
                    "https://s.cdaction.pl/obrazki/need-for-speed-rivals-20.08.13_02_175vg.jpg",
                    "All-Drive.\n" +
                            "Nowy tryb w Need for Speed Rivals zaciera granicę między rozgrywką jednoosobową i wieloosobową, umożliwiając płynne przejście do świata, w którym Twoi znajomi biorą właśnie udział w wyścigu lub pościgu. Bez poczekalni, bez czekania. Drogi wyścigów i pościgów się krzyżują, tworząc rzeczywistość pełną niepowtarzalnych sytuacji.\n" +
                            "Wyścigi nowej generacji.\n" +
                            "Moc silnika graficznego Frostbite 3 sprawia, że Redview County zachwyci cię swą rozległością i toczącą się tu dynamiczną akcją. Każdy szczegół świata gry został wyrenderowany w jakości HD, z wykorzystaniem grafiki nowej generacji. Warunki pogodowe będą się zmieniać w trakcie wyścigu – gracz będzie musiał stawić czoła opadom śniegu, gradu, deszczu, burzom pyłowym oraz gęstej mgle. Połącz się z Need for Speed Network, by ustawiać blokady na drogach lub ostrzegać znajomych przed policją. Porównaj postępy z rywalami i udostępniaj zdjęcia z najlepszych wyścigów oraz pościgów.\n" +
                            "Rywalizacja o wysoką stawkę.\n" +
                            "Kierowcy są samotnymi wilkami, pracującymi na swoją chwałę w szybkich autach stworzonych do szaleńczych wyścigów. Policjanci działają w grupach, starając się wszelkimi dostępnymi sobie środkami złapać kierowców. Zmieniaj rolę, kiedy chcesz, i rywalizuj w zupełnie nowym systemie punktacji, stawiając na szali zdobyte punkty prędkości w nadziei zgarnięcia cenniejszych nagród.\n",
                    "PlayStation 4",
                    "PlayStation 5",
                    "66,99",
                    false
                )
            )
            list.add(
                Game(
                    6,
                    "Assetto Corsa Competizione",
                    "Wyścigi",
                    "Xone",
                    "https://kopsnijgre.pl/images/gry-box/0497075-XONE.jpg",
                    "https://kopsnijgre.pl/images/obrazki_gry/obrazek_big/0497075.jpg",
                    "https://kopsnijgre.pl/images/obrazki_gry/obrazek_1/0497075.jpg",
                    "https://kopsnijgre.pl/images/obrazki_gry/obrazek_2/0497075.jpg",
                    "Assetto Corsa Competizione to następca wydanego w 2014 roku symulatora wyścigowego Assetto Corsa. Produkcja stworzona przez studio Kunos Simulazioni jest oficjalną grą serii wyścigów Blancpain GT organizowanych przez SRO Motorsports Group.\n" +
                            "Mechanika:\n" +
                            "Assetto Corsa Competizione, podobnie jak poprzednia część serii, to pełnoprawny symulator. Deweloperzy starali się jak najdokładniej odwzorować jazdę w ramach serii Blancpain GT. Na prowadzenie się pojazdów wpływa mnóstwo czynników – od przyczepności opon i systemów elektronicznych wspomagających jazdę, przez zawieszenie i silnik, aż po aerodynamikę maszyny oraz warunki pogodowe. Wszystkie te elementy opracowano na podstawie danych zebranych z prawdziwych samochodów.\n"+
                            "W Assetto Corsa Competizione znajdują się samochody od takich firm jak Ferrari, Lamborghini i McLaren. Z racji, że mamy do czynienia z licencjonowanym produktem, jeździmy po prawdziwych trasach, w rzeczywistych zespołach, ścigając się z wirtualnymi odpowiednikami znanych kierowców.",
                    "Xbox One",
                    "Xbox Series X",
                    "129,99",
                    false
                )
            )
            list.add(
                Game(
                    7,
                    "Project Cars 2",
                    "Wyścigi",
                    "Xone",
                    "https://kopsnijgre.pl/images/gry-box/0497053-XONE.jpg",
                    "https://kopsnijgre.pl/images/obrazki_gry/obrazek_2/04970538967.jpg",
                    "https://kopsnijgre.pl/images/obrazki_gry/obrazek_1/0497053.jpg",
                    "https://kopsnijgre.pl/images/obrazki_gry/obrazek_big/0497053.jpg",
                    "Project CARS 2 zaprasza graczy do rozgrywki w trybie single jak i multiplayer w najpiękniejszej, najprawdziwiej odwzorowanej oraz technicznie zaawansowanej wyścigowej symulacji jaka kiedykolwiek powstała. To dopiero jazda bez trzymanki! Podążając za sukcesem mocno oklaskiwanej poprzedniczki Project CARS – jednej z najlepiej ocenianych gier wyścigowych najnowszej generacji – Project CARS 2 podnosi poprzeczkę jeszcze wyżej, wprowadzając nowe ulepszenia i dodatki do rozgrywki.\n" +
                            "SZCZYT REALIZMU\n" +
                            "Gra posiada najobszerniejszą do tej pory listę torów wyścigowych dostępnych do jazdy. Oferuje jednocześnie ogromny wachlarz aut do wyboru – masz możliwość wybrać spośród ponad 170 oryginalnych modeli samochodów od ikonicznych marek. Gra Project CARS 2 wspiera technologie VR oraz obraz w rozdzielczości 12K!\n" +
                            "GORĄCZKA RYWALIZACJI\n" +
                            "Z całkowicie nowym systemem zawodów w trybie multiplayer, stworzonym na prośbę graczy, tryb Mistrzostw Online pozwala graczom tworzyć oraz dołączać do lig sportowych, zapewniając pełnowymiarową integrację oraz streaming.\n" +
                            "POTĘGA ŻYWIOŁÓW\n" +
                            "Rozgrywka staje się bardziej urozmaicona dzięki ciągle zmieniającym się czynnikom pogodowym i warunkom na drodze – od jazdy na żwirze, asfalcie bądź w błocie, poprzez zmieniające się pory dnia oraz roku po nieprzewidywalne warunki atmosferyczne na drodze. Zmierz się z Matką naturą przy dynamicznie zmieniającej się pogodzie, gdy zasypywać Cię będzie śnieg, bądź spróbuj swoich sił na oblodzonych i niebezpiecznych torach w Szwecji – ten konkretny tor jest wiernym odwzorowaniem ekskluzywnego miejsca, usytuowanego w północnej Szwecji, w którym Mercedes Benz organizuje zimowe wydarzenia wyścigowe. Tor stworzony na zamrożonym jeziorze będzie weryfikował wyścigowe zdolności graczy w doskonały sposób – w grze, tak jak robi to w prawdziwym życiu.",
                    "Xbox One",
                    "Xbox Series X",
                    "37,99",
                    false
                )
            )
            list.add(
                Game(
                    8,
                    "Microsoft Flight Simulator Premium",
                    "Symulatory",
                    "PC",
                    "https://kopsnijgre.pl/images/gry-box/0497042-PC.jpg",
                    "https://kopsnijgre.pl/images/obrazki_gry/obrazek_big/0497042.jpg",
                    "https://kopsnijgre.pl/images/obrazki_gry/obrazek_1/0497042.jpg",
                    "https://kopsnijgre.pl/images/obrazki_gry/obrazek_2/0497042.jpg",
                    "Edycja Premium Deluxe zawiera pełną podstawową grę oraz 10 dodatkowych, szczegółowo odwzorowanych, samolotów z unikalnymi modelami lotu, a także 10 dodatkowych, pieczołowicie odtworzonych, międzynarodowych lotnisk.\n" +
                            "W pudełku znajduje się drukowana instrukcja opisująca samoloty oraz lotniska z Edycji Standardowej, a także artbook prezentujący maszyny i lokacje z edycji Premium Deluxe.\n" +
                            "Dodatkowe samoloty: Diamond Aircraft DA40-TDI, Diamond Aircraft DV20, Textron Aviation Beechcraft Baron G58, Textron Aviation Cessna 152 Aerobat, Textron Aviation Cessna 172 Skyhawk, Boeing 787-10 Dreamliner, Cirrus Aircraft SR22, Pipistrel Virus SW 121, Textron Aviation Cessna Citation Longitude, Zlin Aviation Shock Ultra.\n" +
                            "Dodatkowe lotniska: Port lotniczy Amsterdam-Schiphol (Holandia), Port lotniczy Kair (Egipt), Port lotniczy Kapsztad (RPA), Port lotniczy Chicago-O’Hare (Stany Zjednoczone), Port lotniczy Madryt-Barajas (Hiszpania), Port lotniczy Denver (Stany Zjednoczone), Port lotniczy Dubaj (Zjednoczone Emiraty Arabskie), Port lotniczy Frankfurt (Niemcy), Port lotniczy Londyn-Heathrow (Wielka Brytania), Port lotniczy San Francisco (Stany Zjednoczone)." +
                            "Microsoft Flight Simulator to nowa generacja jednej z najbardziej lubianych i docenianych serii symulatorów. Lataj szczegółowymi, pięknymi maszynami, od lekkich samolotów po wielkie odrzutowce w niezwykle realistycznym świecie. Stwórz plan lotu i wybierz się gdziekolwiek zechcesz na całym świecie. Ciesz się lotem w noc lub w dzień i w każdych, czasem bardzo trudnych, warunkach pogodowych.\n" +
                            "Wzbij się w przestworza i poczuj radość z lotu w symulatorze nowej generacji Microsoft Flight Simulator. Teraz cały świat jest na wyciągnięcie ręki!\n" +
                            "Główne cechy:\n" +
                            "Odkryj świat - Podróżuj po niesamowicie szczegółowym świecie, obejmującym ponad 37 tysięcy lotnisk, 2 miliony miast, 1,5 miliarda budynków, prawdziwe góry, drogi, drzewa, rzeki, zwierzęta, ruch drogowy i nie tylko.\n" +
                            "Zdobądź skrzydła - Doskonal umiejętności pilotażu w różnych samolotach, od lekkich maszyn po komercyjne odrzutowce, dzięki rozgrywce dostosowującej się do twojego poziomu, oferującej interaktywne i jasne wskazówki oraz listy kontrolne.\n" +
                            "Testuj swoje umiejętności - Lataj w dzień i w nocy z pogodą zmieniającą się w czasie rzeczywistym, w tym z dokładną prędkością i kierunkiem wiatru, temperaturą, wilgotnością, deszczem i nasłonecznieniem.",
                    "Procesor: Intel Core i5-4460 lub AMD Ryzen 3 1200\n" +
                            "Karta graficzna: GeForce GTX 770 lub Radeon RX 570\n" +
                            "Pamięć: 8 GB RAM\n" +
                            "Dysk: 150 GB wolnego miejsca\n" +
                            "System operacyjny: Windows 10 (1909)\n" +
                            "Połączenie sieciowe: powyżej 5 Mb/s",
                    "Procesor: Intel Core i5-8400 lub AMD Ryzen 5 1500X\n" +
                            "Karta graficzna: GeForce GTX 970 lub Radeon RX 590\n" +
                            "Pamięć: 16 GB RAM\n" +
                            "Dysk: 150 GB wolnego miejsca\n" +
                            "System operacyjny: Windows 10 (1909)\n" +
                            "Połączenie sieciowe: powyżej 20 Mb/s",
                    "477,99",
                    false
                )
            )
            list.add(
                Game(
                    9,
                    "Football Manager 2020",
                    "Sportowe",
                    "PC",
                    "https://kopsnijgre.pl/images/gry/0496983.jpg",
                    "https://static.footballmanager.com/site/2019-11/Ajax%20Tactics%20-%20ENG.png",
                    "https://kopsnijgre.pl/images/obrazki_gry/obrazek_1/0496983.jpg",
                    "https://kopsnijgre.pl/images/obrazki_gry/obrazek_2/0496983.jpg",
                    "Wyjdź przez korytarz z szatni do żyjącego, oddychającego świata piłki nożnej z tobą w samym jego centrum. Tutaj twoje zdanie się liczy! To świat, który wynagradza planowanie i wiedzę, ale w przeciwieństwie do innych gier nie ma z góry zaplanowanego zakończenia lub scenariusza – są tylko niekończące się możliwości oraz szanse. Każdy klub ma swoją własną historię, a twoim zadaniem jest ją stworzyć.\n" +
                            "Mówi się, że piłka nożna to gra marzeń. To prawda, a menedżerowie to szczególny typ marzycieli. Zamiast problemów widzą nowe możliwości: szansę na wykazanie się przed najlepszymi w tej branży, na stworzenie i zaszczepienie nowej filozofii, na wyłowienie nowych talentów, wyniesienie klubu na wyżyny i zdobycie złota. To, w jaki sposób dotrzesz na szczyt, zależy tylko od ciebie. Ponosisz odpowiedzialność za swoje decyzje i ich konsekwencje.\n" +
                            "\n" +
                            "Główne cechy:\n" +
                            "Załóż swoją siedzibę w 50 największych futbolowych krajach na świecie\n" +
                            "Doglądaj nowej ery sukcesu w jednym z 2500 klubów na każdym poziomie\n" +
                            "Zawieraj kontrakty z najlepszymi i kształtuj przyszłość – szukaj talentów wśród ponad 500 000 prawdziwych graczy oraz członków zespołu\n" +
                            "Twórz swoje taktyki i wcielaj je w życie na treningach\n" +
                            "Kopnij w każdą piłkę dzięki naszemu realistycznemu i jak dotąd najsprawniejszemu silnikowi gry",
                    "Wymaga 64-bitowego procesora i systemu operacyjnego\n" +
                            "System operacyjny: Windows 7 (SP1), 8/8.1, 10 (Update 1803/April 2018 or later) – 64-bit\n" +
                            "Procesor: Intel Pentium 4 (64-bit), Intel Core 2 or AMD Athlon 64 – 2.2 GHz +\n" +
                            "Pamięć: 2 GB RAM\n" +
                            "Karta graficzna: Intel GMA X4500, NVIDIA GeForce 9600M GT or AMD/ATI Mobility Radeon HD 3650 – 256MB VRAM\n" +
                            "DirectX: Wersja 11\n" +
                            "Miejsce na dysku: 7 GB dostępnej przestrzeni",
                    "Brak oficjalnej informacji",
                    "78,29",
                    false
                )
            )
            return list
        }

        fun getObjectById(Id: Int): Game? {
            for(item in createDataSet())
                if(item.idItem == Id){
                    return item
                }
            return null
        }
    }
}
