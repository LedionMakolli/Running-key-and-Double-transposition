# Running-key-and-Double-transposition

Ky projekt përmban tre klaasa Java që implementojnë dy algoritme të dhrymshme për dekriptim dhe enkriptim të teksit si dhe një klasë ku janë bërë testime për këto dy algoritme.

1.**Algoritmi Double Columnar Transposition** .

2.**ALgortimi Running Key Cipher** 

### Double Transposition - Enkriptimi

#### Cka ben?

**Double Transposition**  eshte nje metode enkriptimi qe perdor dy nderrime (transpozime) te rreshtave dhe kolonave te nje matrice per te perzier/ngaterruar tekstin e thjeshte (plaintext).

### Karakteristikat

- Siguria me e larte se Single Transposition sepse perdor dy hapa te pavarur transpozimi (dyfishon kompleksitetin). Nje sulmues qe provon te thyeje enkriptimin duhet te gjeje te dy çelesat, gje qe e ben me te veshtire krahasuar me nje transpozicion te vetem.
- Perdor dy çelesa:
  1. Çelesi i pare (rowKey): Perdoret per te nderruar rreshtat ne hapin e pare.
  2. Çelesi i dyte (colKey): Perdoret per te nderruar kolonat ne hapin e dyte.
- Me rezistent ndaj sulmeve te kriptoanalizes:
  1. Nje sulmues mund te provoje brute-force per te gjetur nje çeles, por me dy çelesa, koha e nevojshme rritet shume.
  2. Nese rowKey ka m! mundesi dhe colKey ka n! mundesi, kombinimi total behet m! × n!
- Nese teksti nuk ploteson plotesisht matricen, matrica mbushet me karaktere shtese ('X').


#### Si funksionon

   - **Hapi 1: Krijimi i Matrices** Teksti i thjeshte vendoset ne nje matrice sipas nje çelesi rreshtash.    
   - **Hapi 2: Transpozimi i Rreshtave** Rreshtat e matrices nderrohen sipas nje çelesi te pare (rowKey). 
   - **Hapi 3: Transpozimi i Kolonave** Kolonat e matrices nderrohen sipas nje çelesi te dyte (colKey).  
   - **Hapi 4: Leximi i Tekstit të Enkriptuar** Teksti merret duke lexuar matricen sipas rendit te ri.


#### Shpjegim

 - **Hapi 1: Nderto Matricen**
 - Rreshti 0: H E L L O W  
  Rreshti 1: O R L D X X  

 - **Hapi 2: Nderro rreshtat sipas rowKey = {1, 0}:**
 - Rreshti 1: O R L D X X  
 Rreshti 0: H E L L O W  

 - **Hapi 3: Nderro kolonat sipas colKey = {2, 0, 1, 3, 4, 5}:**
 - Kolona 2: L  
 Kolona 0: O  
 Kolona 1: R  
 Kolona 3: D  
 Kolona 4: X  
 Kolona 5: X  

- **Hapi 4: Rezultati pas nderrimit te kolonave:** 
- Rreshti 1: L O R D X X  
 Rreshti 0: L H E L O W  

- **Hapi 5: Lexo sipas rreshtave per tekstin e enkriptuar:**
- "LORDXX" + "LHELOW" → "LORDXXLHELOW"

### Double Columnar Transposition - Dekriptimi

#### Cka ben?

**Double Transposition Decryptor** - eshte procesi i rikthimit te tekstit te enkriptuar ne gjendjen e tij origjinale(plaintext), duke perdorur dy celesa per te bere transpozimin e kundert te kolonave dhe rreshtave te nje matrice.

### Karakteristikat
- Dekriptimi eshte i lidhur ngushte me rendin e celesave qe jane perdorur gjate enkriptimit.Per te arritur te teksti origjinal, duhet te njihen 
 saktesisht te dy celesat:rowKey - per riorganizimin e rreshatve,
                          colKey - per riorganizimin e kolonave.
- Saktesia e renditjes eshte kritike:Ndryshimi i vetem i nje vlere ne celes do te jape rezultat te gabuar.
- Matricat jane te njejta si gjate enkriptimit, por procesi i zbatimit te celesave ndodh ne rend te kundert per te kthyer teksin ne formen e tij te 
 meparshme.
- Karakteret shtese('X') qe jane perdorur per te plotesuar matricen gjate enkriptimit, hiqen ne fund te procesit te dekriptimit per te ruajtur 
 tekstin origjinal.

#### Si funksionon

  - **Hapi 1:Krijimi i Matrices nga teksti i enkriptuar**
  - **Hapi 2:Transpozimi i kundert i kolonave**
  - **Hapi 3:Transpozimi i kundert i rreshtave**
  - **Hapi 4:Leximi i tekstit te dekriptuar**
    
#### Shpjegim

  - **Hapi 1: Krijimi i matrices**
  -  Rreshti 0: L O R D X X
   - Rreshti 1: L H E L O W


  - **Hapi 2: Nderro Kolonat sipas colKey={2,0,1,3,4,5}**
   - Rreshti 0: O R L D X X
   - Rreshti 1: H E L L O W


  - **Hapi 3: Nderro rreshtat sipas rowKey={1,0}**
  -  Rreshti 0: H E L L O W
  -  Rreshti 1: O R L D X X


  - **Hapi 4: Lexo matricen per ta kthyer ne tekst te dekriptuar**
   - HELLOWORLDXX -> Hiq 'X' -> HELLOWORLD


### Running Key - Enkriptimi

#### Cka ben?

#### Si funksionon

#### Shpjegim

Running Key – Dekriptimi
Çka bën?
Dekripton një tekst të koduar duke përdorur metodën "Running Key", ku çelësi është një tekst i gjatë (zakonisht një paragraf ose fjali nga një libër). Ky çelës duhet të jetë të paktën po aq i gjatë sa teksti i enkriptuar.

Si funksionon?

Merr tekstin e koduar dhe një tekst çelës që është të paktën po aq i gjatë sa ai i koduar.

Merr vetëm pjesën e parë të çelësit që ka të njëjtën gjatësi me tekstin e koduar.

Për secilën shkronjë në tekstin e koduar:

Krahason me shkronjën përkatëse nga çelësi.

Llogarit dallimin mes tyre duke përdorur pozicionet në alfabet.

Shkronja që rezulton është pjesë e tekstit të dekriptuar.

Në fund, bashkon të gjitha shkronjat e zbërthyera dhe krijon tekstin origjinal.

Shpjegim:
Ky funksion merr tekstin e koduar dhe e zbërthen duke përdorur shkronjat e çelësit si udhëzues për të kuptuar se cilat shkronja origjinale ishin përdorur.
Ai funksionon edhe nëse shkronjat janë me të vogla ose të mëdha dhe ruan formatin e tyre në përfundim.




