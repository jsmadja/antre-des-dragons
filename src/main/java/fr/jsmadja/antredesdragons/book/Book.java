package fr.jsmadja.antredesdragons.book;

import fr.jsmadja.antredesdragons.chapters.Chapter;

import java.util.HashMap;
import java.util.Map;

public class Book {

    public static final int DEBUT = -10;
    public static final int MERLIN = -9;
    public static final int MENACE_SUR_AVALAON = -8;
    public static final int DANS_LA_GROTTE_DE_CRISTAL_DE_MERLIN = -7;

    private final Map<Integer, Chapter> chapters = new HashMap<>() {{
        put(DEBUT, new ChapterDebut());
        put(MERLIN, new ChapterMerlin());
        put(MENACE_SUR_AVALAON, new ChapterMenaceSurAvalon());
        put(DANS_LA_GROTTE_DE_CRISTAL_DE_MERLIN, new ChapterGrotteDeCristal());

        put(1, new Chapter1());
        put(2, new Chapter2());
        put(3, new Chapter3());
        put(4, new Chapter4());
        put(5, new Chapter5());
        put(6, new Chapter6());
        put(7, new Chapter7());
        put(8, new Chapter8());
        put(9, new Chapter9());

        put(10, new Chapter10());
        put(11, new Chapter11());
        put(12, new Chapter12());
        put(13, new Chapter13());
        put(14, new Chapter14());
        put(15, new Chapter15());
        put(16, new Chapter16());
        put(17, new Chapter17());
        put(18, new Chapter18());
        put(19, new Chapter19());

        put(20, new Chapter20());
        put(21, new Chapter21());
        put(22, new Chapter22());
        put(23, new Chapter23());
        put(24, new Chapter24());
        put(25, new Chapter25());
        put(26, new Chapter26());
        put(27, new Chapter27());
        put(28, new Chapter28());
        put(29, new Chapter29());

        put(30, new Chapter30());
        put(31, new Chapter31());
        put(32, new Chapter32());
        put(33, new Chapter33());
        put(34, new Chapter34());
        put(35, new Chapter35());
        put(36, new Chapter36());
        put(37, new Chapter37());
        put(38, new Chapter38());
        put(39, new Chapter39());

        put(40, new Chapter40());
        put(41, new Chapter41());
        put(42, new Chapter42());
        put(43, new Chapter43());
        put(44, new Chapter44());
        put(45, new Chapter45());
        put(46, new Chapter46());
        put(47, new Chapter47());
        put(48, new Chapter48());
        put(49, new Chapter49());

        put(50, new Chapter50());
        put(51, new Chapter51());
        put(52, new Chapter52());
        put(53, new Chapter53());
        put(54, new Chapter54());
        put(55, new Chapter55());
        put(56, new Chapter56());
        put(57, new Chapter57());
        put(58, new Chapter58());
        put(59, new Chapter59());

        put(60, new Chapter60());
        put(61, new Chapter61());
        put(62, new Chapter62());
        put(63, new Chapter63());
        put(64, new Chapter64());
        put(65, new Chapter65());
        put(66, new Chapter66());
        put(67, new Chapter67());
        put(68, new Chapter68());
        put(69, new Chapter69());

        put(70, new Chapter70());
        put(71, new Chapter71());
        put(72, new Chapter72());
        put(73, new Chapter73());
        put(74, new Chapter74());
        put(75, new Chapter75());
        put(76, new Chapter76());
        put(77, new Chapter77());
        put(78, new Chapter78());
        put(79, new Chapter79());

        put(80, new Chapter80());
        put(81, new Chapter81());
        put(82, new Chapter82());
        put(83, new Chapter83());
        put(84, new Chapter84());
        put(85, new Chapter85());
        put(86, new Chapter86());
        put(87, new Chapter87());
        put(88, new Chapter88());
        put(89, new Chapter89());

        put(90, new Chapter90());
        put(91, new Chapter91());
        put(92, new Chapter92());
        put(93, new Chapter93());
        put(94, new Chapter94());
        put(95, new Chapter95());
        put(96, new Chapter96());
        put(97, new Chapter97());
        put(98, new Chapter98());
        put(99, new Chapter99());

        put(100, new Chapter100());
        put(101, new Chapter101());
        put(102, new Chapter102());
        put(103, new Chapter103());
        put(104, new Chapter104());
        put(105, new Chapter105());
        put(106, new Chapter106());
        put(107, new Chapter107());
        put(108, new Chapter108());
        put(109, new Chapter109());

        put(110, new Chapter110());
        put(111, new Chapter111());
        put(112, new Chapter112());
        put(113, new Chapter113());
        put(114, new Chapter114());
        put(115, new Chapter115());
        put(116, new Chapter116());
        put(117, new Chapter117());
        put(118, new Chapter118());
        put(119, new Chapter119());

        put(120, new Chapter120());
        put(121, new Chapter121());
        put(122, new Chapter122());
        put(123, new Chapter123());
        put(124, new Chapter124());
        put(125, new Chapter125());
        put(126, new Chapter126());
        put(127, new Chapter127());
        put(128, new Chapter128());
        put(129, new Chapter129());

        put(130, new Chapter130());
        put(131, new Chapter131());
        put(132, new Chapter132());
        put(133, new Chapter133());
        put(134, new Chapter134());
        put(135, new Chapter135());
        put(136, new Chapter136());
        put(137, new Chapter137());
        put(138, new Chapter138());
        put(139, new Chapter139());

        put(140, new Chapter140());
        put(141, new Chapter141());
        put(142, new Chapter142());
        put(143, new Chapter143());
        put(144, new Chapter144());
        put(145, new Chapter145());
        put(146, new Chapter146());
        put(147, new Chapter147());
        put(148, new Chapter148());
        put(149, new Chapter149());

        put(150, new Chapter150());
        put(151, new Chapter151());
        put(152, new Chapter152());
        put(153, new Chapter153());
        put(154, new Chapter154());
        put(155, new Chapter155());
        put(156, new Chapter156());
        put(157, new Chapter157());
        put(158, new Chapter158());
        put(159, new Chapter159());

        put(160, new Chapter160());
        put(161, new Chapter161());
        put(162, new Chapter162());
        put(163, new Chapter163());
        put(164, new Chapter164());
        put(165, new Chapter165());
        put(166, new Chapter166());
        put(167, new Chapter167());
        put(168, new Chapter168());
        put(169, new Chapter169());

        put(170, new Chapter170());
        put(171, new Chapter171());
        put(172, new Chapter172());
        put(173, new Chapter173());

        put(200, new Chapter200());
        put(201, new Chapter201());
    }};

    public Chapter get(int chapterNumber) {
        Chapter chapter = chapters.get(chapterNumber);
        if (chapter == null) {
            throw new RuntimeException("Chapter not found");
        }
        return chapter;
    }
}
