package fr.jsmadja.antredesdragons.core.book;

import fr.jsmadja.antredesdragons.core.chapters.Chapter;
import fr.jsmadja.antredesdragons.core.chapters.ChapterNumber;
import fr.jsmadja.antredesdragons.core.chapters.DreamChapter;

import java.util.HashMap;
import java.util.Map;

public class Book {

    public static final int COUVERTURE = -12;
    public static final int MARKET = -11;
    public static final int DEBUT = -10;
    public static final int MERLIN = -9;
    public static final int MENACE_SUR_AVALAON = -8;
    public static final int DANS_LA_GROTTE_DE_CRISTAL_DE_MERLIN = -7;
    public static final int START = -6;

    private final Map<Integer, DreamChapter> dreamChapters = new HashMap<>() {{
        put(2, new DreamChapter2());
        put(3, new DreamChapter3());
        put(4, new DreamChapter4());
        put(5, new DreamChapter5());
        put(6, new DreamChapter6());
        put(7, new DreamChapter7());
        put(8, new DreamChapter8());
        put(9, new DreamChapter9());
        put(10, new DreamChapter10());
        put(11, new DreamChapter11());
        put(12, new DreamChapter12());
    }};

    private final Map<Integer, Chapter> chapters = new HashMap<>() {{
        put(COUVERTURE, new ChapterCouverture().withNumber(COUVERTURE).withTitle("L'Antre des Dragons").withIllustration());
        put(DEBUT, new ChapterDebut().withNumber(DEBUT).withTitle("Avis aux lecteurs téméraires !"));
        put(MERLIN, new ChapterMerlin().withTitle("Merlin").withNumber(MERLIN));
        put(MENACE_SUR_AVALAON, new ChapterMenaceSurAvalon().withNumber(MENACE_SUR_AVALAON).withTitle("Menace sur Avalon").withIllustration());
        put(DANS_LA_GROTTE_DE_CRISTAL_DE_MERLIN, new ChapterGrotteDeCristal().withNumber(DANS_LA_GROTTE_DE_CRISTAL_DE_MERLIN).withTitle("Dans la grotte de cristal de Merlin").withIllustration());
        put(MARKET, new MarketChapter().withNumber(MARKET).withTitle("Liste de courses de Pip").withIllustration());
        put(START, new StartChapter().withNumber(START).withTitle("L'aventure commence !").withIllustration());
        put(1, new Chapter1().withNumber(1));
        put(2, new Chapter2().withNumber(2));
        put(3, new Chapter3().withNumber(3));
        put(4, new Chapter4().withNumber(4));
        put(5, new Chapter5().withNumber(5));
        put(6, new Chapter6().withNumber(6));
        put(7, new Chapter7().withNumber(7));
        put(8, new Chapter8().withNumber(8));
        put(9, new Chapter9().withNumber(9));
        put(10, new Chapter10().withNumber(10));
        put(11, new Chapter11().withNumber(11));
        put(12, new Chapter12().withNumber(12));
        put(13, new Chapter13().withNumber(13).withIllustration());
        put(14, new Chapter14().withNumber(14));
        put(15, new Chapter15().withNumber(15));
        put(16, new Chapter16().withNumber(16));
        put(17, new Chapter17().withNumber(17));
        put(18, new Chapter18().withNumber(18));
        put(19, new Chapter19().withNumber(19).withIllustration());
        put(20, new Chapter20().withNumber(20));
        put(21, new Chapter21().withNumber(21));
        put(22, new Chapter22().withNumber(22));
        put(23, new Chapter23().withNumber(23));
        put(24, new Chapter24().withNumber(24));
        put(25, new Chapter25().withNumber(25).withIllustration());
        put(26, new Chapter26().withNumber(26));
        put(27, new Chapter27().withNumber(27));
        put(28, new Chapter28().withNumber(28));
        put(29, new Chapter29().withNumber(29));
        put(30, new Chapter30().withNumber(30));
        put(31, new Chapter31().withNumber(31));
        put(32, new Chapter32().withNumber(32));
        put(33, new Chapter33().withNumber(33));
        put(34, new Chapter34().withNumber(34));
        put(35, new Chapter35().withNumber(35));
        put(36, new Chapter36().withNumber(36));
        put(37, new Chapter37().withNumber(37));
        put(38, new Chapter38().withNumber(38));
        put(39, new Chapter39().withNumber(39).withIllustration());
        put(40, new Chapter40().withNumber(40));
        put(41, new Chapter41().withNumber(41));
        put(42, new Chapter42().withNumber(42));
        put(43, new Chapter43().withNumber(43));
        put(44, new Chapter44().withNumber(44));
        put(45, new Chapter45().withNumber(45));
        put(46, new Chapter46().withNumber(46).withIllustration());
        put(47, new Chapter47().withNumber(47).withIllustration());
        put(48, new Chapter48().withNumber(48));
        put(49, new Chapter49().withNumber(49));
        put(50, new Chapter50().withNumber(50));
        put(51, new Chapter51().withNumber(51));
        put(52, new Chapter52().withNumber(52));
        put(53, new Chapter53().withNumber(53));
        put(54, new Chapter54().withNumber(54));
        put(55, new Chapter55().withNumber(55));
        put(56, new Chapter56().withNumber(56));
        put(57, new Chapter57().withNumber(57).withIllustration());
        put(58, new Chapter58().withNumber(58));
        put(59, new Chapter59().withNumber(59));
        put(60, new Chapter60().withNumber(60));
        put(61, new Chapter61().withNumber(61));
        put(62, new Chapter62().withNumber(62));
        put(63, new Chapter63().withNumber(63));
        put(64, new Chapter64().withNumber(64));
        put(65, new Chapter65().withNumber(65));
        put(66, new Chapter66().withNumber(66));
        put(67, new Chapter67().withNumber(67));
        put(68, new Chapter68().withNumber(68));
        put(69, new Chapter69().withNumber(69));
        put(70, new Chapter70().withNumber(70));
        put(71, new Chapter71().withNumber(71));
        put(72, new Chapter72().withNumber(72));
        put(73, new Chapter73().withNumber(73));
        put(74, new Chapter74().withNumber(74));
        put(75, new Chapter75().withNumber(75));
        put(76, new Chapter76().withNumber(76));
        put(77, new Chapter77().withNumber(77));
        put(78, new Chapter78().withNumber(78).withIllustration());
        put(79, new Chapter79().withNumber(79));
        put(80, new Chapter80().withNumber(80));
        put(81, new Chapter81().withNumber(81));
        put(82, new Chapter82().withNumber(82));
        put(83, new Chapter83().withNumber(83));
        put(84, new Chapter84().withNumber(84).withIllustration());
        put(85, new Chapter85().withNumber(85));
        put(86, new Chapter86().withNumber(86).withIllustration());
        put(87, new Chapter87().withNumber(87));
        put(88, new Chapter88().withNumber(88));
        put(89, new Chapter89().withNumber(89));
        put(90, new Chapter90().withNumber(90));
        put(91, new Chapter91().withNumber(91));
        put(92, new Chapter92().withNumber(92));
        put(93, new Chapter93().withNumber(93));
        put(94, new Chapter94().withNumber(94).withIllustration());
        put(95, new Chapter95().withNumber(95));
        put(96, new Chapter96().withNumber(96));
        put(97, new Chapter97().withNumber(97));
        put(98, new Chapter98().withNumber(98));
        put(99, new Chapter99().withNumber(99).withIllustration());
        put(100, new Chapter100().withNumber(100));
        put(101, new Chapter101().withNumber(101));
        put(102, new Chapter102().withNumber(102));
        put(103, new Chapter103().withNumber(103));
        put(104, new Chapter104().withNumber(104).withIllustration());
        put(105, new Chapter105().withNumber(105));
        put(106, new Chapter106().withNumber(106));
        put(107, new Chapter107().withNumber(107));
        put(108, new Chapter108().withNumber(108));
        put(109, new Chapter109().withNumber(109));
        put(110, new Chapter110().withNumber(110));
        put(111, new Chapter111().withNumber(111));
        put(112, new Chapter112().withNumber(112));
        put(113, new Chapter113().withNumber(113));
        put(114, new Chapter114().withNumber(114).withIllustration());
        put(115, new Chapter115().withNumber(115));
        put(116, new Chapter116().withNumber(116));
        put(117, new Chapter117().withNumber(117));
        put(118, new Chapter118().withNumber(118).withIllustration());
        put(119, new Chapter119().withNumber(119));
        put(120, new Chapter120().withNumber(120).withIllustration());
        put(121, new Chapter121().withNumber(121));
        put(122, new Chapter122().withNumber(122));
        put(123, new Chapter123().withNumber(123));
        put(124, new Chapter124().withNumber(124));
        put(125, new Chapter125().withNumber(125));
        put(126, new Chapter126().withNumber(126).withIllustration());
        put(127, new Chapter127().withNumber(127));
        put(128, new Chapter128().withNumber(128));
        put(129, new Chapter129().withNumber(129));
        put(130, new Chapter130().withNumber(130).withIllustration());
        put(131, new Chapter131().withNumber(131));
        put(132, new Chapter132().withNumber(132));
        put(133, new Chapter133().withNumber(133));
        put(134, new Chapter134().withNumber(134));
        put(135, new Chapter135().withNumber(135));
        put(136, new Chapter136().withNumber(136));
        put(137, new Chapter137().withNumber(137).withIllustration());
        put(138, new Chapter138().withNumber(138));
        put(139, new Chapter139().withNumber(139));
        put(140, new Chapter140().withNumber(140).withIllustration());
        put(141, new Chapter141().withNumber(141).withIllustration());
        put(142, new Chapter142().withNumber(142));
        put(143, new Chapter143().withNumber(143));
        put(144, new Chapter144().withNumber(144));
        put(145, new Chapter145().withNumber(145));
        put(146, new Chapter146().withNumber(146));
        put(147, new Chapter147().withNumber(147));
        put(148, new Chapter148().withNumber(148));
        put(149, new Chapter149().withNumber(149));
        put(150, new Chapter150().withNumber(150));
        put(151, new Chapter151().withNumber(151).withIllustration());
        put(152, new Chapter152().withNumber(152));
        put(153, new Chapter153().withNumber(153));
        put(154, new Chapter154().withNumber(154));
        put(155, new Chapter155().withNumber(155));
        put(156, new Chapter156().withNumber(156));
        put(157, new Chapter157().withNumber(157));
        put(158, new Chapter158().withNumber(158));
        put(159, new Chapter159().withNumber(159));
        put(160, new Chapter160().withNumber(160).withIllustration());
        put(161, new Chapter161().withNumber(161));
        put(162, new Chapter162().withNumber(162).withIllustration());
        put(163, new Chapter163().withNumber(163));
        put(164, new Chapter164().withNumber(164));
        put(165, new Chapter165().withNumber(165));
        put(166, new Chapter166().withNumber(166).withIllustration());
        put(167, new Chapter167().withNumber(167));
        put(168, new Chapter168().withNumber(168).withIllustration());
        put(169, new Chapter169().withNumber(169));
        put(170, new Chapter170().withNumber(170).withIllustration());
        put(171, new Chapter171().withNumber(171));
        put(172, new Chapter172().withNumber(172).withIllustration());
        put(173, new Chapter173().withNumber(173).withIllustration());
        put(200, new Chapter200().withTitle("Le triomphe de Pip").withIllustration());
        put(201, new Chapter201().withTitle("Nouvelles Aventures").withIllustration());
    }};

    public Chapter get(int chapterNumber) {
        Chapter chapter = chapters.get(chapterNumber);
        if (chapter == null) {
            throw new RuntimeException("Chapter not found");
        }
        return chapter;
    }

    public DreamChapter getDreamChapter(int chapterNumber) {
        DreamChapter chapter = dreamChapters.get(chapterNumber);
        if (chapter == null) {
            throw new RuntimeException("DreamChapter not found");
        }
        return chapter;
    }

    public Chapter get(ChapterNumber chapterNumber) {
        return chapters.get(chapterNumber.getChapter());
    }
}
