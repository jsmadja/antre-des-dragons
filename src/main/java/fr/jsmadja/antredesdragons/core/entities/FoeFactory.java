package fr.jsmadja.antredesdragons.core.entities;

import fr.jsmadja.antredesdragons.core.dices.Dice;
import fr.jsmadja.antredesdragons.core.dices.HitRollRange;
import fr.jsmadja.antredesdragons.core.dices.Roll;
import fr.jsmadja.antredesdragons.core.skills.DiesAfterNStrikesSpecialSkill;
import fr.jsmadja.antredesdragons.core.skills.InstantKillWithStrikesInARowSpecialSkill;
import fr.jsmadja.antredesdragons.core.skills.UseSpecialWeaponEveryNStrikes;
import fr.jsmadja.antredesdragons.core.stuff.HealthPoints;

import static fr.jsmadja.antredesdragons.core.inventory.Item.BLACK_KNIGHT_ARMOR;
import static fr.jsmadja.antredesdragons.core.inventory.Item.BLACK_KNIGHT_SPEAR;
import static fr.jsmadja.antredesdragons.core.inventory.Item.DRAGON_BLOW;
import static fr.jsmadja.antredesdragons.core.inventory.Item.DRAGON_FANG;
import static fr.jsmadja.antredesdragons.core.inventory.Item.DWARF_SWORD;
import static fr.jsmadja.antredesdragons.core.inventory.Item.GHOST_SWORD;
import static fr.jsmadja.antredesdragons.core.inventory.Item.MEDUSA_WEAPON;
import static fr.jsmadja.antredesdragons.core.inventory.Item.MONK_FIGHTING;
import static fr.jsmadja.antredesdragons.core.inventory.Item.MONSTER_CLAW;
import static fr.jsmadja.antredesdragons.core.inventory.Item.OGRE_CLUB;
import static fr.jsmadja.antredesdragons.core.inventory.Item.RABBIT_FANGS;
import static fr.jsmadja.antredesdragons.core.inventory.Item.RAMPANT_TONGUE;
import static fr.jsmadja.antredesdragons.core.inventory.Item.RAT_TEETH;
import static fr.jsmadja.antredesdragons.core.inventory.Item.STONEMAN_SWORD;
import static fr.jsmadja.antredesdragons.core.inventory.Item.STONEMONSTER_ARMOR;
import static fr.jsmadja.antredesdragons.core.inventory.Item.TROLL_ARMOR;
import static fr.jsmadja.antredesdragons.core.inventory.Item.TROLL_SWORD;
import static fr.jsmadja.antredesdragons.core.inventory.Item.WOLF_SKIN;
import static fr.jsmadja.antredesdragons.core.stuff.HealthPoints.hp;
import static java.text.MessageFormat.format;

public class FoeFactory {

    public Foe createSpirit() {
        return Foe.builder()
                .name("Esprit")
                .dice(new Dice())
                .initialHealthPoints(hp(25))
                .hitRollRange(new HitRollRange(6))
                .constantHitDamage(3)
                .immuneToPhysicalDamages(true)
                .build();
    }

    public Foe createWolfRat() {
        Foe foe = Foe.builder()
                .name("Rat-Loup")
                .initialHealthPoints(hp(25))
                .build();
        foe.addAndEquip(RAT_TEETH);
        return foe;
    }

    public Foe createMinotaure() {
        return Foe.builder()
                .name("Minotaure")
                .dice(new Dice())
                .hitRollRange(new HitRollRange(6))
                .initialHealthPoints(HealthPoints.hp(10))
                .build();
    }

    public Foe createFish() {
        return Foe.builder()
                .name("Poisson")
                .initialHealthPoints(hp(10))
                .build();
    }

    public Foe createDwarf(Roll roll, int i) {
        Foe foe = Foe.builder()
                .initialHealthPoints(hp(10))
                .build();
        if (i <= roll.getValue()) {
            foe.loseInitiative();
        }
        foe.addAndEquip(DWARF_SWORD);
        return foe;
    }

    public Foe createMedusa() {
        Foe foe = Foe.builder()
                .name("Méduse")
                .initialHealthPoints(hp(100))
                .requiredStrikesInARowToHitInvisible(3)
                .build();
        foe.addAndEquip(MEDUSA_WEAPON);
        foe.add(new InstantKillWithStrikesInARowSpecialSkill(2));
        return foe;
    }

    public Foe createMonster() {
        Foe foe = Foe.builder()
                .name("Monstre")
                .initialHealthPoints(hp(80))
                .build();
        foe.addAndEquip(MONSTER_CLAW);
        return foe;
    }

