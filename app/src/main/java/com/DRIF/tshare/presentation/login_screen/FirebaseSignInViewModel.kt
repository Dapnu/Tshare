package com.DRIF.tshare.presentation.login_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.DRIF.tshare.domain.model.AuthUser
import com.DRIF.tshare.domain.repository.FirebaseRepository
import com.DRIF.tshare.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FirebaseSignInViewModel @Inject constructor(
    private val firebaseRepository: FirebaseRepository
) : ViewModel() {

    private val _signInState = Channel<FirebaseSignInState>()
    val signInState = _signInState.receiveAsFlow()

    val currentUserExist = firebaseRepository.currentUserExist()

    fun loginUser(user: AuthUser) = viewModelScope.launch {
        firebaseRepository.firebaseSignIn(user).collect {result ->
            when(result){
                is Resource.Loading -> {
                    _signInState.send(FirebaseSignInState(isLoading = true))
                }
                is Resource.Success -> {
                    _signInState.send(FirebaseSignInState(isSignedIn = "Signed In Successful"))

                }
                is Resource.Error -> {
                    _signInState.send(FirebaseSignInState(error = result.message))
                }
            }

        }
    }


}