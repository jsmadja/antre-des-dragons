package fr.jsmadja.antredesdragons.core.spellcasting;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum SpellBook {

    AEP(new SpellAEP(), "Armure Etincellante de Pip", "Crée un mur de lumière d'un éclat insoutenable, tourbillonnant autour de qui a formulé le sortilège. Cette lumière agit comme une armure, et permet donc de retrancher 4 points des Points de Dommage éventuellement reçus. Ces points s'ajoutent à tous ceux qui pourraient être retranchés de la protection due à une véritable armure, un pourpoint en peau de dragon, etc."),
    HEP(new SpellHEP(), "Horion Epouvantable de Pip", "Permet d'ajouter 10 points aux Points de Dommage pouvant être infligés à un adversaire au prochain Assaut."),
    RIP(new SpellRIP(), "Rire Irrésistible de Pip", "Provoque chez un adversaire une telle hilarité, qu'il rate trois Assauts consécutifs."),
    FIP(new SpellFIP(), "Flèche Invisible de Pip", "Permet de décocher une flêche magique contre un adversaire hors de portée. Cette flèche ne manque jamais son but si le sortilège a été convenablement jeté, et provoque 10 points de Dommage."),
    PAP(new SpellPAP(), "Puissant Antidote de Pip", "Ce sortilège doit être jeté avant que le poison n'ai été ingurgité pour produire son effet, sinon il n'opère pas. Il rend insensible à tout poison, quels que soient les résultats obtenus par les dés. Il peut se révéler très utile lorsque l'on désire goûter une substance inconnue qui pourrait se nocive."),
    NIP(new SpellNIP(), "Neutralisant Instantané de Pip", "Permet de neutraliser dans l'instant l'effet d'un (unique) sortilège jeté sur un objet (et non sur un être vivant). Utile pour ouvrir placards, portes, tiroirs... tout ce qui peut être fermé par la magie."),
    MEP(new SpellMEP(), "Mouvement Eclair de Pip", "Au cours d'un combat, ce sortilège permet d'agir deux fois plus vite que d'habitude, et de porter deux coups consécutifs à chaque Assaut"),
    INVISIBILITY(new SpellInvisibility(), "Super Sortilège Invisibilité", "Ce sortilège très spécial ne peut être utilisé qu'une seule fois au cours d'une mission, au prix de 15 POINTS DE VIE et dans des conditions tout à fait particulières qui seront indiquées en temps voulu. Attention donc à ne pas gaspiller ces 15 points en utilisant inconsidérément le sortilège. Il a pour effet de rendre totalement invisible celui qui l'utilise."),
    FINGER_OF_FIRE(new SpellFingerOfFire(), "Doigt de Feu", "Fait jaillir un éclair du doigt, ce qui cause 10 Points de Dommage à un adversaire. Ce sortilège donne droit à dix éclairs. Mais une fois qu'il a été utilisé avec succès, il devient inopérant."),
    FIREBALL(new SpellFireBall(), "Boule de Feu", "Crée une énorme boule de feu au creux de la main qui, lancée contre un adversaire, lui inflige 75 Points de Dommage. Ce sortilège donne droit à deux boules seulement, une pour chaque main. Il est possible de conserver un éclair ou une boule de feu pour les utiliser par la suite.");

    @Getter
    private Spell spell;

    @Getter
    private String name;

    @Getter
    private String description;

}
