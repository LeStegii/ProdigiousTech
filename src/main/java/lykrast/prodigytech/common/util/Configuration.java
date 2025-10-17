package lykrast.prodigytech.common.util;

import lykrast.prodigytech.core.ProdigyTech;
import net.minecraftforge.common.config.Config;

@Config(modid = ProdigyTech.MODID)
public class Configuration {

    @Config.Comment("Machines configuration")
    public static final Machines MACHINES = new Machines();

    @Config.Comment("Power generation configuration")
    public static final Power POWER = new Power();

    @Config.Comment("Automation configuration")
    public static final Automation AUTOMATION = new Automation();

    @Config.Comment("Zorra Altar configuration")
    public static final Altar ALTAR = new Altar();

    public static class Machines {
        @Config.Comment("The base amount of time (in ticks) that the Incinerator takes to process 1 item")
        @Config.RangeInt(min = 1, max = 3000)
        public int incineratorProcessTime = 200;

        @Config.Comment("The chance that an item burned in the Incinerator gives Ash")
        @Config.RangeDouble(min = 0, max = 1.0)
        public float incineratorChance = 1.0F;

        @Config.Comment("Show the Incinerator recipe for Ash in JEI")
        public boolean incineratorJEI = true;

        @Config.Comment("The base amount of time (in ticks) that the Blower Furnace takes to process 1 item")
        @Config.RangeInt(min = 1, max = 3000)
        public int blowerFurnaceProcessTime = 300;

        @Config.Comment({
                "The base amount of time (in ticks) that the Rotary Grinder takes to process 1 item",
                "Several recipes have shorter or longer processing time, which are all derived from this value"
        })
        @Config.RangeInt(min = 1, max = 3000)
        public int rotaryGrinderProcessTime = 300;

        @Config.Comment("By how much ore outputs are multiplied by when passing them through the Rotary Grinder")
        @Config.RangeInt(min = 1, max = 10)
        public int rotaryGrinderOreMultiplier = 2;

        @Config.Comment({
                "Automatically generate Rotary Grinder, Magnetic Reassembler and Ore Refinery recipes to process ores?",
                "If false, only recipes for vanilla ores and Prodigigious Tech ingots will be registered"
        })
        public boolean autoOreRecipes = true;

        @Config.Comment("The base amount of time (in ticks) that the Heat Sawmill takes to process 1 item")
        @Config.RangeInt(min = 1, max = 3000)
        public int heatSawmillProcessTime = 200;

        @Config.Comment("Multiplier to the amount of planks the Heat Sawmil can extract from a single log (compared to manual crafting)")
        @Config.RangeDouble(min = 1.0, max = 10.0)
        public float heatSawmillPlankMultiplier = 1.5F;

        @Config.Comment("Multiplier to the amount of sticks the Heat Sawmil can extract from a single log (compared to manual crafting)")
        @Config.RangeDouble(min = 1.0, max = 10.0)
        public float heatSawmillStickMultiplier = 2.0F;

        @Config.Comment({
                "Automatically generate Heat Sawmill recipes to cut wood into planks",
                "If false, only recipes for vanilla logs and zorra will be registered"
        })
        public boolean heatSawmillAutoPlankRecipes = true;

        @Config.Comment({
                "The base amount of time (in ticks) that the Food Purifier takes to process an item, most will take much longer",
                "For reference, Beetroots take 2.2x that time, Rotten Flesh takes 4.8x and Steaks 20.8x"
        })
        @Config.RangeInt(min = 1, max = 300)
        public int foodPurifierBaseTime = 10;

        @Config.Comment({
                "The base amount of time (in ticks) that the Solderer takes to make 1 Crude Circuit",
                "The time of all other recipes are derived from this value"
        })
        @Config.RangeInt(min = 1, max = 3000)
        public int soldererProcessTime = 400;

        @Config.Comment("How much gold (in nuggets) can the Solderer hold in its internal buffer")
        @Config.RangeInt(min = 9, max = 20736)
        public int soldererMaxGold = 81;

        @Config.Comment({
                "The base amount of time (in ticks) that the Magnetic Reassembler takes to process 1 item",
                "Several recipes have shorter or longer processing time, which are all derived from this value"
        })
        @Config.RangeInt(min = 1, max = 3000)
        public int magneticReassemblerProcessTime = 300;

        @Config.Comment("The base amount of time (in ticks) that the Ore Refinery takes to process 1 item")
        @Config.RangeInt(min = 1, max = 3000)
        public int oreRefineryProcessTime = 100;

        @Config.Comment("By how much ore outputs are multiplied by when passing them through the Ore Refinery")
        @Config.RangeInt(min = 1, max = 10)
        public int oreRefineryOreMultiplier = 2;

        @Config.Comment("The chance the Ore Refinery produces a secondary ore")
        @Config.RangeDouble(min = 0, max = 1.0)
        public float oreRefineryChance = 0.25F;

        @Config.Comment("The base amount of time (in ticks) that the Automatic Crystal Cutter takes to harvest 1 stage")
        @Config.RangeInt(min = 1, max = 3000)
        public int automaticCrystalCutterHarvestTime = 100;

