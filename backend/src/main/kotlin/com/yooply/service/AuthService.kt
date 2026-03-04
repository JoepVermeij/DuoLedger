package com.yooply.service

import com.yooply.dto.AuthResponse
import com.yooply.dto.LoginRequest
import com.yooply.dto.RegisterRequest
import com.yooply.model.User
import com.yooply.repository.UserRepository
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
