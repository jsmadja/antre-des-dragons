package fr.jsmadja.antredesdragons.pages.content;

import fr.jsmadja.antredesdragons.pages.types.Execution;
import fr.jsmadja.antredesdragons.entities.Pip;
import fr.jsmadja.antredesdragons.pages.types.Page;

public class Page49 extends Page {
    @Override
    public String getText() {
        return "Vous vous collez comme vous le pouvez à la paroi et vous amorcez une périlleuse " +
                "descente, centimètre par centimètre, cherchant des prises quasiment inexistantes sous " +
                "vos pieds. Du fond de l'abîme souffle un vent violent dont la puissance augmente " +
                "encore de façon alarmante pendant votre descente. Maintenant que vous vous êtes " +
                "vraiment lancé dans cette entreprise, l'abîme paraît beaucoup plus profond que vous ne " +
                "l'aviez imaginé. Beaucoup plus profond...\n" +
                "Ne regardez pas vers le bas ! La falaise se dérobe en dessous de vous sur des kilomètres, et des kilomètres, et des kilomètres, et... Ne regardez pas vers le bas ! ... des " +
                "kilomètres, et des kilomètres, et des kilomètres, et... vous êtes pris de vertige... Vous " +
                "tombez ! Rendez-vous au [14].";
    }

    @Override
    public Execution execute(Pip pip) {
        return pip.goToPage(PageNumber.page(14));
    }
}
