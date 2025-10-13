//
//  ParameterInfoSection.swift
//  iosApp
//
//  Created by Darren on 2025-10-12.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI

struct ParameterInfoSection: View {
    var body: some View {
        VStack(alignment: .center, spacing: 12) {
            ZStack {
                Circle()
                    .fill(Color.yellow.opacity(0.4))
                    .frame(width: 150, height: 150)
                Text("Logo App")
                    .font(.system(size: 24, weight: .bold))
            }

            Text("Version 0.0.1")
                .font(.system(size: 16))

            Text("Sortie le 2 février 2025")
                .font(.system(size: 16))

            Spacer().frame(height: 16)

            Text("About us")
                .font(.system(size: 18, weight: .bold))
                .foregroundColor(.blue)

            Text("Lorem ipsum lorem ipsum lorem ipsum")
                .multilineTextAlignment(.center)
                .padding(.horizontal, 32)

            VStack(alignment: .leading, spacing: 8) {
                HStack {
                    Text("Contact ->")
                    Link("contact@email.com", destination: URL(string: "mailto:contact@email.com")!)
                        .foregroundColor(.blue)
                }

                HStack {
                    Text("Feedback ->")
                    Link("google forms", destination: URL(string: "https://forms.google.com")!)
                        .foregroundColor(.blue)
                }

                HStack {
                    Text("Privacy ->")
                    Link("https://my-site.com", destination: URL(string: "https://my-site.com")!)
                        .foregroundColor(.blue)
                }
            }
            .padding(.top, 8)
        }
        .padding(16)
        .frame(maxWidth: .infinity, alignment: .center)
    }
}
