package collector.powers.collectioncards;

import collector.powers.AbstractCollectorPower;
import com.megacrit.cardcrawl.actions.common.ReducePowerAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

import static collector.util.Wiz.atb;

public class ThievesCardPower extends AbstractCollectorPower {
    public static final String NAME = "ThievesCard";
    public static final String POWER_ID = makeID(NAME);
    public static final PowerType TYPE = PowerType.BUFF;
    public static final boolean TURN_BASED = false;

    public ThievesCardPower(int amount) {
        super(NAME, TYPE, TURN_BASED, AbstractDungeon.player, null, amount);
    }

    @Override
    public float atDamageReceive(float damage, DamageInfo.DamageType damageType) {
        return damage / 2F;
    }

    @Override
    public void atEndOfRound()
    {
        flash();
        if (amount == 0) {
            atb(new RemoveSpecificPowerAction(owner, owner, this));
        } else {
            atb(new ReducePowerAction(owner, owner, this, 1));
        }
    }
}