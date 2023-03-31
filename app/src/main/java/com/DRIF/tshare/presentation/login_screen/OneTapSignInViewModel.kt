package com.DRIF.tshare.presentation.login_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.DRIF.tshare.domain.model.AuthUser
import com.DRIF.tshare.domain.repository.FirebaseRepository
import com.DRIF.tshare.domain.repository.GoogleSignInRepository
import com.DRIF.tshare.util.Resource
import com.google.firebase.auth.AuthCredential
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OneTapSignInViewModel @Inject constructor(
    private val repository: GoogleSignInRepository,

    ) : ViewModel() {

    private val _googleSignInState: MutableStateFlow<SignInWithGoogleState> = MutableStateFlow(
        SignInWithGoogleState()
    )
    val googleSignInState: StateFlow<SignInWithGoogleState> = _googleSignInState

    fun signInWithGoogleCredentials(credential: AuthCredential,user: AuthUser) = viewModelScope.launch {

        repository.signInWithCredential(credential, user ).collect { result ->
            when (result) {
                is Resource.Loading -> {
                    _googleSignInState.value = SignInWithGoogleState(isLoading = true)
                }
                is Resource.Success -> {
                    _googleSignInState.value = SignInWithGoogleState(success = result.data)
                }
                is Resource.Error -> {
                    _googleSignInState.value = SignInWithGoogleState(error = result.message)
                }
            }


        }
    }

}