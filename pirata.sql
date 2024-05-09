-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Mag 09, 2024 alle 22:51
-- Versione del server: 10.4.32-MariaDB
-- Versione PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pirata`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `acquisti`
--

CREATE TABLE `acquisti` (
  `id` int(11) NOT NULL,
  `id_utente` int(11) NOT NULL,
  `data_acquisto` date NOT NULL,
  `costo_spedizione` double DEFAULT NULL,
  `importo_totale` decimal(10,2) NOT NULL,
  `metodo_di_pagamento` varchar(30) NOT NULL,
  `indirizzo_spedizione` varchar(50) DEFAULT NULL,
  `stato_pagamento` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `acquisti`
--

INSERT INTO `acquisti` (`id`, `id_utente`, `data_acquisto`, `costo_spedizione`, `importo_totale`, `metodo_di_pagamento`, `indirizzo_spedizione`, `stato_pagamento`) VALUES
(26, 21, '2024-05-09', 0, 34.30, 'cartaCredito', 'JAITA111', 'In corso');

-- --------------------------------------------------------

--
-- Struttura della tabella `categorie`
--

CREATE TABLE `categorie` (
  `id` int(11) NOT NULL,
  `tipo` varchar(20) NOT NULL,
  `icona` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `categorie`
--

INSERT INTO `categorie` (`id`, `tipo`, `icona`) VALUES
(1, 'Abbigliamento', 'categoria1.png'),
(2, 'Gadget', 'categoria2.png'),
(3, 'Giochi', 'categoria3.png'),
(4, 'Gioielli', 'categoria4.png'),
(5, 'Opere Artistiche', 'categoria5.png'),
(6, 'Opere Multimediali', 'categoria6.png'),
(7, 'Opere Narrative', 'categoria7.png');

-- --------------------------------------------------------

--
-- Struttura della tabella `ordini`
--

CREATE TABLE `ordini` (
  `id_prodotto` int(11) NOT NULL,
  `id_acquisto` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `ordini`
--

INSERT INTO `ordini` (`id_prodotto`, `id_acquisto`) VALUES
(78, 26),
(7, 26),
(40, 26);

-- --------------------------------------------------------

--
-- Struttura della tabella `prodotti`
--

CREATE TABLE `prodotti` (
  `id` int(11) NOT NULL,
  `id_sottocategoria` int(11) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `descrizione` text NOT NULL,
  `prezzo` decimal(10,1) NOT NULL,
  `immagine` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `prodotti`
--

INSERT INTO `prodotti` (`id`, `id_sottocategoria`, `nome`, `descrizione`, `prezzo`, `immagine`) VALUES
(1, 1, 'Costume Pirata da Uomo', 'Un pirata misterioso e spaventoso farà la sua apparizione nelle vostre serate in maschera.', 70.0, 'prodotto1.png'),
(2, 1, 'Maglietta con teschio', 'Maglietta 100% cotone, nera. Vivi un senso di avventura e stile pirata in modo divertente e alla moda!', 17.0, 'prodotto2.png'),
(3, 1, 'Maglietta dei Pirati', 'Vuoi sentirti un vero pirata? Ora puoi farlo con la maglietta del mitico pirata, il capitan Jack Sparrow!', 14.0, 'prodotto3.png'),
(4, 2, 'Costume Pirata per Donne', 'Set composto da abito, cappello da pirata con nastri e cintura con fibbie marroni (accessori non inclusi).', 40.0, 'prodotto4.png'),
(5, 2, 'T-Shirt Costume da Pirata', 'I nostri costumi da pirata sono perfetti per feste di compleanno a tema Halloween, Carnevale, Pirati e altro ancora!', 25.0, 'prodotto5.png'),
(6, 2, 'Maglietta Mamma Pirata', 'Questa maglia per mamme da pirata è realizzata in morbido cotone, perfetta per un look casual e pieno di personalità.', 9.0, 'prodotto6.png'),
(7, 3, 'Costume Pirata Bambino', 'Questo set da vestito da bambino da pirata è perfetto per avventure in stile marinaresco e giochi pieni di immaginazione.', 20.0, 'prodotto7.png'),
(8, 3, 'Maglietta Pirata Bambini', 'La maglietta \"Little Pirates\" è l\'ideale per i piccoli esploratori e sognatori che amano le storie di pirati.', 10.0, 'prodotto8.png'),
(9, 3, 'Maglietta Pirata Bambine', 'Ideale per le giovani esploratrici che desiderano esprimere il loro amore per l\'avventura in modo alla moda e divertente.', 13.0, 'prodotto9.png'),
(10, 4, 'Apribottiglie con ancora', 'Questo apribottiglia è pronto a sollevare il tuo spirito pirata e aprire nuovi orizzonti di divertimento e avventura.', 6.0, 'gadget1.png'),
(11, 5, 'Skull One Piece', 'Un tesoro per i fan di One Piece, che potranno mostrare il loro amore per la serie, con uno stile unico e accattivante. ', 9.0, 'gadget2.png'),
(12, 5, 'Capitano Jack Sparrow', 'Un fantastico portachiavi dei Pirati dei Caraibi.\r\nAvrai un pezzo di questo meraviglioso universo in tasca!', 8.6, 'gadget3.png'),
(13, 4, 'Cavatappi a forma Pirata', 'Altro che Barbanera, \'Legless\' e\' il bucaniere piu\' temuto nei bar!\r\nCavatappi con leva per lo stappamanto e apribottiglie.', 14.3, 'gadget4.png'),
(14, 4, 'The Scurvy Dog', 'Dopo essere stato abbandonato su un\'isola rocciosa dai suoi compagni di ciurma, questo pirata si è ammalato di scorbuto.', 15.4, 'gadget5.png'),
(15, 4, 'The Smuggler', 'Un regalo ideale per gli appassionati di pirati moderni e chiunque apprezzi la qualità e l\'originalità di un accessorio artigianale versatile e resistente.', 16.1, 'gadget6.png'),
(16, 1, 'T-Shirt Capitano ', 'T-Shirt pirata da indossare durante i giochi dei pirati, a una carnevale party o in barca a vela su una nave pirata.', 13.8, 'prodotto10.png'),
(17, 2, 'Gilet Pirata Vichingo', 'L\'ideale per feste a tema pirata o steampunk, trasmette un senso di avventura e intraprendenza a chi lo indossa.', 18.0, 'prodotto11.png'),
(18, 3, 'Vestito da Pirata', 'Il set da pirata del martedì grasso è composto da un totale di 24 pezzi che soddisfano le esigenze di costume del bambino.', 26.0, 'prodotto12.png'),
(19, 9, 'Agenda Vintage Pirata', 'Un gioiello per gli amanti dell\'avventura e del fascino del mare.\r\nPresenta dettagli raffinati che richiamano l\'epoca dei pirati.', 10.7, 'gadget7.png'),
(20, 9, 'Quaderno Pirata', 'Aaaarrrrrrrr, marinaio... vivere la vita di un pirata richiede un\'audace dichiarazione d\'identità! Diario perfetto per pirati o avventurieri di ogni età.', 12.0, 'gadget8.png'),
(21, 9, 'Taccuino Pirata Vintage', 'Perfetta per chi ama unire il pratico al fantastico, portando con sé un pezzo di atmosfera avventurosa e misteriosa.', 8.3, 'gadget9.png'),
(24, 9, 'Agenda Pirata', 'Ideale per gli amanti del tema pirata e per coloro che apprezzano il design nostalgico. Arricchita da dettagli retrò.', 8.9, 'gadget10.png'),
(25, 5, 'Portachiavi Ancora Rudder', 'Accessorio affascinante per gli amanti dell\'avventura pirata. Questo portachiavi presenta un design dettagliato e suggestivo.', 3.5, 'gadget11.png'),
(26, 5, 'Pirata di Gomma', 'Se sei un fan di One Piece, questo portachiavi sarà un\'aggiunta fantastica al tuo collezionismo o un regalo apprezzato.', 11.0, 'gadget12.png'),
(27, 10, 'One Piece - New Edition (Vol. 1)', 'Si riparte con le origini, l\'incontro di Rufy con Shanks il Rosso, l\'ingestione del Frutto del Diavolo Gom Gom che dona poteri \"elastici\", e con la partenza dall\'isoletta alla volta della più grande avventura piratesca mai concepita!', 4.9, 'narrative1.png'),
(28, 10, 'One Piece - Celebration Edition (Vol. 98)', 'Nel fantasmagorico universo di One Piece non esiste la parola \"riposo\", e l\'instancabile mente del maestro Oda è costantemente al lavoro per partorire nuove, pazzesche avventure da far vivere alla masnada di pirati più bizzarra che ci sia.', 6.6, 'narrative2.png'),
(29, 10, 'One Piece - Celebration Edition (Vol. 99)', 'Corredata di una sovraccoperta in pvc che, affiancata a quella del volume 98, va a comporre un\'unica illustrazione. Nei due numeri di questa speciale edizione trovate le due metà di un maxi poster a colori che, riunite, formano un poster!', 6.6, 'narrative3.png'),
(30, 10, 'One Piece - New Edition (Vol. 103)', 'Dopo che Sanji e Zoro hanno sconfitto due delle Star di prima classe, lo scontro tra Rufy e Kaido si fa ancora più violento! Nel frattempo Kidd & Law, che stanno affrontando Big Mom, danno vita a una battaglia al limite della sopravvivenza...', 4.9, 'narrative4.png'),
(31, 11, 'Drake - Il corsaro che sfidò un impero', 'Le imprese di Francis Drake, il grande corsaro inglese al servizio della regina Elisabetta I, hanno qualcosa di veramente epico. Fu un uomo capace di sfidare da solo, dopo gli iniziali raid condotti nel Mar dei Caraibi, l’impero spagnolo in America. Troverete un mondo affascinante e sorprendente ancora dominato dagli spazi bianchi sulle carte.', 19.0, 'narrative5.png'),
(32, 11, 'Stevenson - L\'isola del Tesoro', 'Un tesoro nascosto su un’isola, il coraggioso Jim Hawkins, il pirata Long John Silver e la sua gamba di legno: i protagonisti dell’Isola del tesoro sono entrati a far parte dell’immaginazione di ogni generazione, e il viaggio dell’Hispaniola alla volta dell’isola rappresenta il punto di riferimento per qualunque storia di pirati.', 9.5, 'narrative6.png'),
(33, 11, 'Levenseller - La figlia del Re dei Pirati', 'Alosa, capitana di una nave pirata, ha diciassette anni e una missione: recuperare un\'antica mappa, chiave per trovare un fantastico tesoro. Per riuscirci, si lascia catturare dai pirati nemici. Tra lei e la mappa c\'è solo un ostacolo: Riden.\r\nAzione, avventura, amore e un pizzico di magia sono gli ingredienti di questa storia di pirati.', 14.3, 'narrative7.png'),
(34, 11, 'Legend: La leggenda di Capitan Morgan', 'La vita segreta di Jack Sparrow, ci porta verso una destinazione insolita, in una versione in cui non si era mai visto.\r\nLo ritroviamo in viaggio sulle terre aride del Marocco, alla ricerca di ciò a cui più tiene al mondo.\r\nSulla sua scia non mancheranno figure conosciute pronte a dare sostegno, fedeli compagne che sapranno essere d\'aiuto.\r\n', 17.7, 'narrative8.png'),
(35, 12, 'Disney - Le più belle storie di pirati', 'In questo volume sono narrate le avventure dei pirati interpretate dai personaggi Disney tra isole del tesoro e arrembaggi! Età di lettura: da 7 anni.', 9.4, 'narrative9.png'),
(36, 12, 'Barbanera - Il Re dei Pirati', 'La leggendaria vicenda del re dei pirati! Simbolo del nemico dei mari, arriva l\'avventura picaresca che racconta l\'esistenza di Barbanera!', 6.6, 'narrative10.png'),
(37, 12, 'Geronimo Stilton - L\'isola del Tesoro Fantasma', '\"Prima un viaggio mozzafiato in aereo, poi il naufragio su un\'isola deserta, dove di notte si sentono strani rumori. Forse è il fantasma del Pirata Zampadargento\"', 10.3, 'narrative11.png'),
(38, 12, 'Giacomo Nodari - L\'isola del Tesoro', 'La scoperta di una mappa misteriosa lo catapulta in un mondo di enigmi. Jim è un esempio di coraggio che ispira i giovani a seguire i propri sogni.', 8.5, 'narrative12.png'),
(39, 13, 'Tortuga Pirati ', 'Un gioco di carte perfetto per lanciarsi in avventure piratesche alla ricerca di grandi tesori\r\nContiene 2 mazzi di carte illustrate con Navi e Tesori per giocare con gli amici a conquistare quanti più tesori possibili e raggiungere il punteggio più alto.', 7.9, 'giochi1.png'),
(40, 13, 'Sblocca La Porta', 'Il fenomeno degli Escape Game diventa un gioco anche per i più piccoli!\r\nUn\'avventura a colpi di rompicapo e un viaggio da gustare recuperando tutti gli indizi e risolvendo gli enigmi allenando la mente e il pensiero laterale.\r\nUn mazzo di carte e oggetti utili per scovare gli indizi.', 7.0, 'giochi2.png'),
(41, 13, 'Tiny Epic Pirates', 'Arr, pendagli da forca, non pensiate che qui sulla MIA NAVE si possa battere la fiacca: mano ai cannoni e su con le sciabole, perché il tempo dell\'arrembaggio è vicino. Le grandi ricchezze dei Caribi ci aspettano. E per tutti gli altri, c\'è solo l\'asse!\r\nUn gioco di razzie e galeoni.', 30.0, 'giochi3.png'),
(42, 13, 'Sea of Legends', 'Un gioco di avventura pirata ambientato in un mondo di leggende e misteri marini. I giocatori assumono il ruolo di capitani pirata, esplorando le acque dei Caraibi, compiendo imprese eroiche, commerciando con le città costiere e cercando tesori nascosti.', 109.9, 'giochi4.png'),
(43, 14, 'Funko Pop! Disney: Pirates of the Caribbean ', 'Se sei un fan dei Pirati dei Caraibi o di Jack Sparrow, questo Funko Pop! speciale è un must-have per la tua collezione. È anche un ottimo regalo per altri appassionati dei film Disney e dei personaggi iconici come Jack Sparrow.', 30.4, 'giochi5.png'),
(44, 14, 'Inconnu Pirati dei Caraibi – Jack Sparrow', 'È tornato Jack Sparrow, il più grande pirata di cui tu abbia mai sentito parlare. Con cappello, spada e pistola rimovibili, Jack continua la tradizione di grandezza iniziata con i grandi successi di DST ispirati alla Disney.', 35.4, 'giochi6.png'),
(45, 14, 'Set di action figure pirata per bambini ', 'Salpa per un\'avventura pirata con 8 figurine squisitamente dipinte a mano. \r\nVivi una scena realistica dei pirati con una nave pirata e una barca che possono adattarsi alle statuette, aiutando i bambini a conoscere lo stile di vita unico dei pirati.', 25.0, 'giochi7.png'),
(46, 14, 'Walt Disney Peter Pan - Capitan Uncino', 'Esplora il fascino del classico cattivo Disney con la figura di Capitan Uncino da Peter Pan di Bullyland. Realizzata artigianalmente e priva di PVC, questa figura dipinta a mano è un must per i fan e i collezionisti di tutte le età.', 12.2, 'giochi8.png'),
(47, 15, 'URGEAR Creator Pirate Ship Set di Costruzione', 'Accendi l\'immaginazione del tuo bambino mentre si imbarca in un emozionante viaggio creativo, costruendo la propria nave pirata e dando vita alle loro avventure immaginarie. Costruisci, personalizza e naviga sulla propria nave, partecipando a missioni, scoprendo tesori e combattendo sui mari. Intraprendi un straordinario viaggio di immaginazione e scoperta!', 50.0, 'giochi9.png'),
(48, 15, 'JMBricklayer 40001 Flying Dutchman', 'Incantevole esperienza di nave fantasma: rivivi la leggendaria storia, esplora i misteriosi mari dei pirati e intraprendi un\'avventura ispirata alla nave fantasma dell\'olandese volante. Ricostruite la nave fantasma che non potrà mai ancorare e godetevi con questo set di giocattoli a nave pirata un\'esperienza creativa e di costruzione incomparabile per gli appassionati di pirati.', 73.5, 'giochi10.png'),
(49, 15, 'CubicFun Puzzle 3D LED 68 CM Black Pearl ', 'La Queen Anne\'s Revenge è una nave pirata scavata cava che la rende una combinazione meglio illuminata con luce calda. Lo slot per schede è appositamente progettato per l\'allineamento del cavo della lampada e il cavo della lampada può essere fissato durante l\'installazione. Ci sono 15 perline di lampada calde nella nave, che la rendono più realistica e misteriosa, specialmente nella notte oscura. ', 44.0, 'giochi11.png'),
(50, 15, 'SILENT MARY - LEGO 71042', 'Sono tornati i Pirati dei Caraibi firmati Disney con la fantastica Silent Mary 71042! Questo modello in verione LEGO della nave fantasma è altamente dettagliato ed è composto da 2294 mattoncini e 8 minifigure: il capitano Jack Sparrow, Henry, Carina, il tenente Lesaro, il capitano Salazar, l’ufficiale Magda, l’ufficiale Santos e il colombiere della Silent Mary, oltre due squali fantasma.', 389.0, 'giochi12.png'),
(51, 16, 'Disney - Il Pianeta Del Tesoro', 'Cresciuto con la mamma, l\'adolescente scavezzacollo Jim Hawkins si mette spesso nei guai per le scorribande a bordo del suo Solar Surfer. Tuttavia, con l\'aiuto di B.E.N., Jim riuscirà a trovare il tesoro...', 15.0, 'multimediali1.png'),
(52, 16, 'Disney - La Maledizione della Prima Luna', 'La figlia del governatore viene rapita da un pirata malvagio. Will Turner, amico d\'infanzia della ragazza segretamente innamorato di lei, si unisce a Jack Sparrow, per portare in salvo la fanciulla.', 10.0, 'multimediali4.png'),
(53, 16, 'Disney - Pirati dei Caraibi 4: Oltre I Confini del Mare', 'In compagnia di Barbarossa, il capitano Jack Sparrow parte alla ricerca della Fontana della giovinezza. I due scoprono però che anche Barbanera e sua figlia hanno intrapreso la stessa missione.', 10.0, 'multimediali3.png'),
(54, 16, 'Disney - Pirati dei Caraibi 5: La vendetta di Salazar', 'Il Capitano Salazar riesce a uscire dal Triangolo del Diavolo. L\'unica speranza di salvezza per Jack Sparrow è il Tridente di Poseidone, ma per recuperarlo è costretto a stringere un\'insolita alleanza.', 20.1, 'multimediali2.png'),
(55, 17, 'Sea of Thieves', 'Esplora un vasto mondo aperto popolato da isole incontaminate, relitti di navi affondate e misteriosi manufatti. Cerca tesori perduti e affronta i Capitani degli scheletri maledetti e proteggi il carico!', 40.0, 'multimediali5.png'),
(56, 17, 'Blazing Sails ', 'Combatti per sopravvivere, crea il tuo pirata e la tua nave. Unisciti ad altri giocatori e comanda il tuo vascello! Esplora diverse modalità di gioco, mappe, armi e altro, eliminando altre ciurme in battaglie!', 14.8, 'multimediali6.png'),
(57, 17, 'Skull and Bones\r\n', 'Entra nel pericoloso mondo di Skull and Bones, giocando secondo le tue regole per arricchirti e diventare il capo pirata più temuto. Disponibile su Ubisoft Connect, Epic Games, PlayStation 5, Xbox Series X/S.', 60.0, 'multimediali7.png'),
(58, 17, 'Pirati dei Caraibi', 'Per il corpo di mille balene! Disney Interactive Studios e TT Games ti invitano a issare bandiera nera e a salpare l\'ancora in un mare di avventure con LEGO® Pirati dei Caraibi Il Videogioco per Nintendo 3DS. ', 20.0, 'multimediali8.png'),
(59, 18, 'Pirates - Visions of Atlantis', 'Un\'epica avventura musicale che combina elementi di symphonic metal, power metal e gothic metal con temi marinareschi e pirati. Questo album rappresenta un viaggio emozionante attraverso storie di pirateria, coraggio e romanticismo.', 19.0, 'multimediali9.png'),
(60, 18, 'Pirates II - Armada - Visions of Atlantis', 'Un\'avventura musicale epica che trasporta l\'ascoltatore in un viaggio attraverso mari tempestosi e terre misteriose. Rappresenta il secondo capitolo della saga dei pirati immaginata dalla band di symphonic metal Visions of Atlantis.', 22.7, 'multimediali10.png'),
(61, 18, 'Pirates of the Caribbean, Vol. 3', 'La colonna sonora del terzo film della serie cinematografica \"Pirati dei Caraibi\". Questo album rappresenta un\'avvincente raccolta di brani musicali che accompagnano le epiche avventure dei pirati nei mari misteriosi e pericolosi.', 13.0, 'multimediali11.png'),
(62, 18, 'Pirates Of The Caribbean: Dead Men Tell No Tales', 'La colonna sonora del quinto film della serie \"Pirati dei Caraibi\". Questo album rappresenta un\'emozionante e avvincente raccolta di brani musicali che accompagnano le avventure e le sfide dei pirati nei mari infestati da pericoli.', 15.9, 'multimediali12.png'),
(67, 19, 'SY-Home Scultura Busto in Arenaria, Statua in Resina Modello Capitano Pirata', 'Questa scultura del capitano pirata è un\'opera d\'arte che evoca il fascino romantico e avventuroso dell\'epoca dei pirati. È un punto focale perfetto per decorare uno spazio dedicato all\'avventura e al mare, trasportando chi lo osserva in un mondo di mistero e di fascino dei mari.', 88.8, 'artistiche1.png'),
(68, 19, 'Scultura in bronzo del Capitano Pirata, decorazioni per la casa', 'Questa scultura in bronzo del capitano pirata è un\'opera d\'arte suggestiva e dettagliata che cattura l\'essenza avventurosa e misteriosa di un leader dei mari. La statua è realizzata con maestria artigianale, evidenziando ogni minimo dettaglio del costume e dell\'espressione.', 663.6, 'artistiche2.png'),
(69, 19, 'Scultura di Davy Jones, Scultura dipinta a mano, Perla nera', 'La scultura di Davy Jones è un\'opera d\'arte straordinaria che cattura l\'aspetto inquietante di questo mitico capitano dei mari. La statua è ricca di dettagli che portano alla vita il carattere di Davy Jones. Raffigurato con un volto dalle fattezze inumane, con lunghe tentacoli di polpo al posto della barba.', 28.5, 'artistiche3.png'),
(70, 19, 'Nave fatta a mano con Perla Nera - Jack Sparrow Pirati dei Caraibi', 'Questa scultura artigianale è una riproduzione dettagliata di una nave a vela, ispirata al personaggio di Jack Sparrow dalla saga cinematografica \"Pirati dei Caraibi\". Realizzata a mano con cura artigianale, la nave è un modello che cattura l\'essenza avventurosa e romantica dei mari dei Caraibi.', 975.7, 'artistiche4.png'),
(71, 20, 'Il Re Pirata \"Edward Reigns\"', 'Concediti il fascino dell\'età d\'oro della pirateria con \"Edward Reigns\" e lascia che lo spirito di Barbanera regni su ciò che ti circonda. Questo dipinto immortala l\'eredità del pirata più temuto che abbia mai navigato in alto mare.\"', 18.8, 'artistiche5.png'),
(72, 20, 'Arte della parete su tela della nave', 'Rappresenta un\'incantevole nave pirata in mezzo al mare. La scena è resa con dettagli vividi e colori accattivanti, perfetti per arricchire e decorare gli interni di uno spazio moderno. La nave pirata è il fulcro della composizione. ', 50.0, 'artistiche6.png'),
(73, 20, 'Arte della parete della nave pirata', 'Ti presentiamo la nostra accattivante stampa su tela con nave pirata, uno straordinario pezzo d\'arte che ti trasporterà nel mondo dei viaggi leggendari. Raffigura una nave pirata riccamente dettagliata, creando un senso di avventura e mistero.', 60.7, 'artistiche7.png'),
(74, 20, 'NAVE, pittura su tela per barche a vela', 'Questa pittura su tela è perfetta come decorazione per gli amanti del mare e delle imbarcazioni. È ideale per arricchire la decorazione di una casa, di un ufficio o di qualsiasi spazio dove si desideri evocare un senso di avventura e di viaggio.', 60.7, 'artistiche8.png'),
(75, 21, 'Vecchia mappa pirata Junk Journal Kit', 'Salpa per un viaggio di creatività! Lasciati trasportare dalle onde nostalgiche, dove ogni pezzo è un tesoro in attesa di essere scoperto.', 4.1, 'artistiche9.png'),
(76, 21, 'Mappe del tesoro antiche, documento digitale', 'Questa foto cattura l\'atmosfera di avventura e mistero con una composizione che combina mappe del tesoro antiche e documenti digitali. ', 2.4, 'artistiche10.png'),
(77, 21, 'Capitano Jack Sparrow - Pirati dei Caraibi', 'Questa foto cattura l\'iconico Capitano Jack Sparrow. La figura è ritratta in modo caratteristico, con la sua espressione audace e maliziosa.', 3.6, 'artistiche11.png'),
(78, 21, 'Kit di Scrapbooking, mappa del tesoro', 'Comprende una varietà di materiali e accessori che richiamano l\'atmosfera avventurosa e misteriosa delle mappe dei pirati.', 7.3, 'artistiche12.png'),
(79, 22, 'Collana con Teschio Pirata Vichingo', 'La collana con teschio gotico presenta la testa del teschio pirata vichingo con spade incrociate, con un\'incisione riccamente dettagliata per un tocco realistico. Il teschio scheletro gotico è un modello magico. Questo ciondolo può portare fortuna a chi lo indossa.', 18.0, 'gioielli1.png'),
(80, 22, 'Collana in argento 925 con testa di Teschio Pirata', 'Questa collana presenta un pendente unico e suggestivo che cattura l\'essenza avventurosa dei pirati. Composto da una testa di teschio pirata, simbolo di coraggio e intraprendenza, decorata con dettagli intricati che conferiscono un aspetto autentico e suggestivo.', 74.3, 'gioielli2.png'),
(81, 22, 'Collana con Moneta in Ottone Pirata dei Caraibi', 'Questa collana presenta una moneta in ottone ispirata al tema dei Pirati dei Caraibi, perfetta per gli amanti delle avventure marittime e delle storie dei pirati. La moneta è decorata con dettagli incisi che richiamano il fascino dei tesori nascosti e delle leggende dei mari.', 19.1, 'gioielli3.png'),
(82, 22, 'Collana Jolly Roger, Memento Mori', 'Splendido ciondolo con teschio con ossa incrociate realizzato in argento sterling massiccio.\r\nAbbiamo voluto rendere omaggio alle più antiche leggende dei pirati, dove cominciò a chiamarsi Jolly Roger.\r\nAbbiamo curato l\'anatomia e tutti i dettagli delle ossa e del cranio umano.', 168.8, 'gioielli4.png'),
(83, 23, 'Bracciale bottino di Pirata - Marrone', 'Ottieni la tua ultima dose di pirateria rock n roll con il nostro nuovo braccialetto Pirate\'s Booty!\r\nAbbiamo progettato queste piccole bellezze per avere la giusta quantità di attitudine piratesca per completare il tuo look pirata rock n roll.', 41.7, 'gioielli5.png'),
(84, 23, 'Braccialetto Anime Rufy di One Piece', 'Intraprendi un viaggio emozionante con il nostro braccialetto pirata Anime One Piece. Questo pezzo squisito presenta un\'accattivante bambola d\'azione dei cartoni animati di Rufy, adornata con il suo iconico Cappello di paglia. ', 11.9, 'gioielli6.png'),
(85, 23, 'Bracciale Pirati, \"Yo ho, yo ho\"', 'Questo bracciale pirata è un accessorio incantevole, ideale per gli amanti delle storie dei pirati. Il bracciale è decorato con una citazione iconica: \"Yo ho, yo ho\", che evoca il fascino e la misteriosa atmosfera dei mari infestati dai pirati.', 10.7, 'gioielli7.png'),
(86, 23, 'Bracciale Teschio in Argento 925', 'Questo bracciale è un\'elegante e audace dichiarazione di stile, caratterizzato da un pendente a forma di teschio. Il teschio è un simbolo iconico associato a coraggio, avventura e mistero, conferendo al bracciale un aspetto audace e suggestivo.', 25.9, 'gioielli8.png'),
(87, 24, 'Orecchini Pirata', 'Gli orecchini pirata sono un\'affascinante dichiarazione di stile ispirata all\'avventura dei mari e alla leggenda dei pirati. Questi orecchini sono progettati per catturare l\'immaginazione e trasmettere un senso di mistero e coraggio.', 10.0, 'gioielli9.png'),
(88, 24, 'Orecchini Spade Pirata', 'Gli orecchini spade pirata sono un accessorio unico e affascinante che evoca l\'essenza avventurosa e misteriosa dei pirati dei mari. Questi orecchini sono progettati per catturare l\'immaginazione e aggiungere un tocco di originalità al tuo look.', 69.0, 'gioielli10.png'),
(89, 24, 'Orecchini Teschio', 'Gli orecchini a cerchio incernierati con pendenti a forma di teschi pirata sono un accessorio audace che evoca il fascino misterioso dei pirati dei mari. Questi orecchini sono progettati per aggiungere un tocco di avventura al tuo stile.', 20.0, 'gioielli11.png'),
(90, 24, 'Orecchini del Cranio', 'Questi orecchini sono un\'aggiunta intrigante al tuo look, ispirati al fascino misterioso dei pirati. Sono perfetti per chi ama l\'estetica marinaresca e desidera esprimere uno spirito avventuroso.', 24.0, 'gioielli12.png');

-- --------------------------------------------------------

--
-- Struttura della tabella `profili`
--

CREATE TABLE `profili` (
  `id` int(11) NOT NULL,
  `nome` varchar(30) NOT NULL,
  `cognome` varchar(30) NOT NULL,
  `genere` varchar(10) NOT NULL,
  `data_di_nascita` date NOT NULL,
  `indirizzo_residenza` varchar(50) NOT NULL,
  `telefono` varchar(13) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `profili`
--

INSERT INTO `profili` (`id`, `nome`, `cognome`, `genere`, `data_di_nascita`, `indirizzo_residenza`, `telefono`) VALUES
(22, 'Froylan', 'Lamus', 'maschio', '2001-07-15', 'Via Don Bosco 40', '3518571219'),
(23, 'Elisabetta', 'Palumbo', 'maschio', '2001-11-11', 'Via Europa 11', '3828431923'),
(24, 'Alessandro', 'Catapano', 'maschio', '2000-11-11', 'Via Norcia, 30', '3292394032'),
(25, 'Patrizia', 'Solla', 'femmina', '2001-11-11', 'Via America, 12', '3483402934'),
(26, 'Noemi', 'Misurelli', 'femmina', '1994-05-19', 'Via del Redentore, 20', '3401293032'),
(27, 'Simone ', 'Cantella', 'altro', '2001-11-11', 'Via Vomero 45', '3493291023');

-- --------------------------------------------------------

--
-- Struttura della tabella `sottocategorie`
--

CREATE TABLE `sottocategorie` (
  `id` int(11) NOT NULL,
  `id_categoria` int(11) NOT NULL,
  `nome` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `sottocategorie`
--

INSERT INTO `sottocategorie` (`id`, `id_categoria`, `nome`) VALUES
(1, 1, 'Uomo'),
(2, 1, 'Donna'),
(3, 1, 'Bambino'),
(4, 2, 'Cavatappi'),
(5, 2, 'Portachiavi'),
(9, 2, 'Agende'),
(10, 7, 'Manga'),
(11, 7, 'Romanzi'),
(12, 7, 'Fumetti'),
(13, 3, 'Giochi da tavolo'),
(14, 3, 'Giocattoli'),
(15, 3, 'Costruzioni'),
(16, 6, 'Film'),
(17, 6, 'Videogiochi'),
(18, 6, 'Musica'),
(19, 5, 'Sculture'),
(20, 5, 'Quadri'),
(21, 5, 'Foto'),
(22, 4, 'Collane'),
(23, 4, 'Bracciali'),
(24, 4, 'Orecchini');

-- --------------------------------------------------------

--
-- Struttura della tabella `utenti`
--

CREATE TABLE `utenti` (
  `id` int(11) NOT NULL,
  `id_profilo` int(11) DEFAULT NULL,
  `username` varchar(30) NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` varchar(30) NOT NULL,
  `avatar` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `utenti`
