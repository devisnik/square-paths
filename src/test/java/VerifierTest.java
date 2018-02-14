import org.junit.Test;

import static org.junit.Assert.*;

public class VerifierTest {

    @Test
    public void verifiedNonHamiltonianPath() {
        Verifier verifier = new Verifier(1, 2, 3, 4);

        assertFalse(verifier.isHamiltonianPath(4));
    }

    @Test
    public void verifiesPathInSolution15() {
        Verifier verifier = new Verifier(9, 7, 2, 14, 11, 5, 4, 12, 13, 3, 6, 10, 15, 1, 8);

        assertTrue(verifier.isHamiltonianPath(15));
    }

    @Test
    public void verifiesNoCycleInSolution15() {
        Verifier verifier = new Verifier(9, 7, 2, 14, 11, 5, 4, 12, 13, 3, 6, 10, 15, 1, 8);

        assertFalse(verifier.isHamiltonianCycle(15));
    }

    @Test
    public void verifiesCycleInSolution83() {
        Verifier verifier = new Verifier(
                50, 14, 2, 7, 9, 16, 20, 5, 4, 12, 13, 3, 1, 8, 17, 19, 6, 10, 15, 21, 28, 72,
                49, 32, 68, 53, 11, 70, 51, 30, 34, 47, 74, 26, 55, 66, 78, 22, 27, 37, 44,
                56, 25, 39, 42, 79, 65, 35, 29, 52, 69, 75, 46, 54, 67, 77, 23, 58, 63, 81,
                40, 60, 61, 83, 38, 43, 57, 24, 76, 45, 36, 64, 80, 41, 59, 62, 82, 18, 31,
                33, 48, 73, 71);

        assertTrue(verifier.isHamiltonianCycle(83));
    }

    @Test
    public void verifiesCycleInSolution86() {
        Verifier verifier = new Verifier(
                9, 16, 20, 5, 4, 12, 13, 3, 1, 8, 17, 19, 6, 10, 15, 21,
                28, 36, 45, 55, 26, 74, 47, 53, 11, 70, 51, 30, 34, 66, 78, 22, 27, 37, 44,
                56, 25, 39, 42, 79, 65, 35, 86, 83, 61, 60, 84, 85, 59, 41, 80, 64, 57, 43,
                38, 62, 82, 18, 7, 2, 14, 50, 31, 33, 48, 73, 71, 29, 52, 69, 75, 46, 54,
                67, 77, 23, 58, 63, 81, 40, 24, 76, 68, 32, 49, 72);

        assertTrue(verifier.isHamiltonianCycle(86));
    }

    @Test
    public void verifiesCycleIn34() {
        Verifier verifier = new Verifier(34, 30, 6, 19, 17, 32, 4, 21, 28, 8, 1, 3, 13,
                12, 24, 25, 11, 5, 20, 29, 7, 18, 31, 33, 16, 9, 27, 22, 14, 2, 23, 26, 10, 15);

        assertTrue(verifier.isHamiltonianCycle(34));
    }

    @Test
    public void verifyWrongCycleIn67() {
        Verifier verifier = new Verifier(
                1, 3, 6, 10, 15, 21, 4, 5, 11, 14, 50, 31, 18, 7, 2, 23, 26, 38, 43, 57, 64, 17,
                32, 49, 51, 30, 19, 62, 59, 22, 42, 58, 63, 37, 44, 20, 29, 52, 27, 9, 16, 48, 33, 67,
                54, 46, 35, 65, 56, 25, 39, 61, 60, 40, 41, 8, 28, 53, 47, 34, 66, 55, 45, 36, 13, 12, 24);

        assertFalse(verifier.isHamiltonianCycle(67));
    }

    @Test
    public void verifyCycle121() {
        Verifier verifier = new Verifier(37, 107, 118, 78, 91, 105, 120, 76, 93, 103, 66, 55, 114, 111,
                85, 84, 112, 113, 83, 86, 110, 115, 81, 88, 108, 117, 79, 90, 106, 119, 77, 92, 104, 121, 75, 94,
                102, 67, 54, 46, 98, 71, 73, 96, 100, 69, 52, 48, 33, 31, 50, 14, 35, 109, 116, 80, 89, 32, 68,
                101, 95, 74, 70, 99, 97, 72, 49, 51, 30, 34, 87, 82, 62, 59, 41, 40, 60, 61, 39, 42, 58, 63, 18,
                7, 29, 20, 44, 56, 65, 16, 9, 27, 22, 3, 13, 36, 45, 19, 6, 10, 15, 21, 28, 53, 47, 2, 23, 26, 38,
                43, 57, 64, 17, 8, 1, 24, 25, 11, 5, 4, 12);

        assertTrue(verifier.isHamiltonianCycle(121));
    }

    @Test
    public void verifyPath2500() {

        // found at http://community.wolfram.com/groups/-/m/t/1264240
        Verifier verifier = new Verifier(64, 1700, 416, 1985, 1984, 41, 1115, 1001, 295, 434, 7, 1437,
                1372, 1229, 535, 2066, 2423, 941, 1175, 1850, 2375, 26, 2183, 1181, 2300, 1544, 1057, 1152, 369,
                1000, 2364, 1861, 164, 32, 2468, 448, 1953, 963, 1537, 1944, 865, 1071, 1138, 383, 101, 1663, 1253,
                2111, 2245, 780, 1720, 1089, 1512, 252, 837, 927, 1474, 2495, 1994, 710, 251, 1958, 158, 131, 598,
                1518, 1731, 1294, 822, 403, 2406, 1315, 1821, 2023, 1002, 87, 1069, 2180, 2444, 1912, 1452, 852,
                1957, 2012, 1588, 261, 964, 1245, 1156, 2208, 708, 192, 484, 1541, 1484, 365, 1939, 177, 912,
                1204, 732, 229, 2372, 1349, 2015, 194, 247, 1962, 1759, 741, 2284, 2477, 659, 241, 1875, 934,
                1275, 1126, 1374, 930, 1879, 425, 1691, 2030, 2459, 1262, 854, 46, 2258, 767, 2482, 327, 114,
                1111, 1593, 1432, 1932, 568, 2033, 2456, 908, 1396, 1968, 532, 309, 1540, 1824, 1312, 209, 691,
                38, 1406, 1403, 622, 54, 787, 657, 432, 1969, 531, 1318, 1491, 2230, 686, 2450, 1775, 725, 1124,
                2240, 569, 331, 1433, 167, 562, 1287, 922, 1782, 718, 438, 1083, 681, 1528, 2316, 1909, 692, 37,
                1188, 493, 407, 269, 307, 1137, 1888, 612, 1413, 2431, 594, 631, 153, 2248, 456, 273, 511, 18, 607,
                993, 771, 2365, 1479, 546, 975, 874, 495, 405, 1996, 2229, 372, 1392, 129, 15, 1921, 1215, 1701,
                2395, 2366, 1859, 1390, 1110, 2490, 1231, 1794, 1927, 1673, 1808, 1441, 159, 370, 926, 1475, 374,
                1562, 2282, 1814, 995, 2369, 2392, 1833, 2011, 2214, 2410, 1311, 1938, 2158, 2067, 237, 439, 402,
                2407, 1949, 1532, 2068, 236, 2165, 1435, 165, 2044, 981, 1723, 2246, 2243, 1238, 1571, 2029, 572,
                949, 1967, 337, 1779, 925, 2324, 1520, 1505, 2216, 1148, 373, 1308, 1293, 823, 266, 695, 601, 1608,
                328, 348, 1956, 1408, 113, 976, 48, 1473, 1552, 564, 2037, 2452, 1517, 599, 130, 1986, 2239, 2385,
                2376, 433, 1331, 2269, 35, 1486, 915, 2221, 1748, 752, 544, 545, 1304, 2060, 1421, 23, 461, 983, 106,
                2010, 2479, 1365, 1551, 1698, 2271, 2218, 1878, 1722, 582, 259, 1341, 868, 1632, 672, 2137, 264, 1417,
                792, 2233, 1863, 1386, 2335, 1265, 1136, 2345, 571, 5, 1931, 1790, 1019, 277, 747, 1278, 322, 207,
                154, 2447, 2314, 1911, 793, 503, 653, 188, 1837, 764, 1637, 2207, 394, 762, 199, 1650, 2071, 2154,
                447, 577, 323, 1198, 566, 523, 921, 375, 2226, 2398, 1827, 877, 2487, 217, 1079, 770, 1934, 1547,
                478, 1203, 646, 1658, 278, 2222, 379, 21, 2283, 853, 996, 2140, 1109, 1492, 1008, 841, 1760, 1604,
                512, 857, 1952, 2404, 845, 755, 2270, 1955, 1070, 2294, 410, 1271, 2210, 391, 50, 2159, 442, 714,
                310, 590, 1010, 359, 2, 2114, 1250, 2350, 1619, 1745, 1280, 1321, 888, 408, 1192, 2289, 415, 954,
                271, 1754, 2090, 119, 1325, 275, 1661, 20, 605, 839, 2186, 518, 382, 2219, 1877, 1259, 1142, 1358,
                1558, 651, 25, 2475, 2149, 155, 1870, 66, 1303, 633, 1576, 2024, 1697, 67, 2237, 1988, 1612, 2484,
                2416, 1553, 751, 2498, 1598, 803, 286, 2315, 494, 1810, 2415, 610, 1599, 517, 59, 85, 356, 2045,
                2311, 90, 586, 1815, 786, 55, 141, 1975, 1506, 1630, 219, 357, 1407, 802, 287, 1157, 364, 660, 240,
                2161, 2463, 1258, 591, 634, 1130, 1174, 851, 173, 2228, 581, 1628, 773, 991, 2373, 1983, 1617, 1747,
                1853, 451, 1149, 1987, 929, 160, 864, 1737, 2359, 1997, 604, 485, 299, 1817, 1099, 1502, 347, 1678,
                1803, 1113, 256, 2244, 1356, 1560, 1465, 1451, 70, 2331, 1513, 791, 730, 111, 1114, 42, 2262, 1338,
                1366, 843, 1758, 1963, 1401, 1735, 1074, 1135, 1890, 1831, 2138, 1226, 890, 1610, 1199, 1402, 807,
                1693, 71, 713, 1591, 1218, 2263, 1706, 143, 1301, 220, 1716, 784, 816, 705, 319, 1050, 1654, 947,
                2302, 834, 462, 2139, 997, 27, 117, 367, 2337, 1144, 152, 332, 2168, 1928, 2428, 2061, 2295, 1305,
                999, 157, 1692, 1117, 1092, 933, 1276, 1028, 341, 1423, 1826, 2143, 1106, 2494, 6, 1438, 162, 1687,
                522, 1159, 2322, 1042, 183, 2418, 946, 654, 2371, 1854, 1746, 103, 1578, 538, 1671, 10, 134, 2170,
                39, 250, 191, 1178, 1631, 578, 1726, 2370, 1855, 1866, 1978, 1622, 2347, 2142, 883, 1718, 782, 1819,
                1781, 2188, 621, 1228, 2136, 673, 1352, 1249, 1055, 1649, 115, 1041, 1075, 1326, 118, 3, 61, 2055,
                649, 720, 724, 1580, 1784, 2312, 2177, 127, 1989, 1036, 1080, 1420, 884, 412, 2189, 727, 498, 1711,
                1314, 1935, 1546, 2175, 2050, 351, 1018, 1482, 1999, 210, 1015, 1289, 1736, 1400, 1849, 1872, 1972,
                1053, 468, 901, 2348, 1252, 429, 796, 1508, 1973, 2383, 1586, 2135, 1961, 1064, 1240, 281, 344,
                1865, 536, 2489, 992, 377, 464, 625, 51, 1549, 1367, 1234, 1902, 1462, 1563, 1246, 779, 985, 384,
                1825, 879, 1522, 414, 2290, 959, 805, 716, 509, 647, 1034, 1567, 549, 1951, 2018, 1118, 1907, 1009,
                1295, 821, 404, 1445, 2399, 1570, 639, 450, 334, 1035, 1081, 1223, 298, 2303, 833, 848, 176, 1345,
                1155, 2326, 810, 1894, 315, 1449, 667, 629, 596, 80, 2224, 2265, 1456, 1680, 1569, 2400, 849, 2176,
                740, 1196, 920, 524, 205, 819, 781, 1523, 977, 1424, 1177, 2187, 1062, 459, 1566, 550, 179, 1670,
                1139, 305, 1216, 1284, 2437, 812, 709, 1995, 1369, 231, 1533, 492, 2109, 1027, 909, 2227, 174, 1762,
                1959, 541, 1763, 262, 1587, 2134, 366, 1843, 1182, 1954, 1646, 1163, 953, 811, 870, 1834, 1302, 2419,
                1425, 1384, 1320, 1929, 880, 1721, 2123, 86, 643, 33, 31, 1058, 542, 482, 479, 746, 623, 2293, 308,
                92, 584, 712, 1404, 2317, 387, 574, 326, 1355, 670, 555, 889, 2247, 253, 2451, 1393, 632, 1049, 2200,
                1769, 935, 1466, 1343, 421, 875, 1334, 1915, 486, 43, 798, 2338, 63, 1786, 1463, 1241, 1360, 576, 385,
                2424, 1801, 1920, 2049, 760, 465, 904, 1905, 1459, 222, 1147, 149, 1076, 293, 2308, 828, 1573, 452,
                2048, 1201, 563, 593, 83, 317, 644, 1205, 1004, 1397, 719, 1217, 808, 2441, 368, 1841, 968, 1633,
                1848, 1, 120, 76, 285, 1084, 597, 2107, 1029, 1572, 1564, 1685, 1340, 104, 1660, 2436, 589, 707, 449,
                2152, 2472, 1884, 1597, 1652, 1829, 2396, 2093, 1876, 60, 669, 2467, 2022, 1699, 2145, 1336, 345, 616,
                9, 280, 1656, 2313, 88, 1761, 1048, 1868, 836, 2080, 1764, 1717, 1419, 1606, 330, 1519, 506, 938, 2198,
                1166, 1750, 750, 339, 817, 1032, 2217, 1383, 1981, 1268, 757, 2379, 1846, 458, 698, 527, 994, 855,
                1354, 246, 2355, 561, 1464, 937, 2199, 1282, 1119, 2130, 1006, 1395, 814, 1686, 2035, 2454, 2307,
                942, 1362, 238, 662, 1274, 22, 122, 202, 1319, 1082, 2054, 2171, 230, 2474, 1882, 1143, 301, 723,
                1581, 2019, 1230, 2251, 1974, 2382, 427, 302, 1634, 215, 514, 1511, 1738, 2106, 198, 243, 2257, 144,
                1792, 324, 765, 135, 121, 1904, 1121, 248, 193, 831, 850, 671, 170, 1946, 1898, 806, 1694, 2402, 98,
                386, 1378, 1647, 1489, 815, 1889, 1832, 17, 2099, 1150, 1059, 2077, 1892, 917, 1684, 620, 469, 260,
                896, 473, 203, 2006, 1838, 11, 1145, 151, 1370, 2351, 898, 1806, 1003, 1206, 1098, 58, 2343, 1626,
                490, 1359, 2485, 1611, 505, 2096, 1504, 521, 1783, 618, 1498, 1418, 2426, 175, 1346, 2254, 1842,
                658, 2046, 163, 93, 268, 1176, 1033, 2103, 1497, 1867, 69, 12, 2104, 2121, 480, 1545, 1704, 1212,
                1924, 477, 1732, 869, 1940, 2285, 19, 125, 44, 1556, 560, 2465, 899, 1601, 335, 565, 731, 1385,
                1979, 2117, 1247, 689, 911, 178, 398, 2411, 1310, 290, 1919, 197, 1739, 1286, 739, 1862, 842, 1559,
                466, 2238, 1243, 2357, 244, 1277, 2323, 2301, 948, 1077, 2172, 1672, 353, 223, 2481, 655, 1194, 1615,
                234, 2367, 1477, 548, 1052, 2197, 939, 910, 1899, 2457, 2443, 2181, 1068, 1333, 783, 1426, 2174, 962,
                1154, 446, 515, 1789, 1347, 769, 1167, 2433, 376, 108, 292, 797, 499, 2102, 2387, 14, 2486, 1235,
                1681, 1344, 1257, 187, 969, 2056, 1193, 488, 956, 2069, 2027, 1337, 1799, 1450, 314, 2087, 829,
                1980, 1501, 1635, 1614, 150, 579, 2125, 1844, 557, 467, 2449, 687, 682, 218, 1382, 1322, 2278, 2483,
                2417, 392, 697, 903, 1213, 1923, 2173, 228, 2476, 1005, 595, 2321, 928, 1281, 2083, 126, 774, 1930,
                1914, 895, 2021, 1823, 1202, 1102, 342, 2362, 663, 2473, 1371, 745, 699, 2005, 204, 1645, 1380, 2220,
                1749, 2095, 1874, 1490, 110, 790, 2126, 683, 838, 123, 1173, 1531, 318, 978, 958, 642, 1662, 2059,
                2166, 2190, 619, 902, 1499, 1526, 1283, 742, 483, 2017, 2339, 1261, 1655, 1945, 2280, 529, 840, 2185,
                1659, 645, 84, 1941, 1780, 245, 2356, 2133, 892, 1917, 2052, 2304, 945, 2191, 1653, 28, 756, 1744,
                1856, 2500, 749, 2276, 1568, 1796, 1013, 1012, 588, 1813, 212, 1232, 1577, 2267, 2089, 2007, 1714,
                311, 914, 47, 34, 1730, 1186, 2063, 1906, 2319, 2305, 1416, 1609, 507, 789, 2460, 1021, 743, 1858,
                1742, 1507, 2462, 2438, 1918, 291, 2110, 1734, 2235, 265, 635, 2390, 1835, 665, 1936, 2160, 1561,
                1248, 1777, 824, 1880, 1964, 2132, 1589, 2380, 984, 1225, 711, 189, 2115, 1485, 36, 1900, 1016, 748,
                1101, 1708, 1773, 1948, 861, 1255, 1770, 534, 2491, 873, 1063, 381, 580, 2445, 471, 1129, 1272, 2209,
                1887, 417, 424, 1097, 128, 16, 2009, 2480, 224, 401, 1363, 1038, 1666, 2430, 2470, 1886, 715, 1785,
                519, 637, 2499, 1470, 211, 1725, 300, 184, 216, 73, 288, 2212, 813, 1891, 1134, 982, 867, 733, 2076,
                1060, 1440, 1264, 257, 227, 998, 766, 258, 2242, 674, 1535, 2309, 940, 1869, 1852, 648, 721, 960, 640,
                2169, 1431, 685, 611, 1990, 510, 2299, 1926, 283, 678, 1822, 882, 2034, 1447, 1469, 2131, 573, 388,
                2421, 1548, 2296, 1800, 49, 735, 289, 72, 1153, 1448, 1916, 109, 1740, 1860, 1056, 2425, 1296, 1105,
                1811, 893, 196, 380, 2120, 1976, 1388, 916, 453, 703, 1061, 1643, 2201, 1768, 1481, 2000, 1600, 2496,
                313, 1131, 390, 1291, 2073, 1896, 1468, 2013, 1123, 1478, 2003, 497, 728, 1208, 1496, 1529, 775, 186,
                1335, 346, 615, 2194, 1170, 1966, 1755, 1845, 859, 1641, 2328, 1897, 1128, 988, 2493, 1476, 1125, 475,
                614, 1067, 533, 2492, 2408, 1073, 776, 1625, 1184, 2297, 2327, 2162, 1087, 2394, 1702, 1107, 2374,
                2250, 559, 666, 778, 986, 2150, 1214, 1922, 1327, 1377, 1539, 1165, 1436, 965, 1151, 2098, 2127, 1594,
                906, 1030, 491, 350, 2051, 1793, 1688, 2281, 2075, 1525, 239, 722, 1394, 1970, 2386, 1583, 1442, 2279,
                970, 1530, 679, 617, 112, 2388, 1093, 1211, 2038, 1443, 2401, 1695, 1554, 1582, 182, 974, 1427, 1937,
                1088, 208, 81, 2320, 2036, 1100, 1925, 676, 1260, 504, 1096, 200, 124, 1557, 943, 2193, 1651, 2070,
                1179, 502, 1434, 1375, 2346, 255, 145, 1224, 1585, 624, 400, 1809, 2287, 213, 316, 980, 1621, 2100,
                1381, 923, 233, 2368, 1353, 168, 1596, 1429, 1707, 694, 675, 846, 754, 1550, 214, 1467, 297, 2203,
                2286, 1078, 147, 78, 1771, 1254, 955, 894, 1222, 378, 463, 2241, 360, 540, 1669, 267, 1942, 362, 263,
                2041, 2184, 1180, 1524, 501, 460, 1140, 1461, 1788, 516, 2085, 1515, 1510, 990, 2259, 1710, 406, 2298,
                1798, 138, 487, 2429, 1415, 2306, 2318, 1046, 1454, 146, 2354, 1871, 1729, 296, 860, 1444, 2156, 445,
                180, 181, 395, 2206, 195, 1741, 1623, 1977, 1992, 2497, 419, 422, 2078, 626, 818, 1991, 1373, 652, 2157,
                759, 1266, 2334, 2427, 1054, 627, 2182, 1299, 2422, 282, 1399, 2082, 2274, 226, 863, 161, 8, 2393, 971,
                1733, 1292, 4, 1221, 75, 1950, 966, 1534, 2435, 481, 608, 761, 2155, 2469, 1627, 2094, 2002, 702, 454,
                1146, 79, 2225, 1256, 2108, 1141, 2223, 913, 1112, 1913, 688, 1713, 1536, 768, 132, 1389, 2332, 804,
                1405, 2439, 1657, 944, 820, 2205, 1044, 1765, 444, 340, 684, 2020, 1116, 40, 156, 2148, 556, 2360, 140,
                1085, 1316, 800, 2336, 2288, 961, 1743, 1857, 847, 753, 543, 2058, 1191, 1410, 190, 539, 2062, 1538,
                1943, 866, 430, 1595, 169, 2232, 2124, 1357, 1244, 1565, 284, 872, 2264, 440, 1676, 1133, 1171, 2310,
                1411, 1190, 254, 530, 431, 2273, 2488, 2001, 303, 1066, 1638, 862, 99, 1270, 2211, 2014, 1122, 2478,
                1618, 1982, 827, 1774, 1947, 2409, 1816, 1665, 1039, 2442, 1527, 777, 592, 249, 1960, 641, 1040, 1361,
                1555, 2414, 1682, 82, 1007, 1802, 2042, 1679, 1457, 1043, 1873, 936, 1368, 2353, 1011, 1014, 2122,
                1242, 967, 2397, 1324, 885, 1051, 1158, 1342, 1683, 1233, 1903, 801, 2448, 1908, 693, 1807, 1329, 352,
                1584, 1120, 1689, 1227, 1273, 171, 1350, 1675, 1574, 2147, 989, 2260, 1709, 1772, 77, 2039, 1805, 1795,
                321, 1279, 1025, 1376, 2105, 1864, 2361, 2128, 788, 508, 1893, 1828, 2016, 585, 2440, 1160, 1756, 1493,
                443, 2261, 1460, 304, 785, 2464, 900, 325, 636, 1668, 2053, 1791, 1690, 1910, 1339, 1797, 2047, 2178,
                423, 1881, 2215, 701, 668, 1933, 276, 2028, 472, 312, 1288, 1521, 979, 1830, 1086, 139, 437, 2164,
                2192, 409, 887, 1514, 2086, 2403, 97, 2112, 1024, 2340, 1885, 2471, 2153, 2072, 1409, 1616, 500, 656,
                1648, 116, 2384, 1712, 1313, 1391, 2453, 148, 876, 1624, 680, 1169, 56, 905, 2231, 794, 2455, 354,
                1090, 1719, 45, 279, 397, 2412, 613, 2091, 825, 856, 744, 552, 1752, 952, 729, 1480, 1020, 2116, 1605,
                1644, 2325, 2031, 570, 799, 1602, 2119, 690, 606, 763, 758, 1091, 65, 835, 1766, 734, 1667, 1037, 52,
                2064, 2032, 272, 1664, 185, 1751, 274, 951, 1965, 436, 1328, 881, 2255, 2101, 603, 1422, 1603, 333,
                1971, 630, 1579, 270, 1330, 2151, 2074, 1290, 826, 470, 2234, 1487, 2113, 1023, 2341, 2420, 2204, 932,
                832, 537, 1767, 2202, 399, 897, 2352, 2272, 329, 1607, 1309, 1500, 2344, 57, 232, 924, 520, 1161, 2088,
                2268, 1453, 2391, 525, 844, 600, 1164, 772, 2253, 2236, 1364, 1237, 2363, 137, 704, 320, 2081, 1168,
                1332, 972, 2277, 1323, 441, 1495, 809, 1895, 221, 1804, 2292, 957, 2179, 737, 1379, 2342, 907, 2118,
                1851, 1398, 2446, 363, 726, 235, 1446, 2275, 225, 136, 89, 107, 1414, 987, 2377, 1104, 1297, 1728,
                1993, 1488, 628, 396, 133, 1236, 700, 1901, 1820, 2405, 95, 389, 1727, 1189, 411, 489, 736, 1200,
                1300, 1836, 973, 2163, 2461, 455, 29, 871, 1629, 1620, 2349, 355, 1494, 1210, 1094, 1715, 2129, 1592,
                2252, 664, 1017, 1483, 1542, 1162, 1239, 361, 2040, 1209, 1095, 349, 1251, 513, 1696, 1220, 2144, 457,
                1307, 62, 338, 1183, 1317, 1387, 2213, 1883, 53, 1172, 677, 1439, 242, 1127, 554, 1471, 738, 706, 1998,
                918, 931, 30, 294, 1306, 1503, 2097, 1267, 102, 94, 435, 2065, 2291, 1430, 91, 2025, 891, 553, 1472,
                2249, 1351, 1674, 1575, 1026, 343, 2466, 2434, 1047, 717, 2092, 2004, 1132, 1269, 100, 96, 1348, 1677,
                2167, 1197, 567, 2458, 1263, 418, 878, 886, 558, 2358, 2266, 1703, 413, 371, 2333, 1636, 1613, 68, 13,
                2196, 1285, 2079, 2146, 1103, 2378, 1847, 1753, 551, 1298, 638, 587, 142, 1458, 306, 919, 602, 74, 950,
                206, 2195, 830, 1195, 1509, 795, 105, 336, 393, 1207, 1818, 583, 201, 2008, 696, 1705, 1776, 528, 496,
                1185, 1840, 2256, 1108, 2141, 2084, 1516, 420, 2389, 1455, 1045, 476, 1640, 2329, 2432, 1412, 1724,
                1757, 547, 609, 1072, 1428, 172, 24, 1065, 1639, 2330, 2026, 575, 650, 1031, 1778, 526, 1590, 1219,
                2381, 428, 661, 1839, 1642, 474, 426, 358, 2043, 166, 858, 1543, 2057, 1787, 1022, 1187, 2413, 1812);


        assertTrue(verifier.isHamiltonianPath(2500));
        assertFalse(verifier.isHamiltonianCycle(2500));
    }
}