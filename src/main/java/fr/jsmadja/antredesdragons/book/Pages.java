package fr.jsmadja.antredesdragons.book;

import fr.jsmadja.antredesdragons.entities.Pip;
import fr.jsmadja.antredesdragons.pages.Execution;
import fr.jsmadja.antredesdragons.pages.Page;

import java.util.HashMap;
import java.util.Map;

public class Pages {

    public static final int DEBUT = -10;
    public static final int MERLIN = -9;
    public static final int MENACE_SUR_AVALAON = -8;
    public static final int DANS_LA_GROTTE_DE_CRISTAL_DE_MERLIN = -7;

    private final Map<Integer, Page> pages = new HashMap<>() {{
        put(DEBUT, new PageDebut());
        put(MERLIN, new PageMerlin());
        put(MENACE_SUR_AVALAON, new PageMenaceSurAvalon());
        put(DANS_LA_GROTTE_DE_CRISTAL_DE_MERLIN, new PageGrotteDeCristal());
        put(1, new Page1());
        put(2, new Page2());
        put(3, new Page3());
        put(4, new Page4());
        put(5, new Page5());
        put(6, new Page6());
        put(7, new Page7());
        put(8, new Page8());
        put(9, new Page9());
        put(10, new Page10());
        put(11, new Page11());
        put(12, new Page12());
        put(13, new Page13());
        put(14, new Page14());
        put(15, new Page15());
        put(16, new Page16());
        put(17, new Page17());
        put(18, new Page18());
        put(19, new Page19());
        put(20, new Page20());
        put(21, new Page21());
        put(22, new Page22());
        put(23, new Page23());
        put(24, new Page24());
        put(25, new Page25());
        put(26, new Page26());
        put(27, new Page27());
        put(28, new Page28());
        put(29, new Page29());
        put(30, new Page30());
        put(31, new Page31());
        put(32, new Page32());
        put(33, new Page33());
        put(34, new Page34());
        put(35, new Page35());
        put(36, new Page36());
        put(37, new Page37());
        put(38, new Page38());
        put(39, new Page39());
        put(40, new Page40());
        put(41, new Page41());
        put(42, new Page42());
        put(43, new Page43());
        put(44, new Page44());
        put(45, new Page45());
        put(46, new Page46());
        put(47, new Page47());
        put(48, new Page48());
        put(49, new Page49());
        put(50, new Page50());
        put(51, new Page51());
        put(52, new Page52());
        put(53, new Page53());
        put(54, new Page54());
        put(55, new Page55());
        put(56, new Page56());
        put(57, new Page57());
        put(58, new Page58());
        put(59, new Page59());
        put(60, new Page60());
        put(61, new Page61());
        put(62, new Page62());
        put(63, new Page63());
        put(64, new Page64());
        put(65, new Page65());
        put(66, new Page66());
        put(67, new Page67());
        put(68, new Page68());
        put(69, new Page69());
        put(70, new Page70());
        put(71, new Page71());
        put(72, new Page72());
        put(73, new Page73());
        put(74, new Page74());
        put(75, new Page75());
        put(76, new Page76());
        put(77, new Page77());
        put(78, new Page78());
        put(79, new Page79());
        put(80, new Page80());
        put(81, new Page81());
        put(82, new Page82());
        put(83, new Page83());
        put(84, new Page84());
        put(85, new Page85());
        put(86, new Page86());
        put(87, new Page87());
        put(88, new Page88());
        put(89, new Page89());
        put(90, new Page90());
        put(91, new Page91());
        put(92, new Page92());
        put(93, new Page93());
        put(94, new Page94());
        put(95, new Page95());
        put(96, new Page96());
        put(97, new Page97());
        put(98, new Page98());
        put(99, new Page99());
        put(100, new Page100());
        put(101, new Page101());
        put(102, new Page102());
        put(103, new Page103());
        put(104, new Page104());
        put(105, new Page105());
        put(106, new Page106());
        put(108, new Page108());
        put(111, new Page111());
        put(114, new Page114());
        put(120, new Page120());
        put(123, new Page123());
        put(124, new Page124());
        put(125, new Page125());
        put(126, new Page126());
        put(128, new Page128());
        put(129, new Page129());
        put(130, new Page130());
        put(135, new Page135());
        put(138, new Page138());
        put(155, new Page155());
    }};

    public Pages() {
        System.out.printf("Avancement : %.1f %%%n", this.pages.keySet().size() * 100D / 177D);
    }

    public static Page noPage() {
        return new Page() {
            @Override
            public String getText() {
                return "TODO";
            }

            @Override
            public Execution execute(Pip pip) {
                return Execution.empty();
            }
        };
    }

    public Page get(int pageNumber) {
        Page page = pages.get(pageNumber);
        if (page == null) {
            page = Pages.noPage();
        }
        return page;
    }
}
