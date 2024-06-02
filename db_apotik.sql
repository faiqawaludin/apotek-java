-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 02 Jun 2024 pada 14.05
-- Versi server: 10.4.28-MariaDB
-- Versi PHP: 8.0.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_apotik`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `dataobat`
--

CREATE TABLE `dataobat` (
  `ID` varchar(50) NOT NULL,
  `NAMA` varchar(50) NOT NULL,
  `HARGA` decimal(65,0) NOT NULL,
  `TGL_EXP` date DEFAULT NULL,
  `STOCK` int(11) NOT NULL,
  `JENIS` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `dataobat`
--

INSERT INTO `dataobat` (`ID`, `NAMA`, `HARGA`, `TGL_EXP`, `STOCK`, `JENIS`) VALUES
('1001', 'paracetamol', 12000, '2024-06-06', 12, 'TABLET'),
('2003', 'panadol', 2000, '2024-06-11', 200, 'null');

-- --------------------------------------------------------

--
-- Struktur dari tabel `datapegawai`
--

CREATE TABLE `datapegawai` (
  `id` varchar(50) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `datapegawai`
--

INSERT INTO `datapegawai` (`id`, `nama`, `username`, `password`) VALUES
('ID001', 'Muhammad rRafi Ilmuna Ihsan', 'rafiilmuna99', '12345678');

-- --------------------------------------------------------

--
-- Struktur dari tabel `datapenjualan`
--

CREATE TABLE `datapenjualan` (
  `ID` varchar(50) NOT NULL,
  `NAMA` varchar(50) NOT NULL,
  `HARGA` decimal(65,0) NOT NULL,
  `JUMLAH` int(11) NOT NULL,
  `TOTAL` decimal(65,0) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `datapenjualan`
--

INSERT INTO `datapenjualan` (`ID`, `NAMA`, `HARGA`, `JUMLAH`, `TOTAL`) VALUES
('1001', 'paracetamol', 12000, 12, 144000),
('1001', 'paracetamol', 12000, 10, 120000),
('1001', 'paracetamol', 12000, 2, 24000),
('1001', 'paracetamol', 12000, 2, 24000),
('1001', 'paracetamol', 12000, 2, 24000),
('2003', 'panadol', 2000, 50, 100000);

--
-- Trigger `datapenjualan`
--
DELIMITER $$
CREATE TRIGGER `datakeluar` AFTER INSERT ON `datapenjualan` FOR EACH ROW BEGIN
UPDATE dataobat set STOCK = STOCK - NEW.JUMLAH
WHERE ID = NEW.ID;
END
$$
DELIMITER ;

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `dataobat`
--
ALTER TABLE `dataobat`
  ADD PRIMARY KEY (`ID`);

--
-- Indeks untuk tabel `datapegawai`
--
ALTER TABLE `datapegawai`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `datapenjualan`
--
ALTER TABLE `datapenjualan`
  ADD KEY `ID` (`ID`);

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `datapenjualan`
--
ALTER TABLE `datapenjualan`
  ADD CONSTRAINT `datapenjualan_ibfk_1` FOREIGN KEY (`ID`) REFERENCES `dataobat` (`ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
