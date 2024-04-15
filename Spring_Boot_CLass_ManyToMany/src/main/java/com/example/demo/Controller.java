package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class Controller {

	@Autowired
	private TeacherRepo teachRepo;
	
	@Autowired
	private CourseRepo courRepo;
	
	@PostMapping("/teacher")
	public Teacher addTecaher(@RequestBody Teacher teacher) {
		return teachRepo.save(teacher);
	}
	
	@GetMapping("/tecaher/{pageNumber}/{pageSize}")
	public Page<Teacher> getAllTeacher(@PathVariable Integer pageNumber,@PathVariable Integer pageSize,@RequestParam(defaultValue="id") String sortBy){
		Pageable pageable = PageRequest.of(pageNumber,pageSize,Sort.by(sortBy));
		return teachRepo.findAll(pageable);
	}
	
	@GetMapping("/course/{pageNumber}/{pageSize}")
	public Page<Course> getAllcourse(@PathVariable Integer pageNumber,@PathVariable Integer pageSize,@RequestParam(defaultValue="id") String sortBy){
		Pageable pageable = PageRequest.of(pageNumber,pageSize,Sort.by(sortBy));
		return courRepo.findAll(pageable);
	}
	
	
	@PostMapping("/course")
	public Course addCourse(@RequestBody Course teacher) {
		return courRepo.save(teacher);
	}

	@PutMapping("/teacher/{id}")
	public Teacher updateteacher(@RequestBody Teacher teacher, @PathVariable Long id) throws Exception {
		Teacher tech = teachRepo.findById(id).orElseThrow(()->new Exception("no"+id));
		
		tech.setName(teacher.getName());
		return teachRepo.save(tech);
	}
	
	@PutMapping("/course/{id}")
	public Course updatecourse(@RequestBody Course teacher, @PathVariable Long id) throws Exception {
		Course tech = courRepo.findById(id).orElseThrow(()->new Exception("no"+id));
		
		tech.setName(teacher.getName());
		return courRepo.save(tech);
	}
	
	@DeleteMapping("/teacher/{id}")
	public void del(@PathVariable Long id) {
		teachRepo.deleteById(id);
	}
	
	@DeleteMapping("/course/{id}")
	public void dele(@PathVariable Long id) {
		courRepo.deleteById(id);
	}

}
