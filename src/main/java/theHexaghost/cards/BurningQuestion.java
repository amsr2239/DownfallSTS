package theHexaghost.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAllEnemiesAction;
import com.megacrit.cardcrawl.actions.common.ModifyDamageAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.cards.DamageInfo.DamageType;
import com.megacrit.cardcrawl.cards.red.Rampage;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theHexaghost.HexaMod;
import com.megacrit.cardcrawl.powers.DexterityPower;
import com.megacrit.cardcrawl.powers.StrengthPower;

public class BurningQuestion extends AbstractHexaCard {
    public final static String ID = makeID("BurningQuestion");
    // intellij stuff skill, self, rare, 10, 2, 10, 2, 8, 2
    //ART:

    public BurningQuestion() {
        super(ID, 1, CardType.SKILL, CardRarity.RARE, CardTarget.SELF);
//        baseBlock = 5;
        baseMagicNumber = magicNumber = 2;
        isMultiDamage = true;
        isEthereal = true;
        tags.add(HexaMod.AFTERLIFE);
        HexaMod.loadJokeCardImage(this, "BurningQuestion.png");
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        applyToSelf(new StrengthPower(p,magicNumber));
        applyToSelf(new DexterityPower(AbstractDungeon.player,1));
    }

    @Override
    public void afterlife() {
        flash();
        applyToSelf(new DexterityPower(AbstractDungeon.player,1));
    }

//    @Override
//    public void calculateCardDamage(AbstractMonster mo) {
//        this.damage = baseDamage;
//    }


    @Override
    protected boolean useAfterlifeVFX() {
        return true;
    }

    public void upgrade() {
        if (!upgraded) {
            upgradeName();
            rawDescription = UPGRADE_DESCRIPTION;
            initializeDescription();
            upgradeMagicNumber(1);
        }
    }
}
