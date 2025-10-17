//
//  AppAlertDialog.swift
//  iosApp
//
//  Created by Darren on 2025-10-12.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI
import shared

struct AlertDialog: View {
    @Binding var isPresented: Bool
    
    var body: some View {
        VStack {
            Text(IosStringResources(id:SharedRes.strings().survey_feedback_title,args:[]))
                .font(.headline)
                .padding()

            Text(IosStringResources(id:SharedRes.strings().survey_feedback_message,args:[]))
                .font(Font.custom(.pBody))
                .padding()

            Button(IosStringResources(id:SharedRes.strings().accept_text_button,args:[])) {
                isPresented = false
            }
            .padding()
        }
        .frame(width: 300)
        .background(Color.background)
        .cornerRadius(12)
        .shadow(radius: 10)
    }
}
