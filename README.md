# AdminPanel

Paper 1.21.11 admin GUI inspired by txAdmin.

## Features
- `/admin` opens the panel
- Online player list with pagination
- Player information
- Ban: 10m, 1h, 1d, 7d, permanent
- Mute: 10m, 1h, 1d, 7d, permanent
- Kick
- Teleport
- Spectate
- View inventory
- Unmute
- Separate permissions
- Configurable messages/titles

## Build
1. Install Java 21.
2. Open this folder in IntelliJ IDEA or run `gradle build`.
3. The JAR will be in `build/libs/`.
4. Put the JAR in your server's `plugins` folder.
5. Restart the server.

## Permissions
- adminpanel.use
- adminpanel.ban
- adminpanel.mute
- adminpanel.kick
- adminpanel.teleport
- adminpanel.spectate
- adminpanel.inventory
- adminpanel.reload

A Paper plugin cannot directly bind an arbitrary keyboard key on the Minecraft client. `/admin` is used in v1.0. A client-side keybind can be added later with a Fabric/NeoForge companion mod.


The complete Java source is under `src/main/java/me/noxxll/adminpanel/`.
