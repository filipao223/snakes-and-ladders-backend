## Details

Some details about the implementation.

A game like this should probably be all processed in the frontend, using the backend to save details like player accounts and high scores, but due to my inexperience with frontend development and since Java was the main aim here, I decided to build an API and do all the processing on the backend.

We have two endpoints, "/game/reset" and "/game/move/{playerName}", which correspond respectively to a new game and a player move, which the frontend uses to get the game data and move the players.

Some things that could be improved/added:
 - Unit tests, for the API controllers and services
 - Make use of some configuration properties, like the frontendEnabled flag