        @Config.Comment({
                "The time (in ticks) between 2 checks of the Automatic Crystal Cutter",
                "1 means every tick, 20 means once every second and so on",
                "Lower value will make them more reactive to crystal growing, but will make them slightly laggier when idle"
        })
        @Config.RangeInt(min = 1, max = 200)
        public int automaticCrystalCutterIdleTime = 60;

        @Config.Comment("The base amount of time (in ticks) that the Heat Accumulator takes to charge 20 ticks of an Heat Capacitor")
        @Config.RangeInt(min = 20, max = 200)
        public int capacitorChargerChargeTime = 30;

        @Config.Comment({
                "The base amount of time (in ticks) that the Fuel Processor takes to process a fuel that yields 1 Fuel Pellet",
                "Time for longer lasting fuels is derived from this value"
        })
        @Config.RangeInt(min = 1, max = 3000)
        public int fuelProcessorBaseTime = 60;

        @Config.Comment({
                "A multiplier to the amount of time the Food Enricher takes to process an item",
                "Actual time varies heavily depending on the enriched food and how much it enriches",
                "but is always much higher than this value"
        })
        @Config.RangeInt(min = 1, max = 50)
        public int foodEnricherBaseTime = 20;

        @Config.Comment("How much does one Food Enricher operation increases the food value (in half shanks)")
        @Config.RangeInt(min = 1, max = 20)
        public int foodEnricherFoodIncrease = 2;

        @Config.Comment("The Food Enricher will not increase a food's food value beyond this amount (in half shanks)")
        @Config.RangeInt(min = 1, max = 20)
        public int foodEnricherFoodCap = 20;

        @Config.Comment("How much does one Food Enricher operation increases the saturation ratio")
        @Config.RangeDouble(min = 0, max = 2.0)
        public float foodEnricherSaturationIncrease = 0.1F;

        @Config.Comment("The Food Enricher will not increase a food's saturation ratio beyond this amount")
        @Config.RangeDouble(min = 0, max = 10.0)
        public float foodEnricherSaturationCap = 1.2F;

        @Config.Comment("The base amount of time (in ticks) that the Primordialis Reactor takes to make 1 cycle")
        @Config.RangeInt(min = 1, max = 3000)
        public int primordialisReactorCycleTime = 60;

        @Config.Comment({
                "How many the Primordialis Reactor needs to consume to make 1 Primordium",
                "Note that this can be divided by up to 9 by putting different items",
                "This also means the number of cycles required ranges from this number to 1/81"
        })
        @Config.RangeInt(min = 9, max = 5760)
        public int primordialisReactorRequiredInput = 576;

        @Config.Comment({
                "The base amount of time (in ticks) that the Atomic Reassembler takes to process 1 item",
                "Several recipes have shorter or longer processing time, which are all derived from this value"
        })
        @Config.RangeInt(min = 1, max = 3000)
        public int atomicReshaperProcessTime = 200;

        @Config.Comment("How many Primordium items can the Atomic Reshaper hold in its internal buffer")
        @Config.RangeInt(min = 1, max = 64)
        public int atomicReshaperMaxPrimordium = 4;

        @Config.Comment("The base amount of time (in ticks) that 1 Tartaric Stoker lasts in the Tartaric Aeroheater")
        @Config.RangeInt(min = 1, max = Short.MAX_VALUE)
        public int tartaricStokerTime = 1600;
    }

    public static class Power {
        @Config.Comment({
                "A modifier to how fast Energion Crystals grow",
                "2 is about the growth of a single wheat on dry farmland, 4 is about single wheat on wet farmland"
        })
        @Config.RangeDouble(min = 0.1, max = 25.0)
        public float energionGrowthSpeed = 4.0F;

        @Config.Comment("The time (in ticks) one Energion Dust lasts in the Energion Aeroheater")
        @Config.RangeInt(min = 20, max = 1728000)
        public int energionDuration = 2000;

        @Config.Comment("The time (in ticks) a fully charged Heat Capacitor lasts")
        @Config.RangeInt(min = 20, max = 1728000)
        public int heatCapacitorDuration = 10 * 60 * 20;
    }

    public static class Automation {
        @Config.Comment({
                "The time (in ticks) between 2 push/pulls of an Extractor",
                "1 means every tick, 20 means once every second and so on"
        })
        @Config.RangeInt(min = 1, max = 200)
        public int extractorDelay = 10;

        @Config.Comment("How many items from a stack an Extractor can push/pull at once")
        @Config.RangeInt(min = 1, max = 64)
        public int extractorMaxStack = 64;
    }

    public static class Altar {
        @Config.Comment({
                "A multiplier applied to all enchantment costs on the Zorra Altar",
                "For example 1.5 means that everything costs 50% more than the base amount"
        })
        @Config.RangeDouble(min = 0.0, max = 10.0)
        public float altarCostMult = 0.6F;

        @Config.Comment({
                "Cost multiplier for the unknown option",
                "For example 0.5 means that the unknown option only costs 50% of the normal cost"
        })
        @Config.RangeDouble(min = 0.0, max = 10.0)
        public float altarUnknownMult = 0.5F;

        @Config.Comment({
                "How many levels beyond the normal maximum can the Zorra Altar apply enchantments",
                "Some enchantments don't take account of this limit"
        })
        @Config.RangeInt(min = 0, max = 100)
        public int altarBonusLvl = 3;
    }
}
