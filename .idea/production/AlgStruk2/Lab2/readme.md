## Лабораторная работа №2

---

#### На завершающих этапах быстрой сортировки (QuickSort) для небольших подмассивов (обычно при размере ≤ 10 элементов) часто используется сортировка вставками (Insertion Sort). Это связано с тем, что для малых массивов сортировка вставками эффективнее из-за меньших накладных расходов по сравнению с рекурсивными вызовами QuickSort.\


| Размер массива | Время (мс) | Перестановок   |
|----------------|------------|----------------|
| 100,000        | 12         | 395,537        |
| 500,000        | 38         | 2,364,631      |
| 1,000,000      | 81         | 5,050,116      |
| 2,000,000      | 162        | 11,000,458     |
| 5,000,000      | 411        | 30,544,359     |
| 10,000,000     | 835        | 66,143,335     |

---

## Выводы:

- По идее сортировка должна быть быстрее сортировки Шелла, но она медленнее. Но в это же время количество перестановок сократилось в ~5 раз.