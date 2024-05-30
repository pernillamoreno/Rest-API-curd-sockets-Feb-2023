
# Rest CRUD & Sockets 



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
