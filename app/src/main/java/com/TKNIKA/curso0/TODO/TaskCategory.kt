package com.TKNIKA.curso0.TODO

sealed class TaskCategory (var isSelected: Boolean = true){           //sealed quiere decir... está explicado en un vídeo
    object Personal: TaskCategory()
    object Business: TaskCategory()
    object Other: TaskCategory()
}

