# Aragog
Web server listening to clock display updates

## WIP: Implementation needed

### Deployment

Package as a docker image? Prerequisite: can a raspberry pi 3 actually run docker?

Each instance of the server running represents one clock, and should either be subscribed to its own topic or should listen only to messages sent for it on a master topic, and not for other clock/servers. Meaning secrets passed in as a config?