--

INSERT INTO `utenti` (`id`, `id_profilo`, `username`, `email`, `password`, `avatar`) VALUES
(21, 22, 'Difroy', 'unifroy@gmail.com', 'Progetto1!', 'avatar4.jpg'),
(22, 23, 'Sephisa', 'elisabettapalumbo@gmail.com', 'Bella1!', 'avatar3.jpg'),
(23, 24, 'Anguriafresca', 'alessandrocatapano@gmail.com', 'Bello1!', 'avatar4.jpg'),
(24, 25, 'Meikura', 'patriziasolla@gmail.com', 'Bello1!', 'avatar1.jpg'),
(25, 26, 'Noeh', 'noe@gmail.com', 'Bello1!', 'avatar3.jpg'),
(26, 27, 'Tora', 'simonecantella@gmail.com', 'Bello1!', 'avatar2.jpg');

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `acquisti`
--
ALTER TABLE `acquisti`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_utente` (`id_utente`);

--
-- Indici per le tabelle `categorie`
--
ALTER TABLE `categorie`
  ADD PRIMARY KEY (`id`);

--
-- Indici per le tabelle `ordini`
--
ALTER TABLE `ordini`
  ADD KEY `id_prodotto` (`id_prodotto`),
  ADD KEY `id_acquisto` (`id_acquisto`);

--
-- Indici per le tabelle `prodotti`
--
ALTER TABLE `prodotti`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_sottocategoria` (`id_sottocategoria`);

