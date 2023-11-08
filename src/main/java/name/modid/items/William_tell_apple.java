package name.modid.items;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.world.World;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class William_tell_apple extends Item {

    public William_tell_apple(Settings settings) {
        super(new Item.Settings().food((new FoodComponent.Builder().hunger(6).saturationModifier(.6f).snack().build())));
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {

        user.addStatusEffect(new StatusEffectInstance(StatusEffects.INSTANT_DAMAGE, 1, 0));

        if (user instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) user;

            player.getInventory().offerOrDrop(new ItemStack(Items.ARROW));
        }
        return super.finishUsing(stack, world, user);
    }
}
