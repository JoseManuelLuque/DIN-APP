package com.jluqgon214.app.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jluqgon214.app.model.User

class loginViewModel : ViewModel() {
    private val _selectedBottomBarItem = MutableLiveData(0)
    val selectedBottomBarItem: LiveData<Int> get() = _selectedBottomBarItem

    fun updateSelectedBottomBarItem(newItem: Int) {
        _selectedBottomBarItem.value = newItem
    }

    private val _email = MutableLiveData<String>("")
    val email: LiveData<String> get() = _email

    private val _password = MutableLiveData<String>("")
    val password: LiveData<String> get() = _password

    private val _confirmPassword = MutableLiveData<String>("")
    val confirmPassword: LiveData<String> get() = _confirmPassword

    val registeredUsers = mutableListOf<User>(User("a", "a", "Josema"))

    fun registerUser(user: User) {
        registeredUsers.add(user)
    }

    fun updateEmail(newEmail: String) {
        _email.value = newEmail // Función para actualizar el valor de email
    }

    fun updateConfirmPassword(newConfirmPassword: String) {
        _confirmPassword.value = newConfirmPassword
    }

    fun updatePassword(newPassword: String) {
        _password.value = newPassword
    }

    private val _name = MutableLiveData<String>("")
    val name: LiveData<String> get() = _name

    fun updateName(newName: String) {
        _name.value = newName
    }
}