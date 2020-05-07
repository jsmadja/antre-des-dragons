package fr.jsmadja.antredesdragons.book;

import fr.jsmadja.antredesdragons.entities.Pip;
import fr.jsmadja.antredesdragons.chapters.GoNextChapter;

public class Chapter166 extends GoNextChapter {
    @Override
    public int getNextChapter() {
        return 108;
    }

    @Override
    protected void beforeLeavingChapter(Pip pip) {
        super.beforeLeavingChapter(pip);
        pip.wounds(pip.getCurrentHealthPoints() / 2);
    }

    @Override
    public String getText() {
        return "Sans perdre un instant, vous sortez le Globe de votre sac, et vous soufflez dessus. Il " +
                "semble d'abord se troubler, puis il se met à flamboyer d'une éblouissante lumière " +
                "mauve. Un vaste bruissement d'ailes retentit alors au-dessus de vous : de toute  " +
                "évidence, le phénomène a dérangé les monstres. Vous respirez profondément et, le " +
                "cœur battant, vous vous avancez à pas comptés dans la caverne. Le Globe va-t-il vous " +
                "protéger ? Si la magie échoue, votre force, votre expérience et les sortilèges qui vous " +
                "restent ne vous aideront que momentanément contre les énormes créatures qui vont " +
                "fondre sur vous.\n" +
                "Les Dragons, nerveux, s'agitent, vous fixant d'un regard intense. Mais vous atteignez " +
                "l'extrémité de la première marche sans qu'ils aient autrement réagi, et vous avancez sur " +
                "la marche suivante. Le Dragon de Bronze demeure impassible, comme vous en avait " +
                "averti l'inscription figurant sur la plaque de cuivre. Du moins n'esquisse-t-il aucun " +
                "mouvement dans votre direction, attendant sans aucun doute que vous soyez arrivé à " +
                "sa hauteur. Vous hésitez quelque peu, et vous levez la tête. Les yeux des Dragons " +
                "luisent férocement, reflétant la lumière mauve du Globe. Soudain l'un d'eux prend son " +
                "élan d'une corniche, et se laisse tomber dans votre direction. Mais rapidement, il " +
                "déploie ses ailes et, amorçant un virage, regagne son perchoir. Vous êtes maintenant " +
                "au bout du deuxième degré, et vous descendez sur le suivant, quand soudain, la " +
                "lumière du Globe se ternit, vacille et s'éteint ! Pendant un long moment, un silence " +
                "absolu règne dans la caverne. Puis l'enfer semble se déchaîner au-des- sus de vous " +
                "lorsque les puissants Dragons prennent leur envol. Les battements de leurs grandes " +
                "ailes déclenchent une véritable tornade, et la caverne tout entière est illuminée par les " +
                "jets de feu qui sortent de leur gueule.\n" +
                "Vous lâchez le Globe qui se brise sur le sol, et vous dégainez votre épée. Mais le " +
                "combat qui vous attend est par trop inégal. Le premier monstre vous saisit dans ses " +
                "énormes griffes, et bientôt vous êtes environné d'un tourbillon d'ailes et de jets de " +
                "flammes. Avant de perdre connaissance, vous entendez une voix sonore qui résonne en " +
                "vous : Tu dois essayer de nouveau, Pip ! Essaye encore ! Encore ! Encore !\n" +
                "Lorsque vous reprenez conscience, vous êtes étendu sur le sol glacé d'une grotte. Les " +
                "Dragons ont disparu, mais vous avez perdu la moitié de vos POINTS DE VIE.\n" +
                "Rendez-vous au [108].";
    }
}