--
-- Indici per le tabelle `profili`
--
ALTER TABLE `profili`
  ADD PRIMARY KEY (`id`);

--
-- Indici per le tabelle `sottocategorie`
--
ALTER TABLE `sottocategorie`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_categoria` (`id_categoria`);

--
-- Indici per le tabelle `utenti`
--
ALTER TABLE `utenti`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_profilo` (`id_profilo`);

--
-- AUTO_INCREMENT per le tabelle scaricate
--

--
-- AUTO_INCREMENT per la tabella `acquisti`
--
ALTER TABLE `acquisti`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- AUTO_INCREMENT per la tabella `categorie`
--
ALTER TABLE `categorie`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT per la tabella `prodotti`
--
ALTER TABLE `prodotti`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=91;

--
-- AUTO_INCREMENT per la tabella `profili`
--
ALTER TABLE `profili`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- AUTO_INCREMENT per la tabella `sottocategorie`
--
ALTER TABLE `sottocategorie`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- AUTO_INCREMENT per la tabella `utenti`
--
ALTER TABLE `utenti`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- Limiti per le tabelle scaricate
--

--
-- Limiti per la tabella `acquisti`
--
ALTER TABLE `acquisti`
  ADD CONSTRAINT `id_utente` FOREIGN KEY (`id_utente`) REFERENCES `utenti` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limiti per la tabella `ordini`
--
ALTER TABLE `ordini`
  ADD CONSTRAINT `id_acquisto` FOREIGN KEY (`id_acquisto`) REFERENCES `acquisti` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `id_prodotto` FOREIGN KEY (`id_prodotto`) REFERENCES `prodotti` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limiti per la tabella `prodotti`
--
ALTER TABLE `prodotti`
  ADD CONSTRAINT `id_sottocategoria` FOREIGN KEY (`id_sottocategoria`) REFERENCES `sottocategorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limiti per la tabella `sottocategorie`
--
ALTER TABLE `sottocategorie`
  ADD CONSTRAINT `id_categoria` FOREIGN KEY (`id_categoria`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limiti per la tabella `utenti`
--
ALTER TABLE `utenti`
  ADD CONSTRAINT `id_profilo` FOREIGN KEY (`id_profilo`) REFERENCES `profili` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
