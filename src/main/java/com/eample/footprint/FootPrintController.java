package com.eample.footprint;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/footprint")
public class FootPrintController {
    private UserRepository userRepository;



    public FootPrintController(UserRepository userRepository){
        
        this.userRepository = userRepository;
    }
    @GetMapping("/{requestedId}")
    public ResponseEntity<FootPrint> findById(@PathVariable Long requestedId){
        User user = new User( "Johnnie", "5.9", 192.2, "Typical", "Active");
        FootPrint footPrint = new FootPrint(1L, user);

        if(requestedId.equals(1L)){
            return ResponseEntity.ok(footPrint);
        }else {

            return ResponseEntity.notFound().build();
        }
    }

//    @GetMapping("/{requestedId}/user")
//    public ResponseEntity<User> findUser(@PathVariable Long requestedId){
//        Optional<User> userOptional= userRepository.findById(requestedId);
//        if(userOptional.isPresent()){
//            User user = new User("Johnnie", "5.9", 192.2, "Typical", "Active");
//            return ResponseEntity.ok(user);
//        }
//        else{
//            return ResponseEntity.notFound().build();
//        }
//    }
//    @GetMapping("/{requestedId}/user/Vehicle")
//    public ResponseEntity<Vehicle> findByUser(@PathVariable Long requestedId){
//        Optional<User> userOptional= userRepository.findById(requestedId);
//        if(userOptional.isPresent()){
//            User user1 = new User("Johnnie", "5.9", 192.2, "Typical", "Active");
//            Vehicle vehicle = new Vehicle (user1, "Nissan", "PathFinder", "2006");
//            return ResponseEntity.ok(vehicle);
//        } else{
//            return ResponseEntity.notFound().build();
//        }
//    }

    //TODO: Finish this Later
    // @PostMapping
    // private ResponseEntity<Void> createUser(@RequestBody User newUser, UriComponentsBuilder ucb){
        
    //     URI locationOfUser = ucb
    //         .path("user/{id}")
        
    //     return ResponseEntity.created(locationOfUser).build();
    // }
}


