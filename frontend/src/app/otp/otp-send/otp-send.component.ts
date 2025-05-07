import { Component, signal, WritableSignal } from '@angular/core';
import {
  FormBuilder,
  FormGroup,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
import { LoadingComponent } from '../../components/loading/loading.component';
import { timeout } from 'rxjs';

@Component({
  selector: 'app-otp-send',
  imports: [ReactiveFormsModule, LoadingComponent],
  templateUrl: './otp-send.component.html',
})
export class OtpSendComponent {
  isLoading: WritableSignal<boolean> = signal(false);

  otpSendForm: FormGroup;
  constructor(private fb: FormBuilder) {
    this.otpSendForm = fb.group({
      email: ['', [Validators.required, Validators.email]],
      organization: ['', [Validators.required]],
    });
  }

  sendOtp(): void {
    this.isLoading.set(true);
    setTimeout(() => {
      this.isLoading.set(false);
    }, 2000);
  }
}
