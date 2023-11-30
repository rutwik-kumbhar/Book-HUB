import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import {
  FormBuilder,
  FormGroup,
  Validators,
  ReactiveFormsModule,
} from '@angular/forms';
import { BookService } from 'src/service/book.service';

@Component({
  selector: 'app-add-book',
  templateUrl: './add-book.component.html',
  styleUrls: ['./add-book.component.css'],
})
export class AddBookComponent {
  selectedFile: File | null = null;
  bookForm?: FormGroup;

  constructor(private fb: FormBuilder, private http: HttpClient) {}

  ngOnInit() {
    this.bookForm = this.fb.group({
      file: [''],
      title: [''],
      author: [''],
      genre: [''],
      description: [''],
      category: [''],
      price: [0],
      discountedPercentage: [0],
      quantity: [0],
    });
  }

  onFileSelected(event: any) {
    this.selectedFile = event.target.files[0] as File;
  }

  onUpload() {
    if (this.selectedFile) {
      const formData = new FormData();
      formData.append('file', this.selectedFile);

      if (this.bookForm) {
        const formValue = this.bookForm.value;

        Object.keys(formValue).forEach((key) => {
          formData.append(key, formValue[key]);
        });

        console.log(formData)

        // this.http.post('http://localhost:5050/books/add', formData).subscribe(
        //   (response) => {
        //     console.log('Upload successful', response);
        //     // Handle success, e.g., show a success message
        //   },
        //   (error) => {
        //     console.error('Error uploading file', error);
        //     // Handle error, e.g., show an error message
        //   }
        // );
      }else{
        console.error('Form is not initialized.');
      }
    } else {
      console.warn('No file selected');
      // Handle the case where no file is selected
    }
  }

  }