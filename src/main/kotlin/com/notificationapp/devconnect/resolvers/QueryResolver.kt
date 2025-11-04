package com.notificationapp.devconnect.resolvers

import com.notificationapp.devconnect.entities.Comment
import com.notificationapp.devconnect.entities.Post
import com.notificationapp.devconnect.entities.User
import com.notificationapp.devconnect.repositories.CommentRepository
import com.notificationapp.devconnect.repositories.LikeRepository
import com.notificationapp.devconnect.repositories.PostRepository
import com.notificationapp.devconnect.repositories.UserRepository
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.BatchMapping
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.stereotype.Controller
import reactor.core.publisher.Mono
import reactor.core.scheduler.Schedulers

@Controller
class QueryController (private val userRepository: UserRepository, private val postRepository: PostRepository, private val likeRepository: LikeRepository, private val commentRepository: CommentRepository){

    @QueryMapping
    fun postsByUser(@Argument userId: String): List<Post> {
        return postRepository.findByAuthorUserId(userId)
    }

    @QueryMapping
    fun postComments(@Argument postId: String): List<Comment> {
        return commentRepository.findByPostPostId(postId)
    }

    @QueryMapping
    fun getUser(@Argument userId: String): User? {
        return userRepository.findUserByUserId(userId)
    }

    @QueryMapping
    fun getUsers(): List<User> {
        return userRepository.findAll()
    }

    @QueryMapping
    fun getPosts(): List<Post> {
        return postRepository.findAll()
    }

    @BatchMapping(typeName="Post", field="comments")
    fun comments(posts: List<Post>): Mono<Map<Post, List<Comment>>> {
        return Mono.fromCallable {
            val ids = posts.map{ it.postId }
            val comments = commentRepository.findByPostPostIdIn(ids)
            comments.groupBy { it.post }
        }.subscribeOn(Schedulers.boundedElastic())
    }

}
