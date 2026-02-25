package com.pairledger.service

import com.pairledger.dto.AuthResponse
import com.pairledger.dto.LoginRequest
import com.pairledger.dto.RegisterRequest
import com.pairledger.model.User
import com.pairledger.repository.UserRepository
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class AuthService(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder,
    private val jwtService: JwtService
) {

    fun register(request: RegisterRequest): AuthResponse {
        if (userRepository.existsByEmail(request.email)) {
            throw IllegalArgumentException("Email already in use")
        }

        val user = userRepository.save(
            User(
                email = request.email,
                passwordHash = passwordEncoder.encode(request.password),
                displayName = request.displayName
            )
        )

        val token = jwtService.generateToken(user.id.toString(), user.email)
        return AuthResponse(
            token = token,
            userId = user.id.toString(),
            email = user.email,
            displayName = user.displayName
        )
    }

    fun login(request: LoginRequest): AuthResponse {
        val user = userRepository.findByEmail(request.email)
            ?: throw IllegalArgumentException("Invalid credentials")

        if (!passwordEncoder.matches(request.password, user.passwordHash)) {
            throw IllegalArgumentException("Invalid credentials")
        }

        val token = jwtService.generateToken(user.id.toString(), user.email)
        return AuthResponse(
            token = token,
            userId = user.id.toString(),
            email = user.email,
            displayName = user.displayName
        )
    }
}
