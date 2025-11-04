package com.notificationapp.devconnect.resolvers

import com.notificationapp.devconnect.entities.Comment
import com.notificationapp.devconnect.entities.Post
import com.notificationapp.devconnect.entities.User
import com.notificationapp.devconnect.repositories.CommentRepository
import com.notificationapp.devconnect.repositories.LikeRepository
import com.notificationapp.devconnect.repositories.PostRepository
import com.notificationapp.devconnect.services.UserService
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.MutationMapping
import org.springframework.stereotype.Controller


@Controller
class MutationResolver (private val userService: UserService, private val postRepository: PostRepository, private val likeRepository: LikeRepository, private val commentRepository: CommentRepository){
    @MutationMapping
    fun addUser(@Argument userId: String,
                @Argument username: String,
                @Argument bio: String): User {
        val newUser = User(userId, username, bio)
        return userService.addUser(newUser)
    }

    @MutationMapping
    fun addPost(
        @Argument postId: String,
        @Argument content: String,
        @Argument authorId: String,
        @Argument createdAt: String
    ): Post {

        val user = userService.findUser(authorId)
        val newPost = Post(postId, content, user, createdAt)
        return postRepository.save(newPost)
    }

    @MutationMapping
    fun addComment(
        @Argument commentId: String,
        @Argument postId: String,
        @Argument authorId: String,
        @Argument text: String,
        @Argument createdAt: String
    ): Comment {
        val user = userService.findUser(authorId)
        val post = postRepository.findByPostId(postId)
        val newComment = Comment(commentId, post, user, text, createdAt)
        return commentRepository.save(newComment)
    }
}