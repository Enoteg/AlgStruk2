# Сравнение алгоритмов сортировки

| Размер массива | Алгоритм                | Время (мс) | Сравнения       | Перестановки      |
|----------------|-------------------------|------------|-----------------|-------------------|
| **100,000**    |                         |            |                 |                   |
|                | QuickSort (рекурсивный) | 13         | 1,502,466       | 358,005           |
|                | QuickSort (нерекурсив.) | 21         | 2,121,106       | 394,066           |
|                | MergeSort               | 23         | 1,536,304       | 1,668,928         |
|                | ShellSort (обычный)     | 14         | 4,401,001       | 2,951,381         |
|                | ShellSort (Кнут)        | 13         | 3,941,542       | 3,016,009         |
|                | ShellSort (Седжвик)     | 12         | 5,134,571       | 4,521,800         |
| **500,000**    |                         |            |                 |                   |
|                | QuickSort (рекурсивный) | 32         | 8,242,864       | 2,103,749         |
|                | QuickSort (нерекурсив.) | 43         | 11,789,288      | 2,356,757         |
|                | MergeSort               | 44         | 8,837,070       | 9,475,712         |
|                | ShellSort (обычный)     | 63         | 29,447,611      | 21,199,577        |
|                | ShellSort (Кнут)        | 55         | 28,240,276      | 22,875,702        |
|                | ShellSort (Седжвик)     | 52         | 30,391,802      | 26,757,607        |
| **1,000,000**  |                         |            |                 |                   |
|                | QuickSort (рекурсивный) | 69         | 17,738,578      | 4,449,237         |
|                | QuickSort (нерекурсив.) | 73         | 24,949,728      | 5,095,677         |
|                | MergeSort               | 88         | 18,675,570      | 19,951,424        |
|                | ShellSort (обычный)     | 134        | 69,534,677      | 52,037,095        |
|                | ShellSort (Кнут)        | 125        | 69,755,388      | 58,360,297        |
|                | ShellSort (Седжвик)     | 112        | 64,867,328      | 57,036,576        |
| **2,000,000**  |                         |            |                 |                   |
|                | QuickSort (рекурсивный) | 143        | 34,851,166      | 9,681,670         |
|                | QuickSort (нерекурсив.) | 150        | 52,714,995      | 11,010,319        |
|                | MergeSort               | 181        | 39,348,864      | 41,902,848        |
|                | ShellSort (обычный)     | 272        | 149,884,908     | 112,887,731       |
|                | ShellSort (Кнут)        | 279        | 168,002,934     | 144,082,459       |
|                | ShellSort (Седжвик)     | 242        | 141,201,977     | 124,722,375       |
| **5,000,000**  |                         |            |                 |                   |
|                | QuickSort (рекурсивный) | 365        | 90,235,089      | 26,833,672        |
|                | QuickSort (нерекурсив.) | 378        | 136,728,233     | 30,602,997        |
|                | MergeSort               | 468        | 105,051,733     | 111,611,392       |
|                | ShellSort (обычный)     | 980        | 449,903,303     | 347,415,140       |
|                | ShellSort (Кнут)        | 1,137      | 611,894,076     | 547,838,470       |
|                | ShellSort (Седжвик)     | 676        | 421,066,546     | 376,004,413       |
| **10,000,000** |                         |            |                 |                   |
|                | QuickSort (рекурсивный) | 725        | 185,837,123     | 57,959,601        |
|                | QuickSort (нерекурсив.) | 742        | 285,843,916     | 65,851,390        |
|                | MergeSort               | 955        | 220,101,124     | 233,222,784       |
|                | ShellSort (обычный)     | 2,130      | 1,046,461,803   | 831,476,134       |
|                | ShellSort (Кнут)        | 2,762      | 1,688,399,955   | 1,553,305,711     |
|                | ShellSort (Седжвик)     | 1,578      | 1,069,797,462   | 975,486,072       |

---

### Наблюдения:
1. **Скорость**:
   - **QuickSort** (рекурсивный) демонстрирует наилучшее время для всех размеров массивов.
   - **ShellSort (Седжвик)** быстрее других вариантов ShellSort, особенно на больших данных (5M и 10M элементов).

2. **Сравнения**:
   - **MergeSort** имеет меньше сравнений, чем ShellSort, но больше, чем QuickSort.
   - **ShellSort (Кнут)** требует больше сравнений, чем другие варианты ShellSort на больших массивах.

3. **Перестановки**:
   - **QuickSort** имеет наименьшее количество перестановок.
   - **ShellSort** (все варианты) требует значительно больше перестановок, особенно на больших данных.

4. **Общий вывод**:
   - Для малых и средних данных **QuickSort (рекурсивный)** оптимален.
   - Для больших данных **ShellSort (Седжвик)** может быть предпочтительнее других вариантов ShellSort.
   - **MergeSort** стабилен, но уступает QuickSort по скорости и количеству операций.
```