package fr.jsmadja.antredesdragons.core.skills;

import fr.jsmadja.antredesdragons.core.entities.Entity;
import fr.jsmadja.antredesdragons.core.stuff.Item;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class UseSpecialWeaponEveryNStrikesTest {

    @Test
    public void should_equip_special_weapon_every_3_strikes() {
        Entity attacker = mock(Entity.class);
        Entity target = mock(Entity.class);

        UseSpecialWeaponEveryNStrikes useSpecialWeaponEveryNStrikes = new UseSpecialWeaponEveryNStrikes(Item.DRAGON_BLOW, 3);

        when(attacker.getEquipedWeapon()).thenReturn(Optional.of(Item.DRAGON_FANG));

        // First 3 strikes
        when(attacker.getStrikes()).thenReturn(0);
        useSpecialWeaponEveryNStrikes.onAttack(attacker, target);
        verify(attacker, never()).unequip(Item.DRAGON_FANG);
        verify(attacker, never()).equip(Item.DRAGON_BLOW);

        when(attacker.getStrikes()).thenReturn(1);
        useSpecialWeaponEveryNStrikes.onAttack(attacker, target);
        verify(attacker, never()).unequip(Item.DRAGON_FANG);
        verify(attacker, never()).equip(Item.DRAGON_BLOW);

        when(attacker.getStrikes()).thenReturn(2);
        useSpecialWeaponEveryNStrikes.onAttack(attacker, target);
        verify(attacker, never()).unequip(Item.DRAGON_FANG);
        verify(attacker, never()).equip(Item.DRAGON_BLOW);

        when(attacker.getStrikes()).thenReturn(3);
        when(attacker.unequip(Item.DRAGON_FANG)).thenReturn(Item.DRAGON_FANG);
        useSpecialWeaponEveryNStrikes.onAttack(attacker, target);
        verify(attacker, times(1)).unequip(Item.DRAGON_FANG);
        verify(attacker, times(1)).equip(Item.DRAGON_BLOW);

        // Next 3 strikes
        when(attacker.getStrikes()).thenReturn(4);
        when(attacker.getEquipedWeapon()).thenReturn(Optional.of(Item.DRAGON_BLOW));
        useSpecialWeaponEveryNStrikes.onAttack(attacker, target);
        verify(attacker, times(1)).unequip(Item.DRAGON_BLOW);
        verify(attacker, times(1)).equip(Item.DRAGON_FANG);

        when(attacker.getStrikes()).thenReturn(5);
        when(attacker.getEquipedWeapon()).thenReturn(Optional.of(Item.DRAGON_FANG));
        useSpecialWeaponEveryNStrikes.onAttack(attacker, target);
        verify(attacker, times(1)).unequip(Item.DRAGON_FANG);
        verify(attacker, times(1)).equip(Item.DRAGON_BLOW);

        when(attacker.getStrikes()).thenReturn(6);
        when(attacker.unequip(Item.DRAGON_FANG)).thenReturn(Item.DRAGON_FANG);
        useSpecialWeaponEveryNStrikes.onAttack(attacker, target);
        verify(attacker, times(2)).unequip(Item.DRAGON_FANG);
        verify(attacker, times(2)).equip(Item.DRAGON_BLOW);
    }

}
