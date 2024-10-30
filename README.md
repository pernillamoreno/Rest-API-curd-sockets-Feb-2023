
# Rest CRUD & Sockets 

Purpose of the Assignment

The purpose of this assignment is for students to demonstrate the ability to implement CRUD operations via a REST API with real-time updates through socket channels. Note that database solutions are expected to be used where appropriate.

Scope
Alternative socket solutions are acceptable after a guidance session.

Assignment Description
The subsidiary of Budget Ducklings Inc., named Phone Duck, heard about Gertrude getting stuck in traffic and wanted to help people in similar situations stay entertained. Their proposal is to allow users to join a permanent chat channel where participants can suggest chat meetups.

Task Requirements
This assignment is divided into two areas:

A REST API with endpoints that handle communication to announce new chat rooms (meetups) and delete created chat meetups. An announcement consists of an ID and a title.

REST API Endpoints

    [GET] /channels/ ← Retrieves a list of announced channels
    [POST] /channels/ ← Creates a new channel that is announced in the permanent chat channel
    [DELETE] /channels/{id} ← Deletes an announced channel

Students may decide how to handle participants in deleted channels. It is acceptable to let them remain after the announcement has been removed.

Socket Endpoints

/sub/channels/ ← A socket for the permanent chat channel. Here, announcements created via POST requests are sent.
/sub/chat/ ← One (or more) sockets to connect to a specific channel (via ID value), where you can listen to new messages from the channel and send replies via the same socket.




Syftet med inlämningsuppgiften är att studerande ska redovisa förmågan att implementera CRUD operationerna via ett REST API med realtidsuppdateringar via socket kanaler. Observera att du förväntas använda databaslösningar i uppgiften där det är lämpligt.

Avgränsningar: Alternativa socket lösningar godkänns efter handledningssamtal.
Uppdragsbeskrivning
Dotterbolaget till Budget Ducklings inc., vid namn Phone Duck, fick höra om Gertrude som fastnade i trafiken och ville då hjälpa utsatta i liknande situationer till att underhållas. Förslaget de tar fram är att låta användare ansluta till en permanent chatt-kanal där deltagare kan skicka förslag på chatt-träffar.
Uppgiftskrav
Denna uppgift delas in i två områden. Ett REST API med endpoints som hanterar kommunikationen för att annonsera nya chattrum (träffar) samt för att ta bort en skapad chatträff. En annons består av ett id och en titel.

REST API endpoints
[GET] /channels/ ← Hämtar en lista över annonserade kanaler
[POST] - /channels/ ← skapar en ny kanal som annonseras i den permanenta chatt-kanalen.
[DELETE] /channels/{id} ← tar bort en annonserad kanal

Studerande väljer hur deltagare av borttagna kanaler hanteras. Det är ok att låta de vara kvar efter att annonsen är borttagen.

Socket endpoints
/sub/channels/ ← en socket för den permanenta chatt-kanalen. Här skickas annonser som har skapats via POST förfrågan.
/sub/chat/ ← en (eller flera) socket där du ansluter mot en specifik kanal (via id-värde) och lyssnar på nya meddelanden från kanalen samt kan skicka tillbaka svar via samma socket. **
