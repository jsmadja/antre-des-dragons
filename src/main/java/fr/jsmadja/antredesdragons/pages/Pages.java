package fr.jsmadja.antredesdragons.pages;

import fr.jsmadja.antredesdragons.pages.types.Execution;
import fr.jsmadja.antredesdragons.entities.Pip;
import fr.jsmadja.antredesdragons.pages.content.*;
import fr.jsmadja.antredesdragons.pages.types.Page;

import java.util.HashMap;
import java.util.Map;

public class Pages {

    public static final int DEBUT = -10;
    public static final int MERLIN = -9;
    public static final int MENACE_SUR_AVALAON = -8;
    public static final int DANS_LA_GROTTE_DE_CRISTAL_DE_MERLIN = -7;

    private Map<Integer, Page> pages = new HashMap<>() {{
        put(DEBUT, new PageDebut());
        put(MERLIN, new PageMerlin());
        put(MENACE_SUR_AVALAON, new PageMenaceSurAvalon());
        put(DANS_LA_GROTTE_DE_CRISTAL_DE_MERLIN, new PageGrotteDeCristal());
        put(1, new Page1());
        put(2, new Page2());
        put(3, new Page3());
        put(4, new Page4());
        put(5, new Page5());
        put(7, new Page7());
        put(10, new Page10());
        put(13, new Page13());
        put(14, new Page14());
        put(16, new Page16());
        put(18, new Page18());
        put(20, new Page20());
        put(21, new Page21());
        put(24, new Page24());
        put(25, new Page25());
        put(27, new Page27());
        put(30, new Page30());
        put(31, new Page31());
        put(49, new Page49());
        put(58, new Page58());
        put(59, new Page59());
        put(62, new Page62());
        put(64, new Page64());
        put(68, new Page68());
        put(71, new Page71());
        put(78, new Page78());
        put(80, new Page80());
        put(84, new Page84());
        put(85, new Page85());
        put(87, new Page87());
        put(88, new Page88());
        put(95, new Page95());
        put(98, new Page98());
        put(99, new Page99());
        put(102, new Page102());
        put(105, new Page105());
        put(108, new Page108());
        put(111, new Page111());
        put(114, new Page114());
        put(120, new Page120());
        put(123, new Page123());
        put(124, new Page124());
        put(126, new Page126());
        put(128, new Page128());
        put(129, new Page129());
        put(130, new Page130());
        put(135, new Page135());
        put(138, new Page138());
    }};

    public Pages() {
        System.out.println("Avancement : " + (this.pages.keySet().size() * 100D / 173D) + "%");
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
