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

#### Si funksionon

#### Shpjegim

### Running Key - Enkriptimi

#### Cka ben?

#### Si funksionon

#### Shpjegim




