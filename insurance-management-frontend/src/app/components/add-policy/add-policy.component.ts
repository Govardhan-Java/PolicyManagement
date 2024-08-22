import { Component } from '@angular/core';
import { PolicyService } from '../services/policy.service';

@Component({
  selector: 'app-add-policy',
  templateUrl: './add-policy.component.html'
})
export class AddPolicyComponent {
  policy = {
    name: '',
    type: '',
    premium: 0,
    startDate: '',
    endDate: ''
  };

  constructor(private policyService: PolicyService) {}

  addPolicy(): void {
    this.policyService.addPolicy(this.policy).subscribe();
  }
}