    public Foe createRampant() {
        Foe foe = Foe.builder()
                .name("Rampant")
                .initialHealthPoints(hp(20))
                .build();
        foe.addAndEquip(RAMPANT_TONGUE);
        foe.add(new InstantKillWithStrikesInARowSpecialSkill(1));
        return foe;
    }

    public Foe createForm(int i) {
        Foe foe = Foe.builder()
                .name("Forme #" + i)
                .initialHealthPoints(hp(4))
                .constantHitDamage(15)
                .build();
        foe.loseInitiative();
        return foe;
    }

    public Foe createWeakForm(int i) {
        Foe foe = Foe.builder()
                .name("Forme #" + i)
                .constantHitDamage(15)
                .build();
        foe.add(new DiesAfterNStrikesSpecialSkill(1));
        return foe;
    }

    public Foe createBronzeDragoon() {
        Foe foe = Foe.builder()
                .dragon(true)
                .name("Dragon de Bronze")
                .initialHealthPoints(hp(150))
                .build();
        foe.addAndEquip(DRAGON_FANG);
        foe.setInvisibleRequiredMinimumHitRoll(Roll.roll(8));
        foe.add(new UseSpecialWeaponEveryNStrikes(DRAGON_BLOW, 3));
        return foe;
    }

    public Foe createStoneMan() {
        Foe foe = Foe.builder().initialHealthPoints(hp(28)).build();
        foe.addAndEquip(STONEMAN_SWORD);
        return foe;
    }

    public Foe createGhost() {
        Foe foe = Foe.builder()
                .name("Fantôme")
                .initialHealthPoints(hp(30))
                .build();
        foe.addAndEquip(GHOST_SWORD);
        return foe;
    }

    public Foe getThatchedCreature() {
        return Foe.builder()
                .name("Créature de la chaumière")
                .initialHealthPoints(hp(5))
                .build();
    }

    public Foe createWolf() {
        Foe foe = Foe.builder()
                .name("Loup")
                .initialHealthPoints(hp(31))
                .build();
        foe.addAndEquip(WOLF_SKIN);
        return foe;
    }

    public Foe createMonk(int id) {
        Foe foe = Foe.builder()
                .name(format("Moine {0}", id))
                .initialHealthPoints(hp(25))
                .build();
        foe.addAndEquip(MONK_FIGHTING);
        return foe;
    }

    public Foe createWhiteRabbit() {
        Foe foe = Foe.builder()
                .name("Lapin Blanc")
                .initialHealthPoints(HealthPoints.hp(25))
                .build();
        foe.addAndEquip(RABBIT_FANGS);
        return foe;
    }

    public Foe createStoneMonster() {
        Foe foe = Foe.builder()
                .name("Monstre de Pierre")
                .initialHealthPoints(hp(18))
                .hitRollRange(new HitRollRange(7))
                .build();
        foe.addAndEquip(STONEMONSTER_ARMOR);
        return foe;
    }

    public Foe getWhistleWolf() {
        return Foe.builder()
                .name("Loup Siffleur")
                .initialHealthPoints(hp(15))
                .build();
    }

    public Foe createRockTroll(int i) {
        Foe foe = Foe.builder()
                .name("Troll des Rochers #" + i)
                .dice(new Dice()).initialHealthPoints(hp(10))
                .build();
        foe.addAndEquip(TROLL_SWORD);
        foe.addAndEquip(TROLL_ARMOR);
        return foe;
    }

    public Foe createBigOgre() {
        Foe foe = Foe.builder()
                .name("Ogre gigantesque")
                .initialHealthPoints(hp(40))
                .build();
        foe.addAndEquip(OGRE_CLUB);
        return foe;
    }

    public Foe createWickedSorcerer() {
        return Foe.builder()
                .name("Sorcier Malfaisant")
                .build();
    }

    public Foe createMeningeGnaw() {
        return Foe.builder()
                .name("Ronge-Méninges")
                .constantHitDamage(5)
                .initialHealthPoints(hp(15))
                .build();
    }

    public Foe createVampire() {
        return Foe.builder()
                .name("Vampire")
                .build();
    }

    public Foe createBlackKnight() {
        Foe foe = Foe.builder()
                .name("Chevalier Noir")
                .initialHealthPoints(hp(25))
                .build();
        foe.addAndEquip(BLACK_KNIGHT_ARMOR);
        foe.addAndEquip(BLACK_KNIGHT_SPEAR);
        return foe;
    }

}
