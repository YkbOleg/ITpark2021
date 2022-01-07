### Задание 14. Основное
Реализовать сущность «Телефонный справочник», в котором разместить такие важные атрибуты как информацию об абоненте - ФИО, номере телефона, списке связанных контактов. По желанию, можно разместить принадлежность к оператору сотовой связи (в виде перечисления – Мегафон, Билайн, МТС, Теле2, с хранением пула кодов оператора), признак городской/сотовый.

• После этого заполнить 10000 (в зависимости от размера установленной на ПК памяти, можно и больше) данных сущностей произвольными значениями, а для их хранения следует воспользоваться такими коллекциями, как список, множество и карта записей (очередь опционально использовать).

• Попытаться «оббежать» данные (можно в обратном порядке) и найти телефонные номера, которые наиболее популярны у других абонентов (т.е. найти часто встречающиеся номера в списке связанных контактов). Для тех же самых целей воспользоваться обычными массивами данных, сравнив их производительность, замерив время работы программы в каждом отдельном случае.

• В итоге, определить насколько целесообразно хранить такие объемы данных в коллекциях или лучше воспользоваться привычными массивами

### Задание 14. Опциональное
Исследовать как влияет hashCode на поиск элементов, в частности сравнить как будет осуществляться поиск элементов в коллекциях, когда методы хэшкода возвращают уникальные значения, а когда одинаковое. Как это отразится на производительности.