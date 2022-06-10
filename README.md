# NeverHurtCam

This is a Minecraft mod that is designed to remove the camera shake when hurt on all Minecraft versions. Fabric, Forge, even vanilla and other clients.
It does NOT work as a Forge mod as of now.

## Usage of this mod

On Fabric you can put it in your mods folder.
On Forge you must (for now) follow the same instructions as for vanilla Minecraft.
On vanilla Minecraft you can add the Java argument -javaagent:PATHTONEVERHURTCAM. You may need to add \\ as separator instead of just \.
On Lunar Client, you can use [lunar-client-qt](https://github.com/Youded-byte/lunar-client-qt) and add it as an agent.

## Customisation

You may decide not to remove the whole camera shake when hurt. You can specify any value. Keep in mind that the shake strength value is normally 14, and this mod on default switches it to 0.
Add to your Java arguments -Dneverhurtcam=6 or any other value than 6 to change it.

## Future

In the optimal state, this mod would have an in-game config and would be toggleable, and would work as a forge mod as well. These are things that could be added.
On the more technical side, it would be great if there was a convenient way to access the fabric and forge classloaders, while loaded as mods in order to simply add our own transformer to it to increase compatibility and future-proofness